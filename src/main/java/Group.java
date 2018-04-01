/**
 * The group class contains all methods and functions required by the different groups on the board, this being properties, utilities and stations.
 */
public class Group {

    /**
     * groups: [Group]
     * This array of groups are all properties on the board that are assigned a group.
     */
    private Group[] groups;

    /**
     * getGroups
     * @return An array of property groups
     * This method gets all groups of properties on the game board.
     */
    public Group[] getGroups() {
        return this.groups;
    }

    /**
     * setGroups
     * @param groups An array of property groups
     * This method sets all groups of properties on the game board for initialisation.
     */
    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    /**
     * add
     * @param group A group
     * This method adds a group of properties on the game board for initialisation.
     */
    public void add(Group group){

    }
}
