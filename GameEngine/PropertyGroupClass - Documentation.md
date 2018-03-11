# Game Engine documentation
---

## PropertyGroup Class
### Private Attributes 
- #### properties: [Property]

The property tiles in the colour group.

- #### colour: String
 
The colour code for the colour of this particular group.

#### Public Methods 
- #### getProperties(): [Property]
*Parameters*: None
*Returns*: An array of all properties in this group

This method returns all properties in this group.

- #### setProperties([Property]): Void
*Parameters*:An array of properties 
*Returns*: Void 

Add properties to a group for the start of a game. 

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