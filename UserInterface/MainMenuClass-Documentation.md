# User Interface documentation
---
## MainMenu Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
### Public Methods 
- #### MainMenu(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This method will initialise the menu with the data for the current game (Should there be any).
- #### factoryLoadingMenu(): Scene
*Parameters*: None
*Returns*: The loading screen

This is the loading screen seen between screens.

### Private Methods
- #### showScene(Scene): Void
*Parameters*: the screen to be displayed 
*Returns*: Void

This allows this scene to be outputted to the users screen. 

---