public class CardTile extends Tile {

    private CardStack cardStack;

    public CardTile(String name, int position, CardStack cardStack) {
        super(name, position);
        this.cardStack = cardStack;
    }

    public CardStack getCardStack() {
        return cardStack;
    }

    public void setCardStack(CardStack cardStack) {
        this.cardStack = cardStack;
    }
}
