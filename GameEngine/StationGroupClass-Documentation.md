# Game Engine documentation
---

## StationGroup Class

### Private Attributes 
- #### stations: [Station]

All station tiles on the game board.

### Public Methods 
- #### getStations(): [Station]
*Parameters*: None 
*Returns*: An array of stations 

This method returns all of the stations on the board.

- #### setStation([Station]): Void
*Parameters*: An array of stations 
*Returns*: Void

This initialises the stations on the game board.


- #### checkOwnedStations(Player): Int
*Parameters*: A Player
*Returns*: Amount of stations that player owns

This method returns all of the stations that a player owns.

---