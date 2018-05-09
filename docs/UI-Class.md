---
id: UI-Class
title: UI class
sidebar_label: User Interface
---

The UI class is the controller used to go between the game engine and UI. It will create all standard scenes to be used in the game.

## Private Attributes

### gameEngine
```java
private GameEngine gameEngine;
```
This is the game engine being used with the UI in order for the players to play their game.

### PrimaryStage
```java
private Stage _primaryStage;
```
The primary stage is the display that is currently on the screen

### isTest
```java
private boolean _isTest;
```
Set if the game should be fullscreen, this is false where the testing is active.

## Public Methods
### UI
```java
public UI(Stage primaryStage, GameEngine gameEngine, Boolean isTest)
```

*Parameters*: The opening stage for the game board, the game engine for the current game and wether this is a test.
*Returns*: Void

This initialises the UI object.

### ShowScene
```java
public void showScene(Scene scene)
```

*Parameters*:  The scene that is going to be displayed
*Returns*: Void

This allows a new screen to be shown to the player.

### close
```java
public void close()
```

*Parameters*:  None
*Returns*: Void

This will end the game

### getStage
```java
public Stage getStage()
```

*Parameters*:  None
*Returns*: The current stage

This will return the current stage shown to the player

### getScene
```java
public Stage getScene()
```

*Parameters*:  None
*Returns*: The current scene

This will return the current scene shown to the player

---
