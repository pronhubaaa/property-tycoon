# Game Engine documentation
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