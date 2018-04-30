---
id: Rentable-Class
title: Rentable class
sidebar_label: Rentable
---

The Rentable class extends Ownable, allowing Rentable tiles (stations and utilities) to have different functions for rent and payment than property.


## Public Methods
### Rentable
```java
public Rentable()
```
*Parameters*: None
*Returns*: Void

This method initilaises a Rentable object.

### applyRentPayment
```java
public boolean applyRentPayment(Player player)
```
*Parameters*: The player who landed on the tile who owes rent
*Returns*: True of the payment is sucessful

Charges the player rent

### calculateRent
```java
public int calculateRent(Player player)
```
*Parameters*: The player who landed on the tile who owes rent
*Returns*: The cost of the rent

Get the charge for rent for landing on this tile.

---