---
id: CardAction-Class
title: Card Action class
sidebar_label: Card Action
---

The card action class is responsible for storing and performing actions on given cards.

## Private Attributes
### description
```java
private String description;
```
The description of the card.

### cardActionType
```java
private CardActionType cardActionType;
```
The type of action on the card, as stored in the enum. 

### origin
```java
private Object origin;
```
The originating entity of the action.

### intent
```java
private Object intent;
```
 The entity that the action operates on or to.
 
### value
```java
private int value;
```
The value of the action.

### amountPerHouse
```java
private int amountPerHouse;
```
If $value is to be calculated, the amount per owned house.

### amountPerHotel
```java
private int amountPerHotel;
```
If $value is to be calculated, the amount per owned hotel.

### collectSalaryAtGo
```java
private boolean collectSalaryAtGo;
```
Whether, if during the performance of the action the player passes a Go tile, their salary should be collected.

### card
```java
private Card card;
```
The card this action is a member of.


## Public Methods
### CardAction
```java
public CardAction(CardActionType cardActionType, Card card, String description)
```
*Parameters*: The action type of the card, a card object and a string 
*Returns*: Void

This constructor will build a card action object.

### CardAction
```java
public CardAction(CardActionType cardActionType, Card card, String description, Object origin, Object intent, int value)
```
*Parameters*: The action type of the card, a card object and a string, the origin, the intent and the value of the card.
*Returns*: Void

This constructor will build a card action object.

### getCardActionType
```java
public CardActionType getCardActionType()
```
*Parameters*: none
*Returns*: The card action type of the card

Gets the action type of this CardAction.

### setCardActionType
```java
public void setCardActionType(CardActionType cardActionType)
```
*Parameters*: cardActionType The action type to be set.
*Returns*: Void

Sets the action type of this CardAction.

### getOrigin
```java
public Object getOrigin()
```
*Parameters*: none
*Returns*: The originating entity of this action.

Gets the originating entity of this action.


### setOrigin
```java
public void setOrigin(Object object)
```
*Parameters*: The originating entity of this action.
*Returns*: Void

Sets the originating entity of this action.

### getIntent
```java
public Object getIntent()
```
*Parameters*: none
*Returns*: The entity this action acts upon.

Gets the entity that this action acts upon.


### setIntent
```java
public void setOrigin(Object object)
```
*Parameters*: Intent The intent entity. Refer to the javadoc of the Intent field for the allowed values.
*Returns*: Void

Sets the entity that this action acts upon.


### getValue
```java
public Int getValue()
```
*Parameters*: none
*Returns*: The value of this action.

Gets the value of this action.


### setValue
```java
public void setValue(Int value)
```
*Parameters*: value The required value. Refer to the javadoc of the Value field for what this controls for various CardActionTypes.
*Returns*: Void

Sets the value of this action.

### getAmountPerHouse
```java
public Int getAmountPerHouse()
```
*Parameters*: none
*Returns*: The value per house, where an action depends on the houses owned.

Gets the value per house.


### setAmountPerHouse
```java
public void setAmountPerHouse(Int value)
```
*Parameters*: amountPerHouse The required value per house.
*Returns*: Void

Sets the value per house.

### getAmountPerHotel
```java
public Int getAmountPerHotel()
```
*Parameters*: none
*Returns*: The value per hotel, where an action depends on the hotels owned.

Gets the value per hotel.


### setAmountPerHotel
```java
public void setAmountPerHotel(Int value)
```
*Parameters*: amountPerHotel The required value per hotel.
*Returns*: Void

Sets the value per hotel.

### isCollectSalaryAtGo
```java
public boolean isCollectSalaryAtGo()
```
*Parameters*: none
*Returns*: collectSalaryAtGo - true is player can collect from go on their way past the tile.

Gets collectSalaryAtGo - true is player can collect from go on their way past the tile.


### setCollectSalaryAtGo
```java
public void setCollectSalaryAtGo(boolean collect)
```
*Parameters*: collectSalaryAtGo The value that collectSalaryAtGo should be set to.
*Returns*: Void

Sets collectSalaryAtGo - true is player can collect from go on their way past the tile.


### getCard
```java
public Card getCard()
```
*Parameters*: none
*Returns*: The card this action is a member of

Get the card that this action will be a member of


### setCard
```java
public void getCard(Card card)
```
*Parameters*: card The card to be set
*Returns*: Void

Set the card that this action will be a member of


### getDescription
```java
public String getDescription()
```
*Parameters*: none
*Returns*: The description of this action

Get the description of this action


### setDescription
```java
public void getDescription(String description)
```
*Parameters*: description The new description
*Returns*: Void

Set the description of this action


### performAction
```java
public void performAction(Player player)
```
*Parameters*: player The player the action will be executed against
*Returns*: Void

Execute this action against the provided player

---




