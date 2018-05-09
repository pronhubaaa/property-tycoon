public class TaxTile extends Tile {

    /**
     * fee: Int
     * The value of money the player needs to pay.
     */
    private int amount;

    /**
     * TaxTile
     *
     * @param tileName
     * @param tilePosition
     * @param tileValue
     */
    public TaxTile(String tileName, int tilePosition, int tileValue) {
        super(tileName, tilePosition);
        this.amount = tileValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean payTax(Player player) {
        return player.attemptDebit(amount);
    }

}
