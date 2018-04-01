# Game Engine documentation
---
## Dice Class

The dice class is for when dice are rolled and counting doubles

### Private Attributes

- #### doubleCount: Int

This integer value counts the amount of doubles a player rolls in a row.

### Public Methods

- #### roll(): [Int]
*Parameters*: None 
*Returns*: An array of integers 

This method returns the two values between 1 and 6 shown on the two dice. The function will also add to doubleCount where appropriate.

- #### getDoubleCount(): Int
*Parameters*: None
*Returns*: Number of times a double has rolled

This method returns the number of times a double has been rolled.

---