# User Interface documentation
---
## SetUpGame Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### playersScene: Scene
Scene on the screen asking for player names, types and pieces. 
- #### boardScene: Scene
Scene on the screen asking which version of the board is being used.
- #### gameType: Scene
Scene on the screen asking which verison of the game is being played.
- #### labels: [Label]
All labels being used on this screen such as "New Game" at the top.
- #### buttons: [Button]
All buttons being used on this screen such as "Start Game".
### Public Methods 
- #### SetUpGame(GameEngine)
*Parameters*: The current gameEngine
*Returns*: Void

This will initialise the new game screen to be displayed to the user. 

### Private Methods
- #### startGame(): Void
*Parameters*: None
*Returns*: Void

This will being a game given the information added on this screen.

- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This will return to the previous screen.

---