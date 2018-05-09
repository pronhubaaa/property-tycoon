# Game Engine documentation
---

## Jail Class

The jail class is responsible for players in jail, it contains the price to get out and can free a player from jail.  

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