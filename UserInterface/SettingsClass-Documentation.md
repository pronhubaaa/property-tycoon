# User Interface documentation
---

## Settings Class

This is the main settings screen located in the main menu, this will allow the user to change any game settings avaliable for change. 

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### returnButton: Button
This button will take the user to the previous screen. 
### Public Methods 
- #### Settings(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This will initialise the settings screen given the current game engine. 
### Private Methods
- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This method will allow the player to move to the previous screen. 

---