# Game Engine documentation
---

## Property Class

The property class stores all information related to a property on the board, this being the rent, amount of houses present, etc. It also contains methods to change these figures. 

### Private Attributes 
- #### rent: [Int]

This is an array of the price of rent on the property, each slot will represent as follows: 
-- The standard rent 
-- The rent when the group is owned
-- The rent with one house
-- The rent with two houses
-- The rent with three houses 
-- The rent with four houses 
-- The rent with a hotel

- #### costOfHouse: Int

This integer represents the cost to put a house on this property.

- #### sellPrice: Int
The price this property is worth, given all houses/hotels. 

- #### amountOfHouses: Int
The amount of houses on the property.

### Public Methods 
- #### getRent(): [Int]
*Parameters*: None
*Returns*: Array of prices the rent may be

This returns an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'. 

- #### setRent([Int]): Void
*Parameters*: Array of prices for the rent
*Returns*: Void

This sets an array of prices, the slot chosen depends on the current ownership status as seen for the private attribute 'rent'.

- #### getCostOfHouse(): Int
*Parameters*: None
*Returns*: The price to put a house on the property

This method gets the cost to put a house on this property.

- #### setCostOfHouse(Int): Void
*Parameters*: Price for a house on this property 
*Returns*: Void

This method allows the price to buy a house on this property to be set. 

- #### getSellPrice(): Int
*Parameters*: None
*Returns*: The price this property is worth

Gives the integer value that this property is worth given all houses/ hotels on the property.

- #### setSellPrice(Int): Void
*Parameters*: The new sell price of this property
*Returns*: Void

Set a new value for selling this property.

- #### addHouses(): Void
*Parameters*: None
*Returns*: Void

Add a house to the property.

- #### removeHouses(Int): Void
*Parameters*: Amount of houses to remove
*Returns*: Void

Remove houses from the property.

--- 