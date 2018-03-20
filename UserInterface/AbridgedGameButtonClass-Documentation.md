# User Interface documentation
---
## AbridgedGameButton Class

The abridged game button contains the information required for the button in the menu, also containing the textbox allowing for the time length to be entered. 

### Private Attributes 
- #### titleLabel: Label
This is the title of the button: "Abridged Game".
- #### descriptionLabel: Label
This is a breif description of what the button does.
- #### timeLimitLabel: Label
This is a label saying "Time Limit: ".
- #### timeUnitLabel: Label
This follows a text field after the time limit label saying "Mins".
- #### timeTextField: TextField
This goed between the time limit and units, allowing the user to set the time limit. 

### Public Methods 
- #### AbridgedGameButton()
*Parameters*: None
*Returns*: Void

This initilaises the button with a blank text field for the player to enter a numerical value into. 

---