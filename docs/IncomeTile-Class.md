---
id: IncomeTile-Class
title: Income Tile class
sidebar_label: Income Tile
---

The income tile class is responsible for tiles that give players money.   

### Private Attributes 

- #### value: Int
```java
private int value;
```
The amount given to a player when landing on an income tile.

### Public Methods 
- #### income tile
```java
public IncomeTile(String name, int position, int value)
```
*Parameters*: The name of the tile, the position and the value of the income on the tile.
*Returns*: Void

Initialises the income tile.

- #### getValue
```java
public int getValue()
```
*Parameters*: None
*Returns*: Income value for the tile.

Returns the value given for landing on the tile.

- #### setValue
```java
public void setValue(int value)
```
*Parameters*: Assign the amount of money given on the tile.
*Returns*: Void

Set the amount of money given to a player for landing on this tile.

- #### addValue
```java
public void addValue(int value)
```
*Parameters*: Amount to add to the tile.
*Returns*: Void

Adds a specific amount to the value given on the tile

- #### collect
```java
public void collect(Player player)
```
*Parameters*: The player receiving money
*Returns*: Void

Gives the value on the tile to a given player.

--- 