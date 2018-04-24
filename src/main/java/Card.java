public class Card extends Tile{

    /**
     * cardType: CardType
     * The type of card tile e.g. Plot Luck
     */
    private CardType cardType;

    /**
     * Card
     * @param tileName
     * @param tilePosition
     * @param cardType
     */
    public Card(String tileName, int tilePosition, CardType cardType) {
        super(tileName, tilePosition);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
