import java.util.ArrayList;

public class Property extends Ownable {

    /**
     * rent: [Int]
     * This is an array of the price of rent on the property, each slot will represent as follows:
     * [0] The standard rent
     * [1] The rent when the group is owned
     * [2] The rent with one house
     * [3] The rent with two houses
     * [4] The rent with three houses
     * [5] The rent with four houses
     * [6] The rent with a hotel
     */
    private ArrayList<Integer> rent;

    /**
     * costOfHouse: Int
     * This integer represents the cost to put a house on this property.
     */
    private int costOfHouse;

    /**
     * amountOfHouses: Int
     * The amount of houses on the property.
     */
    private int amountOfHouses;

    public Property(String name, int position, Group group) {
        super(name, position, group);

    }

    /**
     * getRent(): [Int]
     *
     * @return Array of prices the rent may be
     */
    public ArrayList<Integer> getRent() {
        return rent;
    }

    /**
     * setRent([Int]): Void
     * This sets an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'.
     *
     * @param rent Array of prices for the rent
     */
    public void setRent(ArrayList<Integer> rent) {
        this.rent = rent;
    }

    /**
     * getCostOfHouse(): Int
     *
     * @return The price to put a house on the property
     */
    public int getCostOfHouse() {
        return costOfHouse;
    }

    /**
     * setCostOfHouse(Int): Void
     * This method allows the price to buy a house on this property to be set.
     *
     * @param costOfHouse Price for a house on this property
     */
    public void setCostOfHouse(int costOfHouse) {
        this.costOfHouse = costOfHouse;
    }


    /**
     * addHouses(Int): Void
     * Add houses to the property.
     *
     * @param amountOfHouses Amount of houses to add
     */
    public void addHouses(int amountOfHouses) {
        this.amountOfHouses += amountOfHouses;
    }

    /**
     * addHouses(): Void
     * Add a house to the property. Included for backwards-compatibility to previous spec.
     */
    @Deprecated
    public void addHouses() {
        addHouses(1);
    }

    /**
     * getAmountOfHouses(): Int
     * @return amountOfHouses amount of houses on a property
     */
    public int getAmountOfHouses() {
        return this.amountOfHouses;
    }

    /**
     * removeHouses(Int): Void
     * Remove houses from the property.
     *
     * @param amountOfHouses Amount of houses to remove
     */
    public void removeHouses(int amountOfHouses) {
        this.amountOfHouses -= amountOfHouses;
        if (this.amountOfHouses < 0) {
            throw new IllegalArgumentException("More houses are being removed than exist on this property");
        }
    }
}
