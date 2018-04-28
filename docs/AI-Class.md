---
id: AI-Class
title: AI class
sidebar_label: Computer Player 
---

This class is used to create an artificial player. 

### Public Methods

- ### buyTile
```java
public boolean buyTile(Tile ownable)
```

*Parameters*: A tile that the AI player could purchase
*Returns*: Boolean true or false, suggesting the player should buy

This allows the AI player to decide to buy or bid for a property.

- ### buyHouses
```java
public ArrayList<Boolean> buyHouses()
```
 *Parameters*: None
*Returns*: ArrayList of booleans, true would represent a purchased house, false if a house was not purchased. 

Assesses the AI current financial position and ownsership status, then buys houses accordingly on owned streets. 
 

- ### trader
```java
public boolean trader(ArrayList<Ownable> opponentTiles, ArrayList<Ownable> myTiles, Player player)
```
*Parameters*: A set of tiles the player may trade, the tiles the player would trade for, and the opponent they are trading with. 
*Returns*: Boolean suggesting if the player should make the trade

This allows the AI Player to trade a property.

- ### bid
```java
public int bid(Tile buyable)
```
*Parameters*: The tile being auctioned 
*Returns*: Amount to bid

This allows the AI Player to trade a property.

- ### payBill
```java
public boolean payBill(int bill)
```

*Parameters*: The amount the player owes
*Returns*: True if bill is paid

This allows the AI to decide how to pay a bill.

### Private Methods 

- ### streetOwned
```java
private ArrayList<Ownable> streetOwned(ArrayList<Ownable> inputTiles)
```
*Parameters*: ArrayList of all properties owned by the player
*Returns*: An array list of properties that belong to a full street owned by the player

This function should return an array list of properties owned by the players that are part of a full group. 


- ### groupOwned
```java
private boolean groupOwned(Group group)
```
*Parameters*: A tile group
*Returns*: True if the player owns all tiles in a group

This function should return an array list of properties owned by the players that are part of a full group. 

--- 