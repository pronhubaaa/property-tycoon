# Game Engine documentation
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