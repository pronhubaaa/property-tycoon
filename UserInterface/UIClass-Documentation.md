# User Interface documentation
---
## UI Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
### Public Methods 
- #### UI(GameEngine)
*Parameters*: The current game engine
*Returns*: Void

Initialise the user interface for the current dataset.

### Private Methods
- #### factoryMainMenu(GameEngine): MainMenu
*Parameters*: None
*Returns*: Void

This will show the main menu screen in the UI.

- #### createGame(GameEngine): Game
*Parameters*: The current game engine 
*Returns*: A game object 

This will create the UI screen for the current game.
- #### createPostGame(GameEngine): PostGame
*Parameters*: The current game engine 
*Returns*: a post game object showing the leaderboard 

This will create a results screen for after the game.
- #### showScene(Scene): Void
*Parameters*: The screen being displayed 
*Returns*: Void

This method allows us to view a specific scene, game, menu etc. 

---