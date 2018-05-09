---
id: VariablyTieredRentable-Class
title: Variably Tiered Rentable class
sidebar_label: Variably Tiered Rentable
---

The Variably Tiered Rentable class extends rentable, allowing Variably Tiered Rentable to have different functions for rent and payment.

## Private Attributes
### rent
```java
private ArrayList<Int> rent;
```
The price of rent on this tile as an arraylist.

## Public Methods
### VariablyTieredRentable
```java
public VariablyTieredRentable()
```
*Parameters*: None
*Returns*: Void

This method initilaises a Variably Tiered Rentable object.

### getRent
```java
public int getRent(Player player)
```
*Parameters*: The player who landed on the tile
*Returns*: The rent the player owes

Returns the rent given the current state of ownership and checks that the player who landed on the tile is not the owner.

### setRent
```java
public void getRent(ArrayList<Int> rent)
```
*Parameters*: The new price of rent on the tile
*Returns*: Void

Update the price of rent on the given tile