# Game Engine documentation
---
## Player Class

The player class is responsible for storing a players assets and storing methods for how players can perform actions. 

### Private Attributes

- #### inJail: Boolean
This represents if the player is in jail or not.

- #### balance: Int 
This is the players avaliable money.

- #### name: String
This is the name of the player.

- #### position: Tile 
The players current position on the board, represented by a tile object which is the location on the board.

- #### ownedTiles: [Ownable]
This is an array of all the 'ownable' tiles that the player owns. 'Ownable' is an array of all tiles that is is possible for a player to posses. 

- #### piece: PlayerPiece
This is the object that the player is displayed as in the GUI. 

### Public Methods 

- #### Player(Int, String)
*Parameters*: Int for the player balance, String for the players name
*Returns*: Void

This is the initialiser for the object, it initialises the name and balance.

- #### buyTile(Tile): Boolean
*Parameters*: The tile the player wishes to buy
*Returns*: Boolean- true if purchase successful 

This allows a player to purchase a tile on the board.

- #### isBankrupt(): Boolean
*Parameters*: None
*Returns*: Boolean- true if player has no funds avaliable, cash or property.

This method returns if a player has no funds and is thus out of the game.

- #### mortgageTile(Tile): Boolean
*Parameters*: The tile the player wishes to mortgage
*Returns*: Boolean - true if mortgage successful 

This method allows a player to mortgage a tile.

- #### getName(): String
*Parameters*: None  
*Returns*: The players name

This method will give the name of the player. 

- #### setName(String): Void
*Parameters*: Player name
*Returns*: Void

This method sets the players name.

- #### getInJail(): Boolean
*Parameters*:  None
*Returns*: Boolean- true if player is in jail

This method chekcs if the player is in jail.

- #### setInJail(Boolean): Void
*Parameters*:  Boolean true if moving to jail, false if moving to just visiting
*Returns*: Void

This method moves a plyer in and out of jail.

- #### getBalance(): Int
*Parameters*:  None
*Returns*: Players avaliable balance

This method returns the amount of money the player currently has.

- #### getPosition(): Tile
*Parameters*:  None
*Returns*: The tile the player is currently on

This shows the current location of a player.

- #### setPostion(Tile): Void
*Parameters*:  The tile the player is moving to
*Returns*: Void

This method moves the player to another space on the board.

- #### getOwnables(): [Ownable]
*Parameters*:  None
*Returns*: All tiles owned by the player

This returns an array of the abstract objects called ownables that the player currently owns. Ownables are tiles that is it possible for a player to buy. 

- #### addOwnable(Ownable): Void
*Parameters*:  A tile that a player can possess
*Returns*: Void

Allows a player to own a property, through purchasing auction or otherwise. 

- #### setPlayerPiece(PlayerPiece): Void
*Parameters*:  A PlayerPiece object from the enumerator
*Returns*: Void

This assigns a player a specific player piece, this could be a hatstand, cat, etc. 

- #### getPlayerPiece(): PlayerPiece
*Parameters*:  None
*Returns*: The piece the player is playing as

Return the piece that the player is playing as this could be a hatstand, cat, etc.

###  Private Methods 
- #### setBalance(Int): Void
*Parameters*:  Amount of money the player now has
*Returns*: Void

Set the amount of money a player has.

---