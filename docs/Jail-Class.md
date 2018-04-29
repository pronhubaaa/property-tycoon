---
id: Jail-Class
title: Jail class
sidebar_label: Jail
---

The jail class is responsible for players in jail, it contains the price to get out and can free a player from jail.  

### Private Attributes 

- fee: Int
```java
private int fee;
```
The price it costs to get out of jail.

### Public Methods 
- #### Jail
```java
public Jail(String name, int position, int value)
```
*Parameters*: The name of the tile, the position and the fee to get out of jail
*Returns*: Void

Initialises the jail tile

- #### getFee(): Int
```java
public int getFee()
```
*Parameters*: None
*Returns*: Get out of jail fee

Returns the fee to get out of jail.

- #### setFee(Int): Void
```java
public void setFee(int fee)
```
*Parameters*: Assign the amount of money it costs to get out of jail
*Returns*: Void

Set the amount of money it costs to get out of jail.

- #### freeFromJail(Player): Void
```java
public void freeFromJail(Player player)
```
*Parameters*: The player you want to move to "Just visiting" 
*Returns*: Void

Allows a player to move out of jail.

--- 