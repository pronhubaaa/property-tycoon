---
id: Board-Class
title: Board class
sidebar_label: Board
---

The board class controls all tiles on the board, initialising them, keeping track of player locations property sales, etc. 

### Private Attributes 
- #### tiles
```java
private ArrayList<Tile> tiles;
```
All tiles that appear on the board.

- #### propertyGroups
```java
private HashMap<String, PropertyGroup> propertyGroups;
```
The groups of properties as shown by their colour groups on the board.

- #### stationGroups
```java
private HashMap<String, StationGroup> stationGroups;
```
The train station tiles shown on the board.

- #### UtilityGroups
```java
private HashMap<String, UtilityGroup> utilityGroups;
```
The utility tiles shown on the board.

### Public Methods 

- #### Board
```java
public Board(JSONObject jsonObject)
```
*Parameters*: JsonObject
*Returns*: Void

The JSON data will come from the GameEngine, this includes all tiles, property groups, station groups, utility groups and cards. This constructor initialises the board.

- #### getTiles
 ```java
public ArrayList<Tile> getTiles()
```
*Parameters*: None
*Returns*: An array of tiles

This method will get all tiles on the board.


- #### getPropertyGroups
 ```java
public HashMap<String, PropertyGroup> getPropertyGroups()
```
*Parameters*: None
*Returns*: All property groups

This method will get all property groups

- #### setPropertyGroups
 ```java
public void setPropertyGroups(HashMap<String, PropertyGroup> propertyGroups)
```
*Parameters*: New property groups
*Returns*: Void

This method will set all property groups

- #### getStationGroups
 ```java
public HashMap<String, StationGroup> getStationGroups()
```
*Parameters*: None
*Returns*: All station groups

This method will get all station groups

- #### setStationGroups
 ```java
public void setStationGroups(HashMap<String, StationGroup> stationGroups)
```
*Parameters*: New station groups
*Returns*: Void

This method will set all station groups

- #### getUtilityGroups
 ```java
public HashMap<String, UtilityGroup> getUtilityGroups()
```
*Parameters*: None
*Returns*: All utility groups

This method will get all utility groups

- #### setUtilityGroups
 ```java
public void setUtilityGroups(HashMap<String, UtilityGroup> utilityGroups)
```
*Parameters*: New utility groups
*Returns*: Void

This method will set all utility groups

- #### getPlayerOwned
 ```java
public int getPlayerOwned(Ownable ownable)
```
*Parameters*: A tile of type ownable
*Returns*: How many tiles in the same group as the input tile the owner of the tile owns.

This method is to see what other tiles in a set are owned. It is given a tile, then it must return the amount of tiles owned by the player that owns the most.This could be 1 if two players own one, 2 if a player owns 2, etc.

- #### addTile
 ```java
public void addTile(Tile tile)
```
*Parameters*: The tile being added to the board
*Returns*: Void

This allows the game board to be initialised, tiles can be added in this way.



---