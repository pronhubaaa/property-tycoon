# User Interface documentation
---

## LoadBoard Class

### Private Attributes 
- #### gameEngine: GameEngine
The game engine, all data for the current game.

### Public Methods 
- #### LoadBoard(GameEngine)
*Parameters*: A GameEngine
*Returns*: Void

This will load a laederboard screen for best games/players. 

### Private Methods
- #### saveBoard(JsonObject): Void
*Parameters*: A set of JSON data
*Returns*: Void

This will get the data for this screen from previous save files. 

---