# User Interface documentation
---

## MainView Class

The main view class is responsible for selecting the primary view of the game, which is the gameBoard with sidebar. 

### Private Attributes 
- #### gameEngine: GameEngine
The game engine for this game.
- #### inGameSettings: Scene
The in game settings, given from subclass as a scene to be displayed.
- #### sidebar: Scene
The sidebar for this game, given from subclass as a scene to be displayed.
- #### gameBoard: Scene
The game board with set tile layout, given from subclass as a scene to be displayed.
### Public Methods 
- #### MainView(GameEngine)
*Parameters*: The data from the game engine 
*Returns*: Void

This allows the game screen to be dispalyed.

---