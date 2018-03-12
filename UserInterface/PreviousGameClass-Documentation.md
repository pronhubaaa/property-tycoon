# User Interface documentation
---

## PreviousGame Class

### Private Attributes 

- #### playerLabel: Label
Label to say 'Player: '.
- #### lastPlayedLabel: Label
Label to say 'Last Played: '.
- #### gameCreatedLabel: Label
Label to say 'Game Created: '.
- #### turnLabel: Label
Label to say 'Turn: '.
- #### playerLabelData: Label
The players names, stored in JSON data.
- #### lastPlayedLabelData: Label
The last time the game was played, stored in JSON data.
- #### gameCreatedLabelData: Label
The date the game was created, stored in JSON data.
- #### turnLabelData: Label
Which players turn it is in this game, stored in JSON data.
- #### loadButton: Button
This button will load in this version of the game.

### Public Methods 
- #### PreviousGame(JsonObject)
*Parameters*: JSON data from previous game.
*Returns*: Void

This method will initilaise data from the previous game. 

---