/**
 * * The property group class is responsible for containing all groups of properties.
 * This excludes the station and utility groups.
 * This class will be able to check ownership and colour of a group.
 */
public class PropertyGroup extends Group {

    /**
     * colour: Colour
     * The colour code for the colour of this particular group.
     */
    private Colour colour;

    public PropertyGroup(){
        super();
        this.colour = Colour.White;

    }

    /**
     * checkOwnedStreet
     * @param player The player we are checking against
     * @return Boolean, true of all properties owned by the player
     * Check if a player owns the street.
     */
    public Boolean checkOwnedStreet(Player player){
        for(Ownable ownable: this.getGroup()){
            if(ownable != null && ownable instanceof Property){
                if(ownable.getOwner() == null || !ownable.getOwner().equals(player)){
                    return false;
                }
            }
        }
        return true;
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


