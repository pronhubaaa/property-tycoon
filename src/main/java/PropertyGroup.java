/**
 * * The property group class is responsible for containing all groups of properties.
 * This excludes the station and utility groups.
 * This class will be able to check ownership and colour of a group.
 */
public class PropertyGroup extends Group {



    public PropertyGroup(){
        super();

    }

    /**
     * checkOwnedStreet
     * @param player The player we are checking against
     * @return Boolean, true of all properties owned by the player
     * Check if a player owns the street.
     */
    public Boolean checkOwnedStreet(Player player){
        for(Ownable ownable: this.getGroup()){
            if(ownable instanceof Property){
                if(ownable.getOwner() == null || !ownable.getOwner().equals(player)){
                    return false;
                }
            }
        }
        return true;
    }

}


