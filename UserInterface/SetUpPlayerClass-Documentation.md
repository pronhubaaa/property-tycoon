# User Interface documentation
---
## SetUpPlayer Class

### Private Attributes 
- #### name: TextField
The name of the player being added.

- #### playerType: ToggleSwitch
The type of player being added, AI or human. 

- #### pieces: [Button]
The players choosen piece: hatstand, cat, etc. 

- #### labels: [Label]
All labels used on this screen.

### Public Methods 
- #### SetUpPlayer()
*Parameters*: None
*Returns*: Void

This will allow players to be added to the game engine.

### Private Methods
- #### constructName(): Void
*Parameters*: None
*Returns*: Void

This will display a box asking the user to enter the player name.

- #### constructPlayerTypeToggle(): Void
*Parameters*: None
*Returns*: Void

This will create the toggle switch between AI and Human.

- #### constructPieces(): Void
*Parameters*: None
*Returns*: Void

This will display the pieces that a player could possibly be. 

- #### constructLabels(): Void
*Parameters*: None
*Returns*: Void

This will build the titles for this scene.

---