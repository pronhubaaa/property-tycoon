---
id: Property-Class
title: Property class
sidebar_label: Property 
---

The property class stores all information related to a property on the board, this being the rent, amount of houses present, etc. It also contains methods to change these figures. 

### Private Attributes 
#### rent
```java
private ArrayList<Integer> rent;
```
This is an array of the price of rent on the property, each slot will represent as follows: 
-- The standard rent 
-- The rent when the group is owned
-- The rent with one house
-- The rent with two houses
-- The rent with three houses 
-- The rent with four houses 
-- The rent with a hotel

#### costOfHouse
```java
private int costOfHouse;
```
This integer represents the cost to put a house on this property.

#### amountOfHouses
```java
private int amountOfHouses;
```
The amount of houses on the property.

### Public Methods 
#### Property
```java
public Property(String name, int position, Group group)
```
*Parameters*: Tile name, the position and the group 
*Returns*: Void

This method initilaises the property object


#### getRent
```java
public ArrayList<Integer> getRent()
```
*Parameters*: None
*Returns*: Array of prices the rent may be

This returns an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'. 

#### setRent
```java
public void setRent(ArrayList<Integer> rent)
```
*Parameters*: Array of prices for the rent
*Returns*: Void

This sets an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'.

#### getCostOfHouse
```java
public int getCostOfHouse()
```
*Parameters*: None
*Returns*: The price to put a house on the property

This method gets the cost to put a house on this property.

#### setCostOfHouse
```java
public void setCostOfHouse(int costOfHouse)
```
*Parameters*: Price for a house on this property 
*Returns*: Void

This method allows the price to buy a house on this property to be set. 

#### addHouses
```java
public void addHouses(int amount)
```
*Parameters*: Amount of houses to add
*Returns*: Void

Add a set amount of houses to the property.

#### addHouses
```java
public void addHouses()
```
*Parameters*: None
*Returns*: Void

Add a house to the property.

#### removeHouses
```java
public void removeHouses(int amount)
```
*Parameters*: Amount of houses to remove
*Returns*: Void

Remove houses from the property.

#### applyPayment
```java
public boolean applyPayment(Player player)
```
*Parameters*: The player paying rent
*Returns*: Void

Applies the price of the rent to a player

#### getAmountOfHouses
```java
public int getAmountOfHouses()
```
*Parameters*: None
*Returns*: Amount of houses on this tile

This method is used to get the amount of houses on a property

--- 