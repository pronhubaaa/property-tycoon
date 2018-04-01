# Init game

## Optional Values
- property_group
- action
- cost
- rent
- houses


```JSON
{
	"tile":
	[
		{
			"position": "1",
			"name": "Go",
			"ownable": "true",
			"property_group": "green",
			"action": {
				"action": "receive",
				"value": "200"
			},
			"cost": "200",
			"rent": "20",
			"houses": ["10", "30", "90", "120", "200"]

		}
	]

}
```

# Saved game

## Optional Values
- property_group
- action
- cost
- rent
- houses
- remaining_time

```JSON
{
	"tile":
	[
		{
			"position": "1",
			"name": "Go",
			"ownable": "true",
			"property_group": "green", 
			"action": {
				"action": "receive",
				"value": "200"
			},
			"cost": "200",
			"rent": "20",
			"houses": [
				"10", 
				"30", 
				"90", 
				"120", 
				"200"
			]
		}
	],
	"player": [
		{
			"in_jail": "false",
			"balance": "2200",
			"name": "Peter",
			"position": "7",
			"owned_tiles": [
				"8", 
				"12", 
				"17"
			], 
			"piece": "2"
		}
	],
	"game_type": "full",
	"remaining_time": "30",
	"current_player": "4",
	"number_of_turns": "52"

}
```