---
id: GameEngine-Class
title: Game Engine class
sidebar_label: Game Engine 
---


The game engine will be responsible for any action that happens on the board and controlling all of the players actions.

### Private Attributes

- #### gameBoard: Board
```java
private Board gameBoard;
```
This is the representation of the board, which contains tiles, player locations, etc.

- #### players: Array of Players
```java
private ArrayList<Player> players;
```
This array represents all the players playing the game. The order of the array will represent the order of play.

- #### numberOfTurns: Int
```java
private int numberOfTurns;
```
This represents the current turn number. This will increment at the end of each turn.

- #### currentTurn: Player
```java
private Player currentPlayer;
```
This is a pointer to the player object whose turn it currently is.

- #### timer: Timer
```java
private Timer timer;
```
This is the timer counting down for the abridged version of the game. 

- #### timeLeft: int
```java
private int timeLeft;
```
This is the time left of the game.

- #### gameType: GameType
```java
private GameType gameType;
```
This is the type of game e.g. Abridged or Full.

- #### trading: Boolean
```java
private boolean trading;
```
This is a variable to store if trading is on or off.

### Public Methods

- #### GameEngine
```java
 public GameEngine(JSONObject jsonObject)
```
*Parameters*: JsonObject of save file data.
*Returns*: Void

This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time. This method will be used to load a save file, so it should fully restore a previous game state and initial the board.

- #### GameEngine
```java
public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type, int numberOfMinutes)
```
*Parameters*: JsonObject of imported board data, Array of Players, GameType enum, Int number of minutes (optional).
*Returns*: Void

This is the constructor method. It will be used to start a new game and initialise the board.

- #### GameEngine
```java
public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type)
```
*Parameters*: JsonObject of imported board data, Array of Players, GameType enum
*Returns*: Void

This is the constructor method. It will be used to start a new game and initialise the board.

- #### saveGame
```java
public void saveGame()
```
*Parameters*: None
*Returns*: Void

This method is intended to be accessed from the UI class. It will save the game.


- #### startGame
```java
public void startGame()
```
*Parameters*: None
*Returns*: Void

This method is intended to be accessed from the UI class. It will start the game.

- #### getCurrentPlayer
```java
public Player getCurrentPlayer()
```
*Parameters*: None
*Returns*: Player whose goes it is.

This method return a pointer to the player whose turn it currently is.

- #### nextTurn
```java
public Player nextTurn()
```
*Parameters*: None
*Returns*: Player whose go it is _now_ is.

This method will be used by the UI class to end the current player's turn and begin the next player's turn. It will be responsible for checking whether the game is over (using endGame method), changing the current player reference and incrementing the numberOfTurns attribute.

- #### getNumberOfTurns
```java
public int getNumberOfTurns()
```
*Parameters*: None
*Returns*: Int representing the number of turns

This method returns the accumulated number of turns in the game.

- #### incrementNumberOfTurns
```java
public boolean incrementNumberOfTurns()
```
*Parameters*: None
*Returns*: Void

This methods increments the numberOfTurns attribute by one.

- #### startTimer
```java
public void startTimer()
```
*Parameters*: None
*Returns*: Void

This starts the timer for the abridged version of the game.

- #### stopTimer
```java
public void stopTimer()
```
*Parameters*: None
*Returns*: Void

This stops the timer for the abridged version of the game.

- #### getTime
```java
public int getTime()
```
*Parameters*: None
*Returns*: Void

This gets the amount of time left in the abridged version.

- #### getTrading
```java
public boolean getTrading()
```
*Parameters*: None
*Returns*: Boolean

This gets the trading boolean.

- #### setTrading
```java
public void setTrading(boolean trading)
```
*Parameters*: Boolean
*Returns*: Void

This sets the trading boolean.

### Private Methods

- #### constructGameBoard
```java
private Board constructGameBoard(JSONObject jsonObject)
```
*Parameters*: JsonObject of imported board data.
*Returns*: Board

Sets up a board using the imported board data. If the JSON object contains additional data (eg. from a save file) this should be filtered out before constructing the Board object.

- #### endGame
```java
private Boolean endGame()
```
*Parameters*: None
*Returns*: Boolean

This method is intended to be accessed from incrementCurrentTurn. It will determine whether the game is over, by using methods such as getTime (if it is the abridged version) and also by checking the number of players still in the game.

- #### addPlayer
```java
private void addPlayer(Player player)
```
*Parameters*: Player
*Returns*: Void

This method is used by the constructor to add a player to the engine. It will populate the players attribute array.

- #### checkGameType
```java
private GameType checkGameType(String str)
```
*Parameters*: The game type as a string
*Returns*: Void

This method is used by the constructor to add a player to the engine. It will populate the players attribute array.

- #### checkPieceType
```java
private PlayerPiece checkPieceType(String str)
```
*Parameters*: Player
*Returns*: Void

This method is used by the constructor to add a player to the engine. It will populate the players attribute array.

---