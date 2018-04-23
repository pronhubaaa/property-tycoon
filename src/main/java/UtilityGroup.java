/**
 * The utility group class is responsible for checking how many utilities a player owns
 */
public class UtilityGroup extends Group {

    /**
     * Constructor
     */
    public UtilityGroup(){
        super();
    }
    /**
     * checkOwnedUtility
     * @param player A player
     * @return The amount of utilities they own
     * This method returns the amount of utilities owned by a player
     */
    public int checkOwnedUtility(Player player){
        int count = 0;
        for(Ownable ownable: this.getGroup()){
            if(ownable != null && ownable instanceof Utility){
                if(ownable.getOwner() != null && ownable.getOwner().equals(player)){
                    count++;
                }
            }
        }
        return count;

    }
}


