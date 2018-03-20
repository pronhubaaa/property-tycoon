# User Interface documentation
---

## Auction Class

The auction class controls the scene apearing in the centre of the board during an auction. 

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