---
id: Station-Class
title: Station class
sidebar_label: Station
---

The station class extends ownable, allowing stations to have different functions for rent and payment.

## Public Methods
### Station
```java
public Station(String name, int position, ArrayList<Int> rent)
```
*Parameters*: the stations name, position and ArrayList of rent prices for the different stages of ownership
*Returns*: Void

This constructor will build a station object.


### applyPayment
```java
public boolean applyPayment(Player player)
```
*Parameters*: The player who owes rent
*Returns*: Void

Charge the player the given rent for the tile

---
