---
id: Station-Class
title: Station class
sidebar_label: Station
---

The station class extends ownable, allowing stations to have different functions for rent and payment.

### Private Attributes 
#### rent
```java
private ArrayList<Int> rent;
```
The price of rent on this tile as an arraylist.

### Public Methods 
#### Station
```java
public Station(String name, int position, ArrayList<Int> rent)
```
*Parameters*: the stations name, position and ArrayList of rent prices for the different stages of ownership
*Returns*: Void

This constructor will build a station object. 

#### getRent
```java
public int getRent(Player player)
```
*Parameters*: The player who landed on the tile
*Returns*: The rent the player owes

Returns the rent given the current state of ownership and checks that the player who landed on the tile is not the owner. 

#### setRent
```java
public void getRent(ArrayList<Int> rent)
```
*Parameters*: The new price of rent on the tile
*Returns*: Void

Update the price of rent on the given tile

#### applyPayment
```java
public boolean applyPayment(Player player)
```
*Parameters*: The player who owes rent
*Returns*: Void

Charge the player the given rent for the tile

---



