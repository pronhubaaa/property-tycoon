import java.util.ArrayList;

public class CardAction {

    /**
     * The action description.
     */
    private String description;

    /**
     * The type of action this action performs.
     */
    private CardActionType cardActionType;

    /**
     * The originating entity of the action.
     * cardActionType MOVE: blank indicates the current player tile.
     * cardActionType TRANSACTION: blank indicates the bank.
     */
    private Object origin;

    /**
     * The entity that the action operates on or to.
     * cardActionType MOVE: blank indicates the current player tile.
     * cardActionType TRANSACTION: blank indicates the bank.
     */
    private Object intent;

    /**
     * The value of the action.
     * TRANSACTION: The amount to be paid.
     * MOVE: The direction of the move (negative or positive).
     */
    private int value;

    /**
     * If $value is to be calculated, the amount per owned house.
     */
    private int amountPerHouse;

    /**
     * If $value is to be calculated, the amount per owned house.
     */
    private int amountPerHotel;

    /**
     * Whether, if during the performance of the action the player passes a Go tile, their salary should be collected.
     */
    private boolean collectSalaryAtGo;

    private Card card;

    public CardAction(CardActionType cardActionType, Card card, String description) {
        this.cardActionType = cardActionType;
        this.card = card;
        this.description = description;
        value = 0;
    }

    public CardAction(CardActionType cardActionType, Card card, String description, Object origin, Object intent, int value) {
        this.cardActionType = cardActionType;
        this.card = card;
        this.description = description;
        this.origin = origin;
        this.intent = intent;
        this.value = value;
    }

    public CardActionType getCardActionType() {
        return cardActionType;
    }

    public void setCardActionType(CardActionType cardActionType) {
        this.cardActionType = cardActionType;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public Object getIntent() {
        return intent;
    }

    public void setIntent(Object intent) {
        this.intent = intent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getAmountPerHouse() {
        return amountPerHouse;
    }

    public void setAmountPerHouse(int amountPerHouse) {
        this.amountPerHouse = amountPerHouse;
    }

    public int getAmountPerHotel() {
        return amountPerHotel;
    }

    public void setAmountPerHotel(int amountPerHotel) {
        this.amountPerHotel = amountPerHotel;
    }

    public boolean isCollectSalaryAtGo() {
        return collectSalaryAtGo;
    }

    public void setCollectSalaryAtGo(boolean collectSalaryAtGo) {
        this.collectSalaryAtGo = collectSalaryAtGo;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void performAction(Player player) throws MalformedCardActionException {
        switch(cardActionType) {
            case Draw:
                try {
                    assert(intent instanceof CardType);
                } catch (Exception e) {
                    throw new MalformedCardActionException("The intent of a Draw action must be a card type");
                }
                //TODO draw card
                break;
            case GetOutOfJailFree:
                player.addCard(card);
                break;
            case Move:
                int destination;
                ArrayList<Tile> tiles = player.getBoard().getTiles();
                if (intent instanceof Tile) {
                    destination = tiles.indexOf(intent);
                } else {
                    int move;
                    try {
                        move = (int) intent;
                    } catch (Exception e) {
                        throw new MalformedCardActionException("The intent of a Move action must be (direct) a tile or (relative) an integer");
                    }
                    destination = tiles.indexOf(player.getPosition()) + move;
                }
                destination = destination % tiles.size();
                if (destination < 0) {
                    destination = tiles.size() + destination - 1;
                }
                if (value <= 0) {
                    throw new MalformedCardActionException("The speed value of a player during a Move action cannot be zero");
                }
                if (collectSalaryAtGo) {
                    int i = tiles.indexOf(player.getPosition());
                    while (i != destination) {
                        Tile tile = tiles.get(i);
                        if (tile instanceof Go) {
                            ((Go) tile).collect(player);
                        }
                        i += value;
                        if (i == tiles.size()) {
                            i = 0;
                        }
                    }
                }
                player.setPosition(tiles.get(destination));

                break;
            case Transaction:
                int amount = value;
                if (amountPerHouse + amountPerHotel > 0) {
                    amount = getRelativeTransactionAmount(player, amountPerHouse, amountPerHotel);
                }
                if (origin instanceof Player) {
                    // TODO @Issue #17
                } else if (origin == null) {

                } else if (origin instanceof ArrayList<?>) {
                    ArrayList<?> list = (ArrayList) origin;
                    if (list.get(0) instanceof Player) {
                        // TODO @Issue 17
                    } else {
                        throw new MalformedCardActionException("The list of origins was of an invalid type");
                    }
                }
                if (intent instanceof Payable) {
                    ((Payable) intent).addBalance(amount);
                } else if (intent instanceof ArrayList<?>) {
                    ArrayList<?> list = (ArrayList) intent;
                    if (list.get(0) instanceof Payable) {
                        //noinspection unchecked
                        ArrayList<Payable> payees = (ArrayList<Payable>) list;
                        for (Payable payee : payees) {
                            payee.addBalance(amount);
                        }
                    } else {
                        throw new MalformedCardActionException("The list of intents was of an invalid type");
                    }
                } else {
                    throw new MalformedCardActionException("The transaction intent is not a valid payee");
                }
                break;
        }
    }

    private static int getRelativeTransactionAmount(Player player, int amountPerHouse, int amountPerHotel) {
        int amountOfHouses = 0;
        int amountOfHotels = 0;
        for (Ownable ownable : player.getOwnedTiles()) {
            if (ownable instanceof Property) {
                Property property = (Property) ownable;
                if (property.getAmountOfHouses() <= 4) {
                    amountOfHouses += property.getAmountOfHouses();
                } else {
                    amountOfHouses += 4;
                    amountOfHotels++;
                }
            }
        }
        return (amountOfHouses * amountPerHouse) + (amountOfHotels + amountPerHotel);
    }

    @Override
    public String toString() {
        return description;
    }
}
