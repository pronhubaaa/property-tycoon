# Game Engine documentation
---
## GameEngine class
### Private Attributes

- #### gameBoard: Board
This is the representation of the board, which contains tiles, player locations, etc.

- #### players: Array of Players
This array represents all the players playing the game. The order of the array will represent the order of play.

- #### numberOfTurns: Int
This represents the current turn number. This will increment at the end of each turn.

- #### currentTurn: Player
This is a pointer to the player object whose turn it currently is.

### Public Methods

- #### GameEngine
*Parameters*: JsonObject of save file data.
*Returns*: N/A

This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time. This method will be used to load a save file, so it should fully restore a previous game state and initial the board.

- #### GameEngine
*Parameters*: JsonObject of imported board data, Array of Players, GameType enum, Int number of minutes (optional).
*Returns*: N/A

This is the constructor method. It will be used to start a new game and initialise the board.

- #### startGame
*Parameters*: None

*Returns*: Void

This method is intended to be accessed from the UI class. It will start the game.

- #### getCurrentPlayer
*Parameters*: None

*Returns*: Player whose goes it is.

This method return a pointer to the player whose turn it currently is.

- #### nextTurn
*Parameters*: None

*Returns*: Player whose go it is _now_ is.

This method will be used by the UI class to end the current player's turn and begin the next player's turn. It will be responsible for checking whether the game is over (using endGame method), changing the current player reference and incrementing the numberOfTurns attribute.

- #### getNumberOfTurns
*Parameters*: None

*Returns*: Int representing the number of turns

This method returns the accumulated number of turns in the game.

- #### incrementNumberOfTurns
*Parameters*: None

*Returns*: Void

This methods increments the numberOfTurns attribute by one.

- #### startTimer
*Parameters*: None

*Returns*: Void

This starts the timer for the abridged version of the game.

- #### stopTimer
*Parameters*: None

*Returns*: Void

This stops the timer for the abridged version of the game.

- #### getTime
*Parameters*: None
*Returns*: Void

This gets the amount of time left in the abridged version.

### Private Methods

- #### constructGameBoard
*Parameters*: JsonObject of imported board data.

*Returns*: Board

Sets up a board using the imported board data. If the JSON object contains additional data (eg. from a save file) this should be filtered out before constructing the Board object.

- #### endGame
*Parameters*: None

*Returns*: Boolean

This method is intended to be accessed from incrementCurrentTurn. It will determine whether the game is over, by using methods such as getTime (if it is the abridged version) and also by checking the number of players still in the game.

- #### addPlayer
*Parameters*: Player

*Returns*: Void

This method is used by the constructor to add a player to the engine. It will populate the players attribute array.

---
## GameType Enumeration 
### Types
- #### FullGame

In the full game there is no time limit. A winner is determined by whoever is the last player with funds.  

- #### AbridgedGame 

In the abridged game there is a time limit defined in the UI. At the end of the time the winner is the player with the most assets. 

---
## Dice Class
### Private Attributes

- #### doubleCount: Int

This integer value counts the amount of doubles a player rolls in a row.

### Public Methods

- #### roll(): [Int]
*Parameters*: None 
*Returns*: An array of integers 

This method returns the two values between 1 and 6 shown on the two dice. The function will also add to doubleCount where appropriate. 

---
## Player Class
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

## AI Class
### Public Methods

- ### decisionBuy(Ownable, Int): boolean
*Parameters*: A tile that the AI player could purchase and the Int price
*Returns*: Boolean true or false, suggesting the player should bid/buy

This allows the AI player to decide to buy or bid for a property.
 
- ### decisionTrade(int, [Ownable]): boolean
*Parameters*: A set of tiles the player may trade and the price they would recieve for them
*Returns*: Boolean suggesting if the player should make the trade

This allows the AI Player to trade a property.

- ### decisionPayBill(int, [Ownable], int): int, [Ownable]
*Parameters*: The amount the player owes, the tiles the player has and the players balance 
*Returns*: the new balance and tiles the player ownes

This allows the AI to decide how to pay a bill.

--- 

## Human Class

This class is empty as it inherits all classes and attributes of the Player class, and requires no further information. 

--- 

## Board Class 
### Private Attributes 
- #### tiles: [Tile]

All tiles that appear on the board.

- #### propertyGroups: [PropertyGroup]

The groups of properties as shown by their colour groups on the board.

- #### stationGroups: [StationGroup]

The train station tiles shown on the board.

- #### UtilityGroups: [UtilityGroup]

The utility tiles shown on the board.

- #### cards: [Card]

The "Oppertunity Knocks" and "Pot Luck" cards on the board. 

### Public Methods 

- #### Board(JsonObject)
*Parameters*: JsonObject
*Returns*: Void

The JSON data will come from the GameEngine, this includes all tiles, property groups, station groups, utility groups and cards. This constructor initialises the board.

- #### getTiles(): [Tile]
*Parameters*: None
*Returns*: An array of tiles

This method will get all tiles on the board.

- #### reorderCards(Card): Void
*Parameters*: The card being shuffled into the pack
*Returns*: Void

This allows the game to add the card to the end of a stack.

### Private Methods 

- #### addTile(Tile): Void
*Parameters*: The tile being added to the board
*Returns*: Void

This allows the game board to be initialised, tiles can be added in this way.

- ####randomiseCards(): Void
*Parameters*: None 
*Returns*: Void

This method randomises the oppertunity knocks and pot luck cards at the start of a game. 

---

## Station Group Class

### Private Attributes 
- #### stations: [Station]

All station tiles on the game board.

### Public Methods 
- #### getStations(): [Station]
*Parameters*: None 
*Returns*: An array of stations 

This method returns all of the stations on the board.

- #### setStation([Station]): Void
*Parameters*: An array of stations 
*Returns*: Void

This initialises the stations on the game board.


- #### checkOwnedStations(Player): Int
*Parameters*: A Player
*Returns*: Amount of stations that player owns

This method returns all of the stations that a player owns.

---

## Utility Group Class
### Private Attributes 
- #### utilities: [Utility]

### Public Methods 
- #### getUtilities(): [Utility]
*Parameters*: None
*Returns*: An array of utilites 

This method gets all utilities on the game board.

- #### setUtilities([Utility]): Void
*Parameters*: An array of utilities 
*Returns*: Void

This method sets the utilities on the board for initialisation.

- #### checkOwnedUtility(Player): Int
*Parameters*: A player
*Returns*: The amount of utilities they own

This method returns the amount of utilities owned by a player. 

---

## Property Group Class
### Private Attributes 
- #### properties: [Property]

The property tiles in the colour group.

- #### colour: String
 
The colour code for the colour of this particular group.

#### Public Methods 
- #### getProperties(): [Property]
*Parameters*: None
*Returns*: An array of all properties in this group

This method returns all properties in this group.

- #### setProperties([Property]): Void
*Parameters*:An array of properties 
*Returns*: Void 

Add properties to a group for the start of a game. 

- #### checkOwnedStreet(Player): Boolean
*Parameters*: The player we are checking against 
*Returns*: Boolean, true of all properties owned by the player

Check if a player owns the street.

- #### getColour(): String
*Parameters*: None
*Returns*: String containing the colour code

Gets the colour for this street.

- #### setColour(String): Void
*Parameters*: A string containing the colour for this street 
*Returns*: Void

Sets the colour of this group.

---
## Card Class
### Private Attributes 
- #### label: String

The label for this specific card "Pay £50" For example.

- #### type: CardType

Card type, oppertunity knocks or pot luck etc.

- #### action: CardAction

What this card does to the player: pay, recieve, go to jail, etc. 

### Public Methods 
- #### getLabeL(): String
*Parameters*: None
*Returns*: The label for this card

This method returns the string stating what this card does. 

- #### setLabel(String): Void
*Parameters*: String containing what the card does
*Returns*: Void

Sets what this specific card will do. 

- #### getAction(): CardAction
*Parameters*: None 
*Returns*: The action the card dictates

This is the formulated version of what the card does, allowing the movement or transaction to occur. 

- #### setAction(CardAction): Void
*Parameters*: The card action
*Returns*: Void

This sets the action that the card should dictate.

- #### getType(): CardType
*Parameters*: None
*Returns*: The type of card

This returns if the card is oppertunity knocks or pot luck.

- #### setType(CardType): Void
*Parameters*: The type of card
*Returns*: Void

This sets the type of card, this could be oppertunity knocks or pot luck.

--- 

## CardType Enumeration 
### Types
- #### PotLuck

This is one of the two types of card the player can pick up around the board.

- #### OppertunityKnocks

This is the other of the two types of card the player can pick up around the board.

---

## CardAction Interface 
### Public Methods 

- #### payParking(Int): Void

This allows the player to pay free parking.

- #### payBank(Int): Void

This allows the player to pay the bank.

- #### pay(Int, Player): Void

This allows a player to pay another player.

- #### pay(Int, [Player]): Void

This allows a player to pay multiple players.

- #### receive(Int): Void

This allows a player to recieve money from the bank.

- #### goTo(Tile): Void

This sends a player to a specific tile.

---

## Tile Class

### Private Attributes 
- #### name: String

The name of this specific tile.

- #### position: Int

The position on the board of this specific tile.

### Public Methods 

- #### getName(): String
*Parameters*: None
*Returns*: The name of the tile 

This method returns the name of this tile.

- #### getPosition(): Int
*Parameters*: None
*Returns*: The numerical position on the board this tile is in

An integer showing where this tile is located on the board.


- #### setName(String): Void
*Parameters*: String name of the tile
*Returns*: Void

Allows the name of the tile to be set.

- #### setPosition(Int): Void
*Parameters*: Integer position of the tile on the board
*Returns*: Void

This allows the tile to be allocated a place on the board. 

---

## Go Class
### Private Attributes 
- #### value: Int

The value of money given to a player for passing go.

### Public Methods 
- ### getValue(): Int
*Parameters*: None 
*Returns*: The value of money given to a player for passing go

This method gets the value of money given to a player for passing go.

- #### setValue(Int): Void
*Parameters*: Value given for passing go
*Returns*: Void

This method sets the amount of money given for passing go.

- #### collect(): Void
*Parameters*: None 
*Returns*: Void

This method gives a player their money for passing this tile. 

---

## FreeParking Class

### Private Attributes
- freeMoney: Int

The amount of money on the free parking tile.

### Public Methods 
- #### getFreeMoney(): Int
*Parameters*: None 
*Returns*: Amount of money on the free parking tile

Function returns the amount of money on the free parking tile.

- #### addFreeMoney(Int): Void
*Parameters*: Amount to add to free pakring tile
*Returns*: Void

Adds a given amount to the free parking tile.

- #### collectMoney()
*Parameters*: None 
*Returns*: Void

Allows a player to collect the money on the tile for landing on it.

---

## Ownable 
### Private Attributes 
- #### owner: Player

This is the player who owns this tile.

- #### price: Int

This is the price for this tile.

- #### mortgagePrice: Int

This is the morgage price for this tile.

### Public Methods 
- #### isOwned(): Boolean
*Parameters*: None 
*Returns*: Boolean, true if the tile has an owner

This method returns if the property is owned or not.

- #### getPrice(): Int
*Parameters*: None 
*Returns*: The price for this tile

This method returns the price of this property.

- #### setPrice(Int): Void
*Parameters*: The given price for this tile
*Returns*: Void

This method sets the price for the property for initialisation. 

- #### getMortgagePrice(): Int
*Parameters*: None 
*Returns*: The mortgage value of the property 

This method gets the value given to the player for morgaging the property.

- #### setMortgagePrice(Int): Void
*Parameters*: The given morgage price for this tile 
*Returns*: Void

This method will set the morgage price for the property. 

- #### getOwner(): Player
*Parameters*: None 
*Returns*: The player who owns the tile 

This method returns the player who owns the tile.

- #### setOwner(Player): Void
*Parameters*: Assign a player to own this tile
*Returns*: Void

This method allows a player to own the tile.

---

## Jail Class
### Private Attributes 

- fee: Int

The price it costs to get out of jail.

### Public Methods 
- #### getFee(): Int
*Parameters*: None
*Returns*: Get out of jail fee

Returns the fee to get out of jail.

- #### setFee(Int): Void
*Parameters*: Assign the amount of money it costs to get out of jail
*Returns*: Void

Set the amount of money it costs to get out of jail.

- #### freeFromJail(Player): Void
*Parameters*: The player you want to move to "Just visiting" 
*Returns*: Void

Allows a player to move out of jail.

--- 

## GoToJail Class

### Public Methods 
- #### sendToJail(Player): Void
*Parameters*: The player you want to move to jail
*Returns*: Void

This method allows a player to be moved to jail.

---

## Facility Interface 

### Public Methods

- #### calculateRent(): Void 
*Parameters*: None
*Returns*: Void

This allows the rent for a utility or station to be calculated.

---

## Utility Class

The utility class is of the Facility Interface type, as such this is the only method is the inherited method from the interface. 

---

## Station Class

The station class is of the Facility Interface type, as such this is the only method is the inherited method from the interface. 

---

## Property Class

### Private Attributes 
- #### rent: [Int]

This is an array of the price of rent on the property, each slot will represent as follows: 
-- The standard rent 
-- The rent when the group is owned
-- The rent with one house
-- The rent with two houses
-- The rent with three houses 
-- The rent with four houses 
-- The rent with a hotel

- #### costOfHouse: Int

This integer represents the cost to put a house on this property.

- #### sellPrice: Int
The price this property is worth, given all houses/hotels. 

- #### amountOfHouses: Int
The amount of houses on the property.

### Public Methods 
- #### getRent(): [Int]
*Parameters*: None
*Returns*: Array of prices the rent may be

This returns an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'. 

- #### setRent([Int]): Void
*Parameters*: Array of prices for the rent
*Returns*: Void

This sets an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'.

- #### getCostOfHouse(): Int
*Parameters*: None
*Returns*: The price to put a house on the property

This method gets the cost to put a house on this property.

- #### setCostOfHouse(Int): Void
*Parameters*: Price for a house on this property 
*Returns*: Void

This method allows the price to buy a house on this property to be set. 

- #### getSellPrice(): Int
*Parameters*: None
*Returns*: The price this property is worth

Gives the integer value that this property is worth given all houses/ hotels on the property.

- #### setSellPrice(Int): Void
*Parameters*: The new sell price of this property
*Returns*: Void

Set a new value for selling this property.

- #### addHouses(): Void
*Parameters*: None
*Returns*: Void

Add a house to the property.

- #### removeHouses(Int): Void
*Parameters*: Amount of houses to remove
*Returns*: Void

Remove houses from the property.

--- 

## Game Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game being played.
- #### ui: UI
The current interface objects being used.

- #### minPlayers: Int
The minimum amount of players able to play.
- #### maxPlayers: Int
The maximum amount of players able to play.
### Public Methods 
- #### Game()
*Parameters*: None
*Returns*: Void

This constructor will construct the gmae user interface.

### Private Methods 
- #### constructUI(GameEngine): Void
*Parameters*: A game engine
*Returns*: Void

This will build a user interface given a setup game engine, this being the data used to initialise the board.

---

## PostGame Class
### Private Attributes 
- #### returnButton: Button
The return button allows a player to go back to the main screen.

- #### players: [PostGameRow]
This is an array of all players and how they did in the game.

### Public Methods 
- #### PostGame(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This will initialise the results page.

### Private Methods
- #### returnToMainMenu(): Void
*Parameters*: None
*Returns*: Void

This will return the player to the home screen.

---

## PostGameRow Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### postionLabel: Label
The rank of this player.
- #### pieceImage: ImageView
The players piece.
- #### nameLabel: Label
The name of the player.
### Public Methods 
- #### PostGameRow(GameEngine)
*Parameters*: None
*Returns*: A game engine

Initialise the statistics for the players.

---
## UI Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
### Public Methods 
- #### UI(GameEngine)
*Parameters*: The current game engine
*Returns*: Void

Initialise the user interface for the current dataset.

### Private Methods
- #### factoryMainMenu(GameEngine): MainMenu
*Parameters*: None
*Returns*: Void

This will show the main menu screen in the UI.

- #### createGame(GameEngine): Game
*Parameters*: The current game engine 
*Returns*: A game object 

This will create the UI screen for the current game.
- #### createPostGame(GameEngine): PostGame
*Parameters*: The current game engine 
*Returns*: a post game object showing the leaderboard 

This will create a results screen for after the game.
- #### showScene(Scene): Void
*Parameters*: The screen being displayed 
*Returns*: Void

This method allows us to view a specific scene, game, menu etc. 

---
## MainMenu Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
### Public Methods 
- #### MainMenu(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This method will initialise the menu with the data for the current game (Should there be any).
- #### factoryLoadingMenu(): Scene
*Parameters*: None
*Returns*: The loading screen

This is the loading screen seen between screens.

### Private Methods
- #### showScene(Scene): Void
*Parameters*: the screen to be displayed 
*Returns*: Void

This allows this scene to be outputted to the users screen. 

---
## LoadGame Class
### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### labels: [Label]
This array of labels are the titles that will be used on this page.
- #### returnButton: Button
This will return the player to the previous screen.
- #### gameComboBox: [PreviousGame]
The combo box shows all previous save files of the game.

### Public Methods 
- #### LoadGame(GameEngine)
*Parameters*: The game engine for the given save file
*Returns*: Void
This will allow a previously saved game to be loaded in as a game engine.

### Private Methods
- #### readSavedGames(): [JsonObject]
*Parameters*: None
*Returns*: An array of JSON data

This private method reads the JSON data representing the previous game saves. This is used to initialise this page.

- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This method allows the previous screen to be loaded once more.

---


## PreviousGame Class

### Private Attributes 

- #### playerLabel: Label
Label to say 'Player: '.
- #### lastPlayedLabel: Label
Label to say 'Last Played: '.
- #### gameCreatedLabel: Label
Label to say 'Game Created: '.
- #### turnLabel: Label
Label to say 'Turn: '.
- #### playerLabelData: Label
The players names, stored in JSON data.
- #### lastPlayedLabelData: Label
The last time the game was played, stored in JSON data.
- #### gameCreatedLabelData: Label
The date the game was created, stored in JSON data.
- #### turnLabelData: Label
Which players turn it is in this game, stored in JSON data.
- #### loadButton: Button
This button will load in this version of the game.

### Public Methods 
- #### PreviousGame(JsonObject)
*Parameters*: JSON data from previous game.
*Returns*: Void

This method will initilaise data from the previous game. 

---
## SetUpGame Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### playersScene: Scene
Scene on the screen asking for player names, types and pieces. 
- #### boardScene: Scene
Scene on the screen asking which version of the board is being used.
- #### gameType: Scene
Scene on the screen asking which verison of the game is being played.
- #### labels: [Label]
All labels being used on this screen such as "New Game" at the top.
- #### buttons: [Button]
All buttons being used on this screen such as "Start Game".
### Public Methods 
- #### SetUpGame(GameEngine)
*Parameters*: The current gameEngine
*Returns*: Void

This will initialise the new game screen to be displayed to the user. 

### Private Methods
- #### startGame(): Void
*Parameters*: None
*Returns*: Void

This will being a game given the information added on this screen.

- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This will return to the previous screen.

---

## SetUpPlayers Class

### Private Attributes 
- #### players: [SetUpPlayer]
All players who will be in this new game.
- #### addPlayer: Button
This button will add a player to the current game.
- #### playerCount: Int
This will count the amount of players in the game.
### Public Methods 
- #### SetUpPlayers()
*Parameters*: None
*Returns*: Void

This method will initialise the values in the class given from its subclass SetUpPlayer.

---
## SetUpPlayer Class

### Private Attributes 
- #### name: TextField
The name of the player being added.

- #### playerType: ToggleSwitch
The type of player being added, AI or human. 

- #### pieces: [Button]
The players choosen piece: hatstand, cat, etc. 

- #### labels: [Label]
All labels used on this screen.

### Public Methods 
- #### SetUpPlayer()
*Parameters*: None
*Returns*: Void

This will allow players to be added to the game engine.

### Private Methods
- #### constructName(): Void
*Parameters*: None
*Returns*: Void

This will display a box asking the user to enter the player name.

- #### constructPlayerTypeToggle(): Void
*Parameters*: None
*Returns*: Void

This will create the toggle switch between AI and Human.

- #### constructPieces(): Void
*Parameters*: None
*Returns*: Void

This will display the pieces that a player could possibly be. 

- #### constructLabels(): Void
*Parameters*: None
*Returns*: Void

This will build the titles for this scene.

---

## PlayerType Enumeration 

## Types

- #### Person
The person type is a human palyer.
- #### AI 
The AI player is the computer posing as an opponent.

–––
## PlayerPiece Enumeration 

## Types

- #### Boot

- #### Smartphone

- #### Goblet

- #### Hatstand

- #### Cat

- #### Spoon


These are the different pieces that a player could play as. 
–––

## SetUpBoard Class

### Private Attributes 
- #### boardDropDown: ComboBox
This is the dropdown box showing each board that can be used. 
- #### boards: [JsonObject]
This contains the data required to setup a game engine of a specific board.
- #### importButton: Button
This button will allow boards to be added to the game from the users device.
- #### label: Label
This label says "Board type".

### Public Methods 
- #### SetUpBoard()
*Parameters*: None
*Returns*: Void

This will initialise the scene.

### Private Methods
- #### getBoards(): [JsonObject]
*Parameters*: None
*Returns*: An array of JSON data

This will get the data necessary to display the different types of board that the player could use. 

- #### constructLabel(): Void
*Parameters*: None
*Returns*: Void

This will construct a label for the name of the game board. 

---

## SetUpGameType Class

### Private Attributes 
- #### gameTypeButtons: [Button]

These buttons show the different game types the player could use, abridged or full. 

- #### gameTypeTitle: Label
 
This label says "Game Types".

### Public Methods 
- #### SetUpGameType()
*Parameters*: None
*Returns*: Void

This will initialise this scene. 

---

## FullGameButton Class

### Private Attributes 
- #### titleLabel: Label
The title of this game type: "Full Game".
- #### descriptionLabel: Label
A descriptionary label explaining what this game type is.

### Public Methods 
- #### FullGameButton()
*Parameters*: None
*Returns*: Void

This will initialise the button for displaying. 

---

## AbridgedGameButton Class

### Private Attributes 
- #### titleLabel: Label
This is the title of the button: "Abridged Game".
- #### descriptionLabel: Label
This is a breif description of what the button does.
- #### timeLimitLabel: Label
This is a label saying "Time Limit: ".
- #### timeUnitLabel: Label
This follows a text field after the time limit label saying "Mins".
- #### timeTextField: TextField
This goed between the time limit and units, allowing the user to set the time limit. 
### Public Methods 
- #### AbridgedGameButton()
*Parameters*: None
*Returns*: Void

This initilaises the button with a blank text field for the player to enter a numerical value into. 

---

## Settings Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.
- #### returnButton: Button
This button will take the user to the previous screen. 
### Public Methods 
- #### Settings(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This will initialise the settings screen given the current game engine. 
### Private Methods
- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This method will allow the player to move to the previous screen. 

---

## LoadBoard Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.

### Public Methods 
- #### LoadBoard(GameEngine)
*Parameters*: A GameEngine
*Returns*: Void

This will load a laederboard screen for best games/players. 

### Private Methods
- #### saveBoard(JsonObject): Void
*Parameters*: A set of JSON data
*Returns*: Void

This will get the data for this screen from previous save files. 

---

## GameUI Class

### Private Attributes 
- #### gameEngine: GameEngine

The game engine for this game.

### Public Methods 
- #### Game(GameEngine)
*Parameters*: The game engine data 
*Returns*: Void

Initialise the game screen.

---

## MainView Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine for this game.
- #### inGameSettings: Scene
The in game settings, given from subclass as a scene to be displayed.
- #### sidebar: Scene
The sidebar for this game, given from subclass as a scene to be displayed.
- #### gameBoard: Scene
The game board with set tile layout, given from subclass as a scene to be displayed.
### Public Methods 
- #### MainView(GameEngine)
*Parameters*: The data from the game engine 
*Returns*: Void

This allows the game screen to be dispalyed.

---

## InGameSettings Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### menuLabel: Label
Label for the top of the screen saying "Settings".
- #### returnButton: Button
A return to game button.
- #### saveButton: Button
A save game button.
- #### exitButton: Button
An exit game button.
### Public Methods 
- #### InGameSettings(GameEngine)
*Parameters*: None
*Returns*: The game engine 

This will initialise the setings screen.

### Private Methods
- #### returnToGame(): Void
*Parameters*: None
*Returns*: Void

This will remove the scene from the players view.

- #### saveGame(): Void
*Parameters*: None
*Returns*: Void

This will save the game to JSON data.  

- #### exitGame(): Void
*Parameters*: None
*Returns*: Void

This will take the player to the menu screen.

---

## Sidebar Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### settingsButton: Button
A button leading to the in game settings screen.
- #### players: [SidebarRow]
An array of sidebarRows showing the players, their money, etc.  
- #### primaryPlayer: SidebarPrimaryPlayer
The player whos turn it is and their money, etc. 

### Public Methods 
- #### Sidebar(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise this scene with the data from the game engine.

---

## SidebarRow Class

### Private Attributes 
- #### pieceImage: ImageView
The players piece.
- #### amountLabel: Label
The amount of money the player has.
### Public Methods 
- #### SidebarRow(Image)
*Parameters*: The image for the players piece 
*Returns*: Void

Display the players piece on their tab of the sidebar.

- #### SidebarRow(Image, Int)
*Parameters*: The players piece and their amount of money 
*Returns*: Void

Create the players tab for the given player. 

---

## SidebarPrimaryPlayer Class

### Private Attributes 
- #### pieceImage: ImageView
The players piece.
- #### amountLabel: Label
The amount of money the player has.
- #### nameLabel: Label
The players name.
### Public Methods 

- #### SidebarPrimaryPlayer(Player)
*Parameters*: The player
*Returns*: Void

Create the players tab for the current player.

---

## GameBoard Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine data.
- #### tiles: [GameBoardTile]
All tiles present on the board, as given by another object GameBoardTile.

### Public Methods 
- #### GameBoard(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display the game board to the user. 

---

## Dialog Class

### Private Attributes 
- #### titleLabel: Label
The label of this direction.
- #### actionLabel: Label
The action of this direction.
- #### finishButton: Button
The button removing this dialog from the player screen.

### Public Methods 
- #### Dialog()
*Parameters*: None
*Returns*: Void

Initialise a dialog.

### Private Methods
- #### finishButton(): Void
*Parameters*: None
*Returns*: Void

Button moving the player back to the game screen.

---

## GameBoardTile Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### playersImage: [Image]
An array of the player images to put with owned tiles.


---

## GameBoardPropertyTile Class

### Private Attributes 
- #### amountLabel: Label
The cost to buy a property.
- #### colour: Scene
The colour of the set this belongs to. 
- #### nameLabel: Label
The name of the property.
### Public Methods 
- #### GameBoardPropertyTile(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display the tile on the game board.

### Private Methods
- #### tapped(): Void
*Parameters*: None
*Returns*: Void

Enlarge tile when tapped on.

---

## GameBoardCardTile Class

### Private Attributes 
- #### tileImage: ImageView
The image for this space.

### Public Methods 
- #### GameBoardCardTile(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display a card on the screen. 

---
## GameBoardTaxTile Class

### Private Attributes 
- #### amountLabel: Label
The cost for landing on this tile.

- #### image: ImageView
The image on this tile.

### Public Methods 
- #### GameBoardTaxTile(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Show this tile on the board.

---
## GameBoardGoTile Class

### Private Attributes 
- #### goLabel: Label
The go tile label: "Go!".
### Public Methods 
- #### GameBoardGoTile(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display this tile on the board.

---

## GameBoardGoToJailTile Class

### Private Attributes 
- #### goToJailLabel: Label
Go to jail label: "Go to jail!".

### Public Methods 
- #### GameBoardGoToJailTile(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display this tile on the board.


---
## GameBoardFreeParkingTile Class

### Private Attributes 
- #### freeParkingLabel: Label
Free parking text: "Free Parking!". 

### Public Methods 
- #### GameBoardFreeParkingTile(GameEngine)
*Parameters*: The current game engine
*Returns*: Void

Display this tile on the board. 

---
## GameBoardJailTile Class

### Private Attributes 
- #### jailLabel: Label
Jail text: "Jail!".
- #### backgroundImage: ImageView
The image behind the "In jail" tile. 

### Public Methods 
- #### GameBoardJailTile(GameEngine)
*Parameters*: None
*Returns*: Void

Display the tile on the board.

---

## GameBoardCentre Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### gameTitle: Label
The title of the game "Property tycoon!". 
- #### freeParkingLabel: Label
The free parking label for the amount stored on free parking.
### Public Methods 
- #### GameBoardCentre(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Display the tile on the board.

- #### updateFreeParkingAmount(Int): Void
*Parameters*: New amount on free parking 
*Returns*: Void

Update the label for a new amount of money.

---
## DiceRoll Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### titleLabel: Label
Label saying "Current roll!".
- #### rollButton: Button
A roll dice button.
- #### highestRollLabel: Label
A label for stating the highest roll for the start of game activity.
- #### actionLabel: Label
A label for after dice roll. 
### Public Methods 
- #### DiceRoll(GameEngine)
*Parameters*: Current game engine 
*Returns*: Void

Initialise the scene.

### Private Methods
- #### roll(): Void
*Parameters*: None
*Returns*: Void

Roll the two dice.

- #### updateView(): Void
*Parameters*: None
*Returns*: Void

Update the board view given the changes. 

---
## BuildHouses Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### properties: [PropertyDetails]
Property to place house on.

### Public Methods 
- #### BuildHouses()
*Parameters*: None
*Returns*: Void

Add a house to the property and display on board.

---

## Auction Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### property: PropertyDetails
The property tile in question to be displayed on the auction screen.
- #### descriptionLabel: Label
A description of the auction.
- #### bidLabel: Label
The current highest bid.
- #### amountTextField: TextField
Amount the player wishes to bid.
- #### bidButton: Button
Button to place a bid.
- #### withdrawButton: Button
Withdraw from the auction button.

### Public Methods 
- #### Auction(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise an auction scene.

### Private Methods
- #### bid(): Void
*Parameters*: None
*Returns*: Void

Updated the screen to show new bids.

- #### withdraw(): Void
*Parameters*: None
*Returns*: Void

Updates the screen to show a player has withdrawn from the auction. 

---
## PropertyDetails Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### nameLabel: Label
The name of the property.
- #### colour: Scene
The colour set of the current property, represented as a scene. 
- #### priceLabel: Label
The standard price of the property.
- #### priceAmountLabel: Label
The actual amount of the property.
- #### rentLabel: Label
The standard rent for this property.
- #### rentRow: [PropertyDetailsHouseRow]
The rent given houses.
- #### bottomBar: Scene
The colour of the base of the property.

### Public Methods 
- #### PropertyDetails(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise a property details scene.

---
## PropertyDetailsHouseRow Class

### Private Attributes 
- #### housesLabel: Label
Rent label.
- #### housesAmount: Label
Amount of houses, increases by one per row. 
### Public Methods 
- #### PropertyDetailsHouseRow(Int, Int)
*Parameters*: The row and the amount as integers.
*Returns*: Void

Initialise a new row. 

---
## PropertyDetailsSold Class

### Private Attributes 
- #### mortgageLabel: Label
Morgage label for when a property is being morgaged.
- #### mortgageAmountLabel: Label
The amount the property is being morgaged for.

### Public Methods 
- #### PropertyDetailsSold(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise a mortgage property scene. 

---












