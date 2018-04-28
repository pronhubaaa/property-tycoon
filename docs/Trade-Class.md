---
id: Trade-Class
title: Trade class
sidebar_label: Trade
---

This class allows players to trade amongst each other.

## Private Attributes
### players
```java
private HashMap<Player, ArrayList<Ownable>> players;
```

The ownables present in the trade, indexed by their owner. 

### player1
```java
private Player player1;
```

The first player in the trade.

### player2
```java
private Player player2;
```

The seconds player in the trade. 

## Public Methods

### Trade
```java
public Trade(Player player1, Player player2)
```
*Parameters*: Two players present in the trade
*Returns*: Void

Constructor for trade object, setting players 1 and 2 and initialising the hash map. 

### addOwnable
```java
public void addOwnable(Player player, Ownable ownable)
```
*Parameters*: A player, the ownable tiles they wish to trade
*Returns*: Void

This method allows ownable items to be added to the hashmap 

### acceptTrade
```java
public boolean acceptTrade(boolean boolean1, boolean boolean2)
```
*Parameters*: boolean from each player accepting or denying the trade 
*Returns*: Void

This function will allow players to decide if they want to trade for the current ownables.

## Private Methods
### tradeOwnable
```java
private void tradeOwnable()
```
*Parameters*: void
*Returns*: Void

This method will exchange the tiles being traded between the two players.
