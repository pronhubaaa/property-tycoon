# Game Engine documentation
---

## FreeParking Class

The free parking class will contain all of the money stored on this tile, it will also be responsible for updating this amount. 

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