---
id: doc1
title: Game class
sidebar_label: Game Engine
---

The game class will build the UI based on the gameEngine

## Private Attributes
### GameEngine
```java
private GameEngine gameEngine;
```
The current game being played.

### UI
```java
private UI ui;
```
The current interface objects being used.

### minPlayers: Int
The minimum amount of players able to play.
### maxPlayers: Int
The maximum amount of players able to play.
## Public Methods

### Game()
*Parameters*: None
*Returns*: Void

This constructor will construct the game user interface.

## Private Methods
### constructUI(GameEngine): Void
*Parameters*: A game engine
*Returns*: Void

This will build a user interface given a setup game engine, this being the data used to initialise the board.

---
