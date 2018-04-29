import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class CardStack extends ArrayDeque<Card> {

    private CardType cardType;

    public CardStack(CardType cardType) {
        super();
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void shuffle() {
        ArrayList<Card> deck = new ArrayList<>();
        this.iterator().forEachRemaining(deck::add);
        Collections.shuffle(deck);
        this.clear();
        this.addAll(deck);
    }

    public static ArrayList<CardStack> initialiseCardStacks(GameEngine gameEngine, Board board, JSONObject jsonObject) throws MalformedJsonException {

        if (!jsonObject.containsKey(CardJsonField.Cards.toString())) {
            throw new MalformedJsonException("There is no cards array in the provided Cards JSON");
        }
        JSONArray jsonCards = jsonObject.getJSONArray(CardJsonField.Cards.toString());
        HashMap<CardType, CardStack> cardStacks = new HashMap<>();
        for (CardType cardType : CardType.values()) {
            cardStacks.put(cardType, new CardStack(cardType));
        }
        board.setCardStacks(cardStacks);
        for (Object cardObject : jsonCards) {
            JSONObject jsonCard = (JSONObject) cardObject;
            Card card = new Card();
            for (Object actionObject : jsonCard.getJSONArray("actions")) {
                JSONObject jsonAction = (JSONObject) actionObject;
                CardActionType actionType = CardActionType.fromString(jsonAction.getString(CardJsonField.ActionType.toString()));
                CardAction cardAction = new CardAction(actionType, card,
                        jsonAction.getString(CardJsonField.Description.toString()));
                if (jsonAction.containsKey("params")) {
                    for (Map.Entry<String, Object> actionField : jsonAction.getJSONObject("params").entrySet()) {
                        switch (CardJsonField.fromString(actionField.getKey())) {
                            case Intent:
                                cardAction.setIntent(getTransactionEntity(gameEngine, board, actionField.getValue().toString()));
                                break;
                            case Origin:
                                cardAction.setOrigin(getTransactionEntity(gameEngine, board, actionField.getValue().toString()));
                                break;
                            case Value:
                                cardAction.setValue(validateJsonIntField(actionField));
                                break;
                            case AmountHotel:
                                cardAction.setAmountPerHotel(validateJsonIntField(actionField));
                                break;
                            case AmountHouse:
                                cardAction.setAmountPerHouse(validateJsonIntField(actionField));
                                break;
                            case CollectSalary:
                                boolean salary;
                                try {
                                    salary = Boolean.parseBoolean(actionField.getValue().toString());
                                } catch (Exception e) {
                                    throw new MalformedJsonException("There was an unexpected non-boolean value");
                                }
                                cardAction.setCollectSalaryAtGo(salary);
                                break;
                        }
                    }
                }
                card.add(cardAction);
            }
            cardStacks.get(CardType.fromString((String) jsonCard.get("card_type"))).add(card);
        }
        return new ArrayList<CardStack>() {{
            addAll(cardStacks.values());
        }};
    }

    private static Object getTransactionEntity(GameEngine gameEngine, Board board, String jsonTransactionEntity) {
        CardJsonField intentEntity;
        try {
            intentEntity = CardJsonField.fromString(jsonTransactionEntity);
        } catch (Exception e) {
            return board.getTile(jsonTransactionEntity);
        }
        switch (intentEntity) {
            case PlayerIntentEntity:
                return "player";
            case FreeParkingIntentEntity:
                return board.getTile(CardJsonField.FreeParkingIntentEntity.toString());
            case JailIntentEntity:
                return board.getTile(CardJsonField.JailIntentEntity.toString());
            case PayableListIntentEntity:
                return gameEngine.getPlayers();
            case OpportunityKnocksIntentEntity:
                return board.getCardStacks().get(CardType.OpportunityKnocks);
            case PotLuckIntentEntity:
                return board.getCardStacks().get(CardType.PotLuck);
            default:
                return board.getTile(jsonTransactionEntity);
        }
    }

    private static int validateJsonIntField(Map.Entry<String, Object> CardJsonField) throws MalformedJsonException {
        int i;
        try {
            i = (int) CardJsonField.getValue();
        } catch (Exception e) {
            throw new MalformedJsonException("There was an unexpected non-integer value");
        }
        return i;

    }
}
