 # AI Player documentation
---

## AI Class

This class is used to create an artificial player. 

### Public Methods

- ### buyTile(Ownable, Int): boolean
*Parameters*: A tile that the AI player could purchase and the Int price
*Returns*: Boolean true or false, suggesting the player should bid/buy

This allows the AI player to decide to buy or bid for a property.
 
- ### trader(int, [Ownable]): boolean
*Parameters*: A set of tiles the player may trade and the price they would recieve for them
*Returns*: Boolean suggesting if the player should make the trade

This allows the AI Player to trade a property.

- ### bid(int, [Ownable], Tile): int, [Ownable]
*Parameters*: A set of tiles the player owns, the price they would pay for the new tile and the tile in question
*Returns*: The players new balance and their updated list of tiles they own.

This allows the AI Player to trade a property.

- ### payBill(int, [Ownable], int): int, [Ownable]
*Parameters*: The amount the player owes, the tiles the player has and the players balance 
*Returns*: the new balance and tiles the player ownes

This allows the AI to decide how to pay a bill.

### Private Methods 

- ### findOwned(Ownable): Int
*Parameters*: One ownable tile from a group
*Returns*: The most owned by another player

This function should return the most properties in the group of the input tile owned by another player.

- ### streetOwned(Void): ArrayList
*Parameters*: Void
*Returns*: An array list of properties that belong to a full street owned by the player

This function should return an array list of properties owned by the players that are part of a full group. 

--- 