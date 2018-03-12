# User Interface documentation
---

## InGameSettings Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### menuLabel: Label
Label for the top of the screen saying "Settings".
- #### returnButton: Button
A return to game button.
- #### saveButton: Button
A save game button.
- #### exitButton: Button
An exit game button.
### Public Methods 
- #### InGameSettings(GameEngine)
*Parameters*: None
*Returns*: The game engine 

This will initialise the setings screen.

### Private Methods
- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This will remove the scene from the players view.

- #### saveGame(): Void
*Parameters*: None
*Returns*: Void

This will save the game to JSON data.  

- #### exitGame(): Void
*Parameters*: None
*Returns*: Void

This will take the player to the menu screen.

---