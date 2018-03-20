# Game Engine documentation
---

## PropertyGroup Class

The property group class is responsible for containing all groups of properties. This excludes the station and utility groups. This class will be able to check ownership and colour of a group. 

### Private Attributes 
- #### colour: String
 
The colour code for the colour of this particular group.

#### Public Methods 

- #### checkOwnedStreet(Player): Boolean
*Parameters*: The player we are checking against 
*Returns*: Boolean, true of all properties owned by the player

Check if a player owns the street.

- #### getColour(): String
*Parameters*: None
*Returns*: String containing the colour code

Gets the colour for this street.

- #### setColour(String): Void
*Parameters*: A string containing the colour for this street 
*Returns*: Void

Sets the colour of this group.

---