import java.util.ArrayList;

public class Card {

    private ArrayList<CardAction> actions;
    private CardStack cardStack;


    public Card(CardStack cardStack) {
        this.actions = new ArrayList<>();
        this.cardStack = cardStack;
    }

    public ArrayList<CardAction> getActions() {
        return actions;
    }

    public void setActions(ArrayList<CardAction> actions) {
        this.actions = actions;
    }

    public void addAction(CardAction action) {
        actions.add(action);
    }

    public CardStack getCardStack() {
        return cardStack;
    }

    public void setCardStack(CardStack cardStack) {
        this.cardStack = cardStack;
    }
}
