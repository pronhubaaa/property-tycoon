# Game Engine documentation

## GameEngine class

### Private Attributes

#### gameBoard: Board
This is the representation of the board, which contains tiles, player locations, etcs,

#### players: Array of Players
This array represents all the players playing the game. The order of the array will represent the order of play.

#### numberOfTurns: Int
This represents the current turn number. This will increment at the end of each turn.

#### currentTurn: Player
This is a pointer to the player object whose turn it currently is.

### Public Methods

#### GameEngine
*Parameters*: JsonObject of save file data.

*Returns*: N/A

This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time. This method will be used to load a save file, so it should fully restore a previous game state and initial the board.

#### GameEngine
*Parameters*: JsonObject of imported board data, Array of Players, GameType enum, Int number of minutes (optional).

*Returns*: N/A

This is the constructor method. It will be used to start a new game and initialise the board.

#### startGame
*Parameters*: None

*Returns*: Void

This method is intended to be accessed from the UI class. It will start the game.

#### getCurrentPlayer
*Parameters*: None

*Returns*: Player whose goes it is.

This method return a pointer to the player whose turn it currently is.

#### nextTurn
*Parameters*: None

*Returns*: Player whose go it is _now_ is.

This method will be used by the UI class to end the current player's turn and begin the next player's turn. It will be responsible for checking whether the game is over (using endGame method), changing the current player reference and incrementing the numberOfTurns attribute.

#### getNumberOfTurns
*Parameters*: None

*Returns*: Int representing the number of turns

This method returns the accumulated number of turns in the game.

#### incrementNumberOfTurns
*Parameters*: None

*Returns*: Void

This methods increments the numberOfTurns attribute by one.

#### startTimer
*Parameters*: None

*Returns*: Void

This starts the timer for the abridged version of the game.

#### stopTimer
*Parameters*: None

*Returns*: Void

This stops the timer for the abridged version of the game.


### Private Methods

#### constructGameBoard
*Parameters*: JsonObject of imported board data.

*Returns*: Board

Sets up a board using the imported board data. If the JSON object contains additional data (eg. from a save file) this should be filtered out before constructing the Board object.

#### endGame
*Parameters*: None

*Returns*: Boolean

This method is intended to be accessed from incrementCurrentTurn. It will determine whether the game is over, by using methods such as getTime (if it is the abridged version) and also by checking the number of players still in the game.

#### addPlayer
*Parameters*: Player

*Returns*: Void

This method is used by the constructor to add a player to the engine. It will populate the players attribute array.

#### 


