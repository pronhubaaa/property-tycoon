# User Interface documentation
---
## DiceRoll Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### titleLabel: Label
Label saying "Current roll!".
- #### rollButton: Button
A roll dice button.
- #### highestRollLabel: Label
A label for stating the highest roll for the start of game activity.
- #### actionLabel: Label
A label for after dice roll. 
### Public Methods 
- #### DiceRoll(GameEngine)
*Parameters*: Current game engine 
*Returns*: Void

Initialise the scene.

### Private Methods
- #### roll(): Void
*Parameters*: None
*Returns*: Void

Roll the two dice.

- #### updateView(): Void
*Parameters*: None
*Returns*: Void

Update the board view given the changes. 

---