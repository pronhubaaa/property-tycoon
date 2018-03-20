# User Interface documentation
---
## LoadGame Class

The load game class is for use in the menu, allowng the player to use the GUI to load an existing game.

### Private Attributes 

- #### gameEngine: GameEngine
The game engine, all data for the current game.

- #### labels: [Label]
This array of labels are the titles that will be used on this page.

- #### returnButton: Button
This will return the player to the previous screen.

- #### gameComboBox: [PreviousGame]
The combo box shows all previous save files of the game.

### Public Methods 
- #### LoadGame(GameEngine)
*Parameters*: The game engine for the given save file
*Returns*: Void

This will allow a previously saved game to be loaded in as a game engine.

### Private Methods
- #### readSavedGames(): [JsonObject]
*Parameters*: None
*Returns*: An array of JSON data

This private method reads the JSON data representing the previous game saves. This is used to initialise this page.

- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This method allows the previous screen to be loaded once more.

---