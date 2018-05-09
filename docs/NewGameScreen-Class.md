---
id: NewGameScreen-Class
title: New Game Screen class
sidebar_label: New Game Screen
---

The new game screen class is the UI screen for when the new game button is pressed, it shows all options that can be set to initialise a new game.

## Private Attributes

### rectLeft
```java
private static VBox rectLeft;
```
This holds the players that will be added to the game on the left hand side of the new game screen.

### rectRightBot
```java
private static VBox rectRightBot;
```
This is the bottom right box on the screen that allows the player to pick a game mode.

### playerCount
```java
private static int playerCount;
```
This variable stores the amount of players that will be added to the game.

### playerCountExternal
```java
private static int playerCountExternal;
```
This variable is used to ensure that the min players doesn't go below 2.

### fullGameType
```java
private static boolean fullGameType;
```
This variable states wether the game is abridged or full.  

### playersList
```java
private static ArrayList<Player> playersList;
```
This variable stores an array of player objects that are initialised to the players information.


## Public Methods
### addNewPlayer
```java
public static void addNewPlayer()
```

*Parameters*: None
*Returns*: Void

This method is used to display the player adding menu on the left side of the screen and also add new players to the array list.

### NewGameScreen
```java
public NewGameScreen(VBox scene, UI ui, GameEngine gameEngine)
```

*Parameters*: The current scene, the UI object and the game engine for the new game.
*Returns*: Void

This method builds the new game screen object, initialising all components of the screen.

### makeGame
```java
public GameEngine makeGame(GameEngine gameEngine, JSONObject json, UI ui)
```

*Parameters*: The current game engine, the JSON data for the board and the UI object.
*Returns*: The new game engine for the new game.

This method builds the new game engine initialising all components of the board.

### displayError
```java
public VBox displayError(String msg, StackPane stack)
```

*Parameters*: The message to display, and the stack it is a part of
*Returns*: An error message to display on the screen.

This method is used to display an error message on the screen to the user.

### getPlayerOneName
```java
public String getPlayerOneName()
```

*Parameters*: None
*Returns*: The current players name

Get the name of the player who is currently playing.

### getRectLeft
```java
public VBox getRectLeft()
```

*Parameters*: None
*Returns*: The players entered on the left side of the screen

Get the info on the players who have been entered on the left side of the screen.

### getMostRecentPlayerNameField
```java
public TextField getMostRecentPlayerNameField()
```

*Parameters*: None
*Returns*: Get the name of the most recent player added.

Get the name of the most recent player added.

### getGameType
```java
public boolean getGameType()
```

*Parameters*: None
*Returns*: The game type of the current game.

Get the game type of the current game.

### getAbridgedBox
```java
public VBox getAbridgedBox()
```

*Parameters*: None
*Returns*: The box in the bottom right of the screen that determines if the player has selected abridged.

Get the box in the bottom right of the screen that determines if the player has selected abridged.

### getTrading
```java
public Slider getTrading()
```

*Parameters*: None
*Returns*: A new slider that is used to determine if the player wishes to have trading enabled.

This method is to create a new slider that is used to determine if the player wishes to have trading enabled. 
