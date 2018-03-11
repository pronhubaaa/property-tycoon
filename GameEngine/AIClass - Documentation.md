# AI Player documentation
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