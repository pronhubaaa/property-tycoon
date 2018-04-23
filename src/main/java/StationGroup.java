/**
 * The station group class is used to check how many stations a player owns.
 */
public class StationGroup extends Group {

    /**
     * Constructor
     */
    public StationGroup(){
        super();
    }
    /**
     * checkOwnedStations
     * @param player A Player
     * @return Amount of stations that player owns
     * This method returns the number of the stations that a player owns.
     */
    public int checkOwnedStations(Player player){
        int count = 0;
        for(Ownable ownable: this.getGroup()){
            if(ownable != null && ownable instanceof Station){
                if(ownable.getOwner() != null && ownable.getOwner().equals(player)){
                    count++;
                }
            }
        }
        return count;
    }

}
