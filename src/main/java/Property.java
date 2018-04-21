import java.util.ArrayList;

public class Property extends Ownable {

    /**
     * rent: [Int]
     * This is an array of the price of rent on the property, each slot will represent as follows:
     * [0] The standard rent
     * [1] The rent with one house
     * [2] The rent with two houses
     * [3] The rent with three houses
     * [4] The rent with four houses
     * [5] The rent with a hotel
     */
    private ArrayList<Integer> rent;

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

    public ArrayList<Integer> getRent() {
        return rent;
    }

    public void setRent(ArrayList<Integer> rent) {
        this.rent = rent;
    }

    public int getCostOfHouse() {
        return costOfHouse;
    }

    public void setCostOfHouse(int costOfHouse) {
        this.costOfHouse = costOfHouse;
    }

    public void addHouses(int amount) {
        int charge = amountOfHouses == 4 ? costOfHouse * 4 : costOfHouse;
        amountOfHouses += amount;
    }

    public void removeHouses(int amount) {

        amountOfHouses -= amount;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    /**
     * @param player the player to apply the rent payment to
     */
    public boolean applyPayment(Player player) {
        int rent = getRent().get(amountOfHouses);
        if (isOwned()) {
            if (getGroup().isAllOwned(getOwner())) {
                rent *= 2;
            }
            // TODO @Issue #17
        } else {
            // TODO @Issue #17
        }
        // TODO @Issue #17
        return true;
    }
}
