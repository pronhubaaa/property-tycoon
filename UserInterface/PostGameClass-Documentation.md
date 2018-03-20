# User Interface documentation
---

## PostGame Class

The post game class will allow statistics about the game to be shown to the players. 

### Private Attributes 
- #### returnButton: Button
The return button allows a player to go back to the main screen.

- #### players: [PostGameRow]
This is an array of all players and how they did in the game.

### Public Methods 
- #### PostGame(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

This will initialise the results page.

### Private Methods
- #### returnToMainMenu(): Void
*Parameters*: None
*Returns*: Void

This will return the player to the home screen.

---