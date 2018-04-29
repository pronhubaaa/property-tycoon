---
id: TaxTile-Class
title: Tax Tile class
sidebar_label: Tax Tile 
---

The tax tile class is responsible for storing the value of the tax and charging it to players who land on this tile.  

### Private Attributes 

- amount: Int
```java
private int amount;
```
The price it costs to pay tax.

### Public Methods
- #### tax
```java
public TaxTile(String tileName, int tilePosition, int tileValue)
```
*Parameters*: The tile name, the position of the tile and the price of the tax
*Returns*: Void

Initialises the tax tile object

- #### getAmount(): Int
```java
public int getAmount()
```
*Parameters*: None
*Returns*: Tax cost

Returns the cost of the tax

- #### setFee(Int): Void
```java
public void setAmount(int amount)
```
*Parameters*: Assign the amount of money tax costs
*Returns*: Void

Set the amount of money it costs to pay tax

- #### payTax(Player): Void
```java
public void payTax(Player player)
```
*Parameters*: The player paying tax
*Returns*: Void

Charge the price of the tax to a players balance. 

--- 