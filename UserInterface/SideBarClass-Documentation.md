# User Interface documentation
---

## Sidebar Class

The sidebar class is used to setup the sidebar of the standard in game screen. 

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### settingsButton: Button
A button leading to the in game settings screen.
- #### players: [SidebarRow]
An array of sidebarRows showing the players, their money, etc.  
- #### primaryPlayer: SidebarPrimaryPlayer
The player whos turn it is and their money, etc. 

### Public Methods 
- #### Sidebar(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise this scene with the data from the game engine.

---