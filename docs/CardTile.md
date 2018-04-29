---
id: CardTile-Class
title: Card Tile class
sidebar_label: Card Tile 
---

The card class is for storing action cards (Pot luck and oppertunity knocks)

### Private Attributes 
- #### type: CardType
```java
private CardType cardType;
```
Card type, oppertunity knocks or pot luck etc.

### Public Methods 
- #### Card
```java
public Card(String tileName, int tilePosition, CardType cardType)
```
*Parameters*: The name of the tile, the position and the card type
*Returns*: Void

This is the intialiser for the card. 

- #### getCardType
```java
public CardType getCardType()
```
*Parameters*: None
*Returns*: The card type

This method returns the type of card stored. 

- #### getCard
```java
public card getCard()
```
*Parameters*: None
*Returns*: A card object

This returns a card from the cardStack.


--- 