# User Interface documentation
---
## UI Class

The UI class is the controller used to go between the game engine and UI. It will create all standard scenes to be used in the game. 

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.

- #### primaryStage: Stage
The primary stage for the UI.

### Public Methods 
- #### UI(Stage, GameEngine)
*Parameters*: 
 - The primary stage for the UI.
 - The current game engine
*Returns*: Void

Initialise the user interface for the current dataset.

- #### showScene(Scene): Void
*Parameters*: The screen being displayed 
*Returns*: Void

This method allows us to view a specific scene, game, menu etc. 

---