import java.util.ArrayList;

public class Card {

    private ArrayList<CardAction> actions;

    public Card() {
        this.actions = new ArrayList<>();
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

}
