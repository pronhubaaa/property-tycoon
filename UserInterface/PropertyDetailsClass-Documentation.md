# User Interface documentation
---
## PropertyDetails Class

### Private Attributes 
- #### gameEngine: GameEngine
The current game engine.
- #### nameLabel: Label
The name of the property.
- #### colour: Scene
The colour set of the current property, represented as a scene. 
- #### priceLabel: Label
The standard price of the property.
- #### priceAmountLabel: Label
The actual amount of the property.
- #### rentLabel: Label
The standard rent for this property.
- #### rentRow: [PropertyDetailsHouseRow]
The rent given houses.
- #### bottomBar: Scene
The colour of the base of the property.

### Public Methods 
- #### PropertyDetails(GameEngine)
*Parameters*: The current game engine 
*Returns*: Void

Initialise a property details scene.

---