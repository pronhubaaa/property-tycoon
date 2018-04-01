import javafx.scene.paint.Color;

/**
 * The property group class is responsible for containing all groups of properties.
 * This excludes the station and utility groups.
 * This class will be able to check ownership and colour of a group.
 */
public class PropertyGroup extends Group {

    /**
     * colour: String
     * The colour code for the colour of this particular group.
     */
    private Color colour;

    /**
     * checkOwnedStreet
     * @param player The player we are checking against
     * @return Boolean, true of all properties owned by the player
     * Check if a player owns the street.
     */
    public Boolean checkOwnedStreet(Player player){
        return null;
    }

    /**
     * getColour
     * @return String containing the colour code
     * Gets the colour for this street.
     */
    public Color getColour() {
        return this.colour;
    }

    /**
     * setColour
     * @param colour The colour for this street
     * Sets the colour of this group
     */
    public void setColour(Color colour) {
        this.colour = colour;
    }
}
