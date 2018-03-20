# User Interface documentation
---

## GameBoardCentre Class

The game board centre class is responsible for how the centre of the board looks, and updating the amount of money on the free parking tile label. 

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