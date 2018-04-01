# Game Engine documentation
---

## Group Class

The group class contains all methods and functions required by the different groups on the board, this being properties, utilities and stations. 

### Private Attributes 

- #### groups: [Group]

This array of groups are all properties on the board that are assigned a group. 

#### Public Methods 

- #### getGroups(): [Group]
*Parameters*: None
*Returns*: An array of property groups 

This method gets all groups of properties on the game board.

- #### setGroups([Group]): Void
*Parameters*: An array of property groups
*Returns*: Void

This method sets all groups of properties on the game board for initialisation.

- #### add(Group): Void
*Parameters*: A group
*Returns*: Void

This method adds a group of properties on the game board for initialisation.