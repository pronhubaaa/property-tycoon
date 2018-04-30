---
id: CardStack-Class
title: Card Stack class
sidebar_label: Card Stack
---

The card stack object will hold a stack of card objects of a specific type (Oppertunity Knocks or Pot Luck).

## Private Attributes
### cardTile
```java
private CardTile cardTile;
```
The type of cards stored in the stack

## Public Methods
### cardStack
```java
public CardStack(CardType cardType)
```
*Parameters*: The type of card stored in this stack
*Returns*: Void

This method initialises the cardStack object

### getCardType
```java
public CardType getCardType()
```
*Parameters*: None
*Returns*: The card type of the stack

This method returns the type of card in the stack

### setCardType
```java
public void setCard(CardType cardType)
```
*Parameters*: The new card type of the stack
*Returns*: Void

This method sets the type of card in the stack

### shuffle
```java
public void shuffle()
```
*Parameters*: None
*Returns*: Void

This method shuffles the cards in the stack


---
