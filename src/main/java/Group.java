import java.util.ArrayList;

/**
 * The group class contains all methods and functions required by the different groups on the board, this being properties, utilities and stations.
 */
public class Group {

    /**
     * groups: [Group]
     * This array of groups are all properties on the board that are assigned a group.
     */
    private ArrayList<Ownable> group;

    /**
     * colour: Colour
     * The colour code for the colour of this particular group.
     */
    private Colour colour;


    /**
     * Constructor
     */
    public Group() {
        this.group = new ArrayList<>();
        this.colour = Colour.White;
    }

    /**
     * getGroups
     *
     * @return An array of property groups
     * This method gets all groups of properties on the game board.
     */
    public ArrayList<Ownable> getGroup() {
        return this.group;
    }

    /**
     * setGroups
     *
     * @param ownables An array of property groups
     *                 This method sets all groups of properties on the game board for initialisation.
     */
    public void setGroups(ArrayList<Ownable> ownables) {
        this.group = ownables;
    }

    /**
     * add
     *
     * @param ownable A group
     *                This method adds a group of properties on the game board for initialisation.
     */
    public void add(Ownable ownable) {
        this.group.add(ownable);

    }


    /**
     * getGroupOwners
     * @return players
     */
    public ArrayList<Player> getGroupOwners(){
        ArrayList<Player> players = new ArrayList<>();

        for(Ownable tile: this.getGroup()){
            Player player = tile.getOwner();
            players.add(player);
        }
        return players;
    }


    /**
     * getColour
     * @return String containing the colour code
     * Gets the colour for this street.
     */
    public Colour getColour() {
        return this.colour;
    }

    /**
     * setColour
     * @param colour The colour for this street
     * Sets the colour of this group
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }



}
