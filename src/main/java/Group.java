import java.util.ArrayList;

/**
 * The group class contains all methods and functions required by the different groups on the board, this being properties, utilities and stations.
 */
public class Group extends ArrayList<Ownable> {

    /**
     * colour: Colour
     * The colour code for the colour of this particular group.
     */
    private Colour colour;


    /**
     * Constructor
     */
    public Group() {
        super();
        this.colour = Colour.White;
    }

    /**
     * getGroupOwners
     *
     * @return players
     */
    public ArrayList<Player> getGroupOwners() {
        ArrayList<Player> players = new ArrayList<>();

        for (Ownable tile : this) {
            Player player = tile.getOwner();
            players.add(player);
        }
        return players;
    }

    /**
     * getColour
     *
     * @return String containing the colour code
     * Gets the colour for this street.
     */
    public Colour getColour() {
        return this.colour;
    }

    /**
     * setColour
     *
     * @param colour The colour for this street
     *               Sets the colour of this group
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * isGroupAllOwned
     *
     * @param player The player we are checking against
     * @return Boolean, true if all ownables owned by the player
     * Check if a player owns the group.
     */
    public boolean isGroupAllOwned(Player player) {
        for (Ownable ownable : this) {
            if (ownable.getOwner() == null || !ownable.getOwner().equals(player)) {
                return false;
            }
        }
        return true;
    }

    /**
     * getAmountOwned
     *
     * @param player A Player
     * @return Amount of ownables that player owns in this group
     * This method returns the number of the ownables that a player owns in this group
     */
    public int getAmountOwned(Player player) {
        int count = 0;
        for (Ownable ownable : this) {
            if (ownable instanceof Station) {
                if (ownable.getOwner() != null && ownable.getOwner().equals(player)) {
                    count++;
                }
            }
        }
        return count;
    }

}
