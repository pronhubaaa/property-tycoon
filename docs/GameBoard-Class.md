---
id: GameBoard-Class
title: Game Board class
sidebar_label: Game Board
---


## Private Attributes

### gameEngine
```java
private GameEngine gameEngine;
```
This is the game engine being used with the UI in order for the players to play their game.

### tiles
```java
private Tile _tiles[];
```
All tiles present on the game Board

### parentPane
```java
private StackPane _parentPane;
```
The overall game board screen pane.

### sidebarSplitPane
```java
private VBox _sidebarSplitPane;
```
The right hand side of the game board, showing the players properties, worth, etc.


### boardPane
```java
private BorderPane _boardPane;
```
Pane containing all of the tiles.

### boardContainer
```java
private HBox _boardContainer;
```
The container holds the tiles and the board centre.

### detailsButton
```java
private Button _detailsButton;
```
This button is attaches to each tile, when clicked it will pull the tile info into the centre of the screen.

### centerStack
```java
private StackPane _centerStack;
```
This pane is the inner board, inside of the tiles. This includes the logo and dice rolling functionality.

### currentMsg
```java
private Label _currentMsg;
```
This label is for any information displayed to the player in the centre of the board.

## Public Methods
### GameBoard
```java
public GameBoard(GameEngine gameEngine)
```

*Parameters*: The current game engine, providing the information required for this board.

*Returns*: Void

This initialises the GameBoard object.

### getLayout
```java
public Scene getLayout()
```

*Parameters*: None

*Returns*: The game board scene

This builds and returns the game board object.

### createSideLayout
```java
private void _createSideLayout()
```

*Parameters*: None

*Returns*: Void

This method builds the right hand sidebar.

### reorderPlayersSidebar
```java
private void reorderPlayersSidebar()
```

*Parameters*: None

*Returns*: Void

This method reorders the player in the sidebar such that the current player is at the bottom.

### getPlayerMetaCard
```java
private static HBox getPlayerMetaCard(Player player)
```

*Parameters*: The current player

*Returns*: Void

This method builds the player information for the right hand side of the game board, including the players balance and player piece.

### createBoardLayout
```java
private void _createBoardLayout()
```

*Parameters*: None

*Returns*: Void

This method builds the game board, positioning the tiles around the game board.

### getCardStyle
```java
public VBox getCardStyle(Tile t)
```

*Parameters*: The card to find the style of

*Returns*: A vbox containing the card information

This method gets all of the card information for when a card on the board is clicked, ready to be displayed on the board centre.

### purchase
```java
public void purchase(Ownable o, Player p)
```

*Parameters*: The ownable tile to be purchased and the player purchasing the tile

*Returns*: Void

This method allows a tile on the board to be purchased by a player.

### nextTurn
```java
public void nextTurn()
```

*Parameters*: None

*Returns*: Void

This method is responsible for changing which player has the current turn.

### landed
```java
public void landed(Tile t, Player p, int roll)
```

*Parameters*: The tile the player has landed on, the player and their dice amount.

*Returns*: Void

This method is responsible for charging a player rent, or allowing them to buy/auction a property.

### moveCurrentPlayer
```java
public void moveCurrentPlayer(int[] rollNumber)
```

*Parameters*: The amount on each die

*Returns*: Void

This method is responsible for moving the player around the board, including moving their player piece.

### rollButton
```java
public void rollButton(Dice dice)
```

*Parameters*: The dice object for the current player to roll

*Returns*: Void

This method is responsible for allowing the player to roll the dice.

### displayMessage
```java
public VBox displayMessage(String s, int size)
```

*Parameters*: The message to display to the player and the font size

*Returns*: Void

This method is to display a message to the player.

### cleanStack
```java
public void cleanStack()
```

*Parameters*: None

*Returns*: Void

This method removes any overlaying objects on the centre of the game board.

### getStyle
```java
public String getStyle(Tile tile)
```

*Parameters*: The tile to get the style of.

*Returns*: Void

This method returns the colour of the street it is a member of.

### putPlayerOnTile
```java
public void putPlayerOnTile(Player p)
```

*Parameters*: The current player

*Returns*: Void

This method moves the player piece around the board as necessary.

### startGame
```java
private void startGame()
```

*Parameters*: None

*Returns*: Void

This method places all of the players on the Go tile, initialises the dice and created the roll button.
