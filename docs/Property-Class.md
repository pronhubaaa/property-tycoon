---
id: Property-Class
title: Property class
sidebar_label: Property
---

The property class stores all information related to a property on the board, this being the rent, amount of houses present, etc. It also contains methods to change these figures.

## Private Attributes
### costOfHouse
```java
private int costOfHouse;
```
This integer represents the cost to put a house on this property.

### amountOfHouses
```java
private int amountOfHouses;
```
The amount of houses on the property.

## Public Methods
### Property
```java
public Property(String name, int position, Group group)
```
*Parameters*: Tile name, the position and the group
*Returns*: Void

This method initialises the property object

### getCostOfHouse
```java
public int getCostOfHouse()
```
*Parameters*: None
*Returns*: The price to put a house on the property

This method gets the cost to put a house on this property.

### setCostOfHouse
```java
public void setCostOfHouse(int costOfHouse)
```
*Parameters*: Price for a house on this property
*Returns*: Void

This method allows the price to buy a house on this property to be set.

### addHouses
```java
public void addHouses(int amount)
```
*Parameters*: Amount of houses to add
*Returns*: Void

Add a set amount of houses to the property.

### removeHouses
```java
public void removeHouses(int amount)
```
*Parameters*: Amount of houses to remove
*Returns*: Void

Remove houses from the property.

### getAmountOfHouses
```java
public int getAmountOfHouses()
```
*Parameters*: None
*Returns*: Amount of houses on this tile

This method is used to get the amount of houses on a property

---
