---
id: Utility-Class
title: Utility class
sidebar_label: Utility
---

The utility class extends ownable, allowing utilities to have different functions for rent and payment.

## Public Methods
### Utility
```java
public Utility(String name, int position)
```
*Parameters*: the stations name, position and ArrayList of rent prices for the different stages of ownership
*Returns*: Void

This constructor will build a station object.

### getRent
```java
public int getRent(Player player, int dice)
```
*Parameters*: The player who landed on the tile and the combined value of their roll
*Returns*: The rent the player owes

Returns the rent given the current state of ownership and the value on the dice; and checks that the player who landed on the tile is not the owner.

### applyPayment
```java
public boolean applyPayment(Player player, int dice)
```
*Parameters*: The player who owes rent and the value on the dice
*Returns*: Void

Charge the player the given rent for the tile.

---
