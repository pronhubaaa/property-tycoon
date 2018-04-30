---
id: Player-Class
title: Player class
sidebar_label: Player 
---


The player class is responsible for storing a players assets and storing methods for how players can perform actions. 

### Private Attributes

- #### inJail
```java
private boolean inJail;
```
This represents if the player is in jail or not.

- #### balance
```java
private int balance;
```
This is the players avaliable money.

- #### name
```java
private String name;
```
This is the name of the player.

- #### position
```java
private Tile position;
```
The players current position on the board, represented by a tile object which is the location on the board.

- #### ownedTile
```java
private ArrayList<Ownable> ownedTiles;
```
This is an array of all the 'ownable' tiles that the player owns. 'Ownable' is an array of all tiles that is is possible for a player to posses. 

- #### piece
```java
private PlayerPiece piece;
```
This is the object that the player is displayed as in the GUI.

- #### board
```java
private Board board;
```
This is the board object.

### Public Methods 

- #### Player
```java
public Player(int balance, String name, Board board)
```
*Parameters*: Int for the player balance, String for the players name, Board for the board
*Returns*: Void

This is the initialiser for the object, it initialises the name and balance.

- #### buyTile
```java
public boolean buyTile(Tile ownable)
```
*Parameters*: The tile the player wishes to buy
*Returns*: Boolean- true if purchase successful 

This allows a player to purchase a tile on the board.

- #### sellTile
```java
public boolean sellTile(Tile tile)
```
*Parameters*: The tile the player wishes to sell
*Returns*: Boolean- true if sale successful 

This allows a player to sell a tile they own on the board.

- #### isBankrupt
```java
public boolean isBankrupt()
```
*Parameters*: None
*Returns*: Boolean- true if player has no funds avaliable, cash or property.

This method returns if a player has no funds and is thus out of the game.

- #### mortgageTile
```java
public boolean mortgageTile(Tile tile)
```
*Parameters*: The tile the player wishes to mortgage
*Returns*: Boolean - true if mortgage successful 

This method allows a player to mortgage a tile.

- #### getName
```java
public String getName()
```
*Parameters*: None  
*Returns*: The players name

This method will give the name of the player. 

- #### setName
```java
public void setName(String name)
```
*Parameters*: Player name
*Returns*: Void

This method sets the players name.

- #### getBoard
```java
protected Board getBoard()
```
*Parameters*: none
*Returns*: the current game board

Get the current board

- #### getInJail
```java
public boolean getInJail()
```
*Parameters*:  None
*Returns*: Boolean- true if player is in jail

This method checks if the player is in jail.

- #### setInJail
```java
public void setInJail(boolean inJail)
```
*Parameters*:  Boolean true if moving to jail, false if moving to just visiting
*Returns*: Void

This method moves a player in and out of jail.

- #### getBalance
```java
public int getBalance()
```
*Parameters*:  None
*Returns*: Players available balance

This method returns the amount of money the player currently has.

- #### setBalance
```java
public void setBalance(int balance)
```
*Parameters*:  Players new available balance
*Returns*: Void

This method sets the amount of money the player currently has.

- #### addBalance
```java
public void addBalance(int amount)
```
*Parameters*:  Amount to add to players balance.
*Returns*: Void

This method sets the amount of money to add to what the player currently has.

- #### getPosition
```java
public Tile getPosition()
```
*Parameters*:  None
*Returns*: The tile the player is currently on

This shows the current location of a player.

- #### setPostion
```java
public void setPosition(Tile position)
```
*Parameters*:  The tile the player is moving to
*Returns*: Void

This method moves the player to another space on the board.

- #### getOwnedTiles
```java
public ArrayList<Ownable> getOwnedTiles()
```
*Parameters*:  None
*Returns*: All tiles owned by the player

This returns an array of the abstract objects called ownables that the player currently owns. Ownables are tiles that is it possible for a player to buy. 

- #### addOwnable
```java
public void addOwnable(Ownable ownedTile)
```
*Parameters*:  A tile that a player can possess
*Returns*: Void

Allows a player to own a property, through purchasing auction or otherwise. 

- #### setPlayerPiece
```java
public void setPiece(PlayerPiece piece)
```
*Parameters*:  A PlayerPiece object from the enumerator
*Returns*: Void

This assigns a player a specific player piece, this could be a hatstand, cat, etc. 

- #### getPlayerPiece
```java
public PlayerPiece getPiece()
```
*Parameters*:  None
*Returns*: The piece the player is playing as

Return the piece that the player is playing as this could be a hatstand, cat, etc.

- #### removeOwnable
```java
public PlayerPiece getPiece()
```
*Parameters*:  the player owned tile to remove
*Returns*: Void

Remove a tile from the players owned tiles and return it to the bank

---