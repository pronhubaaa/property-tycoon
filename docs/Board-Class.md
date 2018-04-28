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

- #### stationGroups: [StationGroup]
```java
private HashMap<String, StationGroup> stationGroups;
```
The train station tiles shown on the board.

- #### UtilityGroups: [UtilityGroup]
```java
private HashMap<String, UtilityGroup> utilityGroups;
```
The utility tiles shown on the board.

### Public Methods 

- #### Board(JsonObject)
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


- #### addTile(Tile): Void
```java
public void addTile(Tile tile)
```
*Parameters*: The tile being added to the board
*Returns*: Void

This allows the game board to be initialised, tiles can be added in this way.

- #### getPlayerOwned
```java
public int getPlayerOwned(Ownable ownable)
```
*Parameters*: An owned tile
*Returns*: The amount of tiles owned in the same group as the given tile by the owner of the given tile.

Return the amount of tiles owned in the same group as the given tile by the owner of the given tile.

- #### getPropertyGroups
```java
public HashMap<String, PropertyGroup> getPropertyGroups()
```
*Parameters*: Void
*Returns*: Hash map of property groups indexed by colour

Get all property groups

- #### setPropertyGroups
```java
public void setPropertyGroups(HashMap<String, PropertyGroup> propertyGroups)
```
*Parameters*: Hash map of property groups indexed by colour
*Returns*: none

Set all property groups

- #### getStationGroups
```java
public HashMap<String, StationGroup> getStationGroups()
```
*Parameters*: Void
*Returns*: Hash map of station groups indexed by colour

Get all station groups

- #### setStationGroups
```java
public void setStationGroups(HashMap<String, StationGroup> stationGroups)
```
*Parameters*: Hash map of station groups indexed by colour
*Returns*: none

Set all station groups

- #### getUtilityGroups
```java
public HashMap<String, UtilityGroup> getUtilityGroups()
```
*Parameters*: Void
*Returns*: Hash map of utility groups indexed by colour

Get all utility groups

- #### setUtilityGroups
```java
public void setUtilityGroups(HashMap<String, UtilityGroup> utilityGroups)
```
*Parameters*: Hash map of utility groups indexed by colour
*Returns*: none

Set all utility groups

---