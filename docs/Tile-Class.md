---
id: Tile-Class
title: Tile class
sidebar_label: Tile
---

The tile class is responsible for storing all tiles on the game board. It contains common functions that all tiles will need such as storing the position. 

### Private Attributes 
- #### name: String
```java
private String name;
```
The name of this specific tile.

- #### position: Int
```java
private int position;
```
The position on the board of this specific tile.

### Public Methods 

- #### getName(): String
```java
public String getName()
```
*Parameters*: None
*Returns*: The name of the tile 

This method returns the name of this tile.

- #### getPosition(): Int
```java
public int getPosition()
```
*Parameters*: None
*Returns*: The numerical position on the board this tile is in

An integer showing where this tile is located on the board.


- #### setName(String): Void
```java
public void setName(String name)
```
*Parameters*: String name of the tile
*Returns*: Void

Allows the name of the tile to be set.

- #### setPosition(Int): Void
```java
public void setPosition(int position)
```
*Parameters*: Integer position of the tile on the board
*Returns*: Void

This allows the tile to be allocated a place on the board. 

---