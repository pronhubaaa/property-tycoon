# User Interface documentation
–––

## SetUpBoard Class

This class will be used in the menu to pick which board is being used for a new game. 

### Private Attributes 
- #### boardDropDown: ComboBox
This is the dropdown box showing each board that can be used. 
- #### boards: [JsonObject]
This contains the data required to setup a game engine of a specific board.
- #### importButton: Button
This button will allow boards to be added to the game from the users device.
- #### label: Label
This label says "Board type".

### Public Methods 
- #### SetUpBoard()
*Parameters*: None
*Returns*: Void

This will initialise the scene.

### Private Methods
- #### getBoards(): [JsonObject]
*Parameters*: None
*Returns*: An array of JSON data

This will get the data necessary to display the different types of board that the player could use. 

- #### constructLabel(): Void
*Parameters*: None
*Returns*: Void

This will construct a label for the name of the game board. 

---