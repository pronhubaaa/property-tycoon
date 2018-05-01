---
id: Ownable-Class
title: Ownable class
sidebar_label: Ownable
---

The ownable class contains all tiles that a player could possess.

## Private Attributes
### owner
```java
private Player owner;
```
This is the player who owns this tile.

### price
```java
private int price;
```
This is the price for this tile.

### mortgagePrice
```java
private int mortgagePrice;
```
This is the mortgage price for this tile.

### sellPrice
```java
private int sellPrice;
```
This is the sale price for this tile.

### mortgaged
```java
private boolean mortgaged;
```
This boolean dictates if the tile is mortgaged

### group
```java
private Group group;
```
The group this ownable tile is in

## Public Methods
### Ownable
```java
public Ownable(String name, int position, Group group)
```
*Parameters*: The name position and group of the new ownable tile.
*Returns*: Void

This is the initialiser for an ownable object.

### isOwned
```java
public boolean isOwned()
```
*Parameters*: None
*Returns*: Boolean, true if the tile has an owner

This method returns if the property is owned or not.

### getPrice
```java
public int getPrice()
```
*Parameters*: None
*Returns*: The price for this tile

This method returns the price of this property.

### setPrice
```java
public void setPrice(int price)
```
*Parameters*: The given price for this tile
*Returns*: Void

This method sets the price for the property for initialisation.

### getMortgagePrice
```java
public int getMortgagePrice()
```
*Parameters*: None
*Returns*: The mortgage value of the property

This method gets the value given to the player for mortgaging the property.

### setMortgagePrice
```java
public void setMortgagePrice(int mortgagePrice)
```
*Parameters*: The given mortgage price for this tile
*Returns*: Void

This method will set the mortgage price for the property.

### getOwner
```java
public Player getOwner()
```
*Parameters*: None
*Returns*: The player who owns the tile

This method returns the player who owns the tile.

### setOwner
```java
public void setOwner(Player owner)
```
*Parameters*: Assign a player to own this tile
*Returns*: Void

This method allows a player to own the tile.

### getSellPrice
```java
public int getSellPrice()
```
*Parameters*: None
*Returns*: The amount the property can be sold for

This method is used to get the sell price of the property

### setOwner
```java
public void setSellPrice(int sellPrice)
```
*Parameters*: New sell price of the ownable
*Returns*: void

This method is used to set the sell price of the property

### isMortgaged
```java
public boolean isMortgaged()
```
*Parameters*: None
*Returns*: true if the property is mortgaged

This method is used to check if the property is mortgaged

### setMortgaged
```java
public void setMortgaged(boolean mortgaged)
```
*Parameters*: boolean, true if tile is now mortgaged
*Returns*: void

This method is used to set the property is mortgaged of un-mortgaged

### getGroup
```java
public Group getGroup()
```
*Parameters*: None
*Returns*: The group this property belongs to

This method is used to set the group of the ownable

### setGroup
```java
public void setGroup(Group group)
```
*Parameters*: the group this tile should be in
*Returns*: void

This method is used to set the group of the ownable

---
