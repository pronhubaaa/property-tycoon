# Game Engine documentation
---

## Ownable Class
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