# Game Engine documentation
--- 

## Game Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game being played.
- #### ui: UI
The current interface objects being used.

- #### minPlayers: Int
The minimum amount of players able to play.
- #### maxPlayers: Int
The maximum amount of players able to play.
### Public Methods 
- #### Game()
*Parameters*: None
*Returns*: Void

This constructor will construct the game user interface.

### Private Methods 
- #### constructUI(GameEngine): Void
*Parameters*: A game engine
*Returns*: Void

This will build a user interface given a setup game engine, this being the data used to initialise the board.

---