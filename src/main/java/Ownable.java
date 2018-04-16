public class Ownable extends Tile {

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
     * This is the morgage price for this tile.
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


    public Ownable(String name, int position) {
        super(name, position);
    }

    /**
     * getOwner(): Player
     * This method returns the player who owns the tile.
     *
     * @return The player who owns the tile
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * setOwner(Player): Void
     * This method allows a player to own the tile.
     *
     * @param owner Assign a player to own this tile
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * getPrice(): Int
     * This method returns the price of this property.
     *
     * @return The price for this tile
     */
    public int getPrice() {
        return price;
    }

    /**
     * setPrice(Int): Void
     * This method sets the price for the property for initialisation.
     *
     * @param price The given price for this tile
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * getMortgagePrice(): Int
     * This method gets the value given to the player for morgaging the property.
     *
     * @return The mortgage value of the property
     */
    public int getMortgagePrice() {
        return mortgagePrice;
    }

    /**
     * setMortgagePrice(Int): Void
     * This method will set the morgage price for the property.
     *
     * @param mortgagePrice The given morgage price for this tile
     */
    public void setMortgagePrice(int mortgagePrice) {
        this.mortgagePrice = mortgagePrice;
    }

    /**
     * isOwned(): Boolean
     * This method returns if the property is owned or not.
     *
     * @return Boolean, true if the tile has an owner
     */
    public boolean isOwned() {
        return owner != null;
    }

    /**
     * getSellPrice(): Int
     *
     * @return Gives the integer value that this property is worth given all houses/ hotels on the property.
     */
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * setSellPrice(Int): Void
     *
     * @param sellPrice Set a new value for selling this property.
     */
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * setMortgaged(Boolean): Void
     *
     * @param mortgaged Set property as mortgaged.
     */
    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    /**
     * isMortgaged(): Boolean
     */
    public boolean isMortgaged() {
        return this.mortgaged;
    }


}
