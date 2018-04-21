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

    public Group() {
        this.group = new ArrayList<>();
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


    public ArrayList<Player> getGroupOwners(Ownable ownable) {
        ArrayList<Player> players = new ArrayList<>();

        if (ownable.getGroup() != null) {
            for (Ownable owned : ownable.getGroup().getGroup()) {
                players.add(owned == null ? null : owned.getOwner());
            }
        }
        return players;
    }

}
