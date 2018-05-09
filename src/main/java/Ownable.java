public abstract class Ownable extends Tile {

    /**
     * owner: Player
     * This is the player who owns this tile.
     */
    private Player owner;

    /**
     * price: Int
     * This is the price for this tile.
     */
    private int price;

    /**
     * mortgagePrice: Int
     * This is the mortgage price for this tile.
     */
    private int mortgagePrice;


    /**
     * sellPrice: Int
     * The price this property is worth, given all houses/hotels.
     */
    private int sellPrice;

    /**
     * mortgaged: Boolean
     * A boolean to say if the ownable is mortgaged or not.
     */
    private boolean mortgaged;

    /**
     * group: Group
     * A group variable holding the ownable group
     */
    private Group group;


    /**
     * Ownable constructor
     *
     * @param name
     * @param position
     * @param group
     */
    public Ownable(String name, int position, Group group) {
        super(name, position);
        this.group = group;
        this.owner = null;
    }

    public boolean isOwned() {
        return owner != null;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMortgagePrice() {
        return mortgagePrice;
    }

    public void setMortgagePrice(int mortgagePrice) {
        this.mortgagePrice = mortgagePrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Safely attempt to take rent from $player, returning the result of the transaction.
     *
     * @param player    The player to be debited.
     * @param diceValue The total dice value of the previous roll.
     * @return Whether the result of the transaction was successful.
     */
    public boolean applyRentPayment(Player player, int diceValue) {
        return player.attemptDebit(calculateRent(player, diceValue));
    }

    /**
     * Calculate applicable rent for $player.
     *
     * @param player    The player to calculate the rent for.
     * @param diceValue The total dice value of the previous roll.
     * @return The rent due to be paid by $player.
     */
    public abstract int calculateRent(Player player, int diceValue);
}
