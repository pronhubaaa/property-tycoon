public class CardTile extends Tile {

    private CardStack cardStack;

    public CardTile(String name, int position, CardStack cardStack) {
        super(name, position);
        this.cardStack = cardStack;
    }

    /**
     * @return the card stack that this tile is associated with.
     */
    public CardStack getCardStack() {
        return cardStack;
    }

    /**
     * Set the card stack that this tile is to be associated with.
     *
     * @param cardStack The new card stack.
     */
    public void setCardStack(CardStack cardStack) {
        this.cardStack = cardStack;
    }
}
