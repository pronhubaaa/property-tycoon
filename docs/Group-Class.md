---
id: Group-Class
title: Group class
sidebar_label: Group 
---

The group class contains all methods and functions required by the different groups on the board, this being properties, utilities and stations. 

### Private Attributes 

#### groups
```java
private ArrayList<Ownable> group;
```
This array of groups are all properties on the board that are assigned a group. 

#### colour
```java
private Colour colour;
```
This contains the colour of the given group.

#### Public Methods 
#### Group
```java
public Group()
```
*Parameters*: None
*Returns*: Void

This is the constructor for the Group object

#### getGroups
```java
public ArrayList<Ownable> getGroup()
```
*Parameters*: None
*Returns*: An array of property groups 

This method gets all groups of properties on the game board.

#### setGroups
```java
public void setGroups(ArrayList<Ownable> ownables)
```
*Parameters*: An array of property groups
*Returns*: Void

This method sets all groups of properties on the game board for initialisation.

#### add
```java
public void add(Ownable ownable)
```
*Parameters*: A group
*Returns*: Void

This method adds a group of properties on the game board for initialisation.

#### getGroupOwners
```java
public ArrayList<Player> getGroupOwners()
```
*Parameters*: None
*Returns*: The players that own a tile in this group

This method gives a list of players that own a tile in this group

#### getColour
```java
public Colour getColour()
```
*Parameters*: none
*Returns*: The colour of the group

This method is uded to get the colour of the group

#### setColour
```java
public void setColour(Colour colour)
```
*Parameters*: The colour to set this group
*Returns*: Void

This method is used to set the colour of the group.

---

