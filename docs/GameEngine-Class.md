---
id: GameEngine-Class
title: GameEngine class
sidebar_label: Game Engine
---

The game class will build the UI based on the gameEngine

## Private Attributes
### gameEngine
```java
private GameEngine gameEngine;
```
The current game being played.

### ui
```java
private UI ui;
```
The current interface objects being used.

### minPlayers
```java
private Int minPlayers;
```
The minimum amount of players able to play.
### maxPlayers
```java
private Int maxPlayers;
```
The maximum amount of players able to play.
## Public Methods

### Game
```java
public void Game()
```
*Parameters*: None
*Returns*: Void

This constructor will construct the game user interface.

## Private Methods
### constructUI
```java
public void constructUI(GameEngine gameEngine)
```
*Parameters*: A game engine
*Returns*: Void

This will build a user interface given a setup game engine, this being the data used to initialise the board.

---
