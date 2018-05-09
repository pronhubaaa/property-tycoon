public class Property extends VariablyTieredRentable {


    /**
     * costOfHouse: Int
     * This integer represents the cost to put a house on this property.
     */
    private int costOfHouse;

    /**
     * costOfHotel:
     */

    /**
     * amountOfHouses: Int
     * The amount of houses on the property.
     */
    private int amountOfHouses;

    public Property(String name, int position, Group group) {
        super(name, position, group);
    }

    public int getCostOfHouse() {
        return costOfHouse;
    }

    public void setCostOfHouse(int costOfHouse) {
        this.costOfHouse = costOfHouse;
    }

    /**
     * @param player
     * @param amount
     * @return Whether the player may purchase the requested amount of houses.
     */
    public boolean addHouses(Player player, int amount) {
        if (amountOfHouses + amount > 5) {
            return false;
        } else {
            boolean transaction = player.attemptDebit(costOfHouse * amount);
            if (transaction) {
                amountOfHouses += amount;
            }
            return transaction;
        }
    }


    public void removeHouses(int amount) {
        // Does removing houses credit the player?
        amountOfHouses -= amount;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    /**
     * @param player the player to apply the rent payment to
     */
    public int calculateRent(Player player, int diceValue) {
        int rent = getRent().get(amountOfHouses);
        if (isOwned()) {
            if (getGroup().isGroupAllOwned(getOwner())) {
                rent *= 2;
            }
            return rent;
        } else {
            return 0;
        }
    }
}
