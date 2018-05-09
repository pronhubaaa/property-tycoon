# Init game

## Example Game Board

```JSON
{
	"tile":
	[
		{
			"type": "Go",
			"position": "1",
			"name": "Go",
			"ownable": "false",
			"action": {
				"action": "collect",
				"value": "200"
			}
		},
		{
			"type": "Property",
			"position": "2",
			"name": "Crapper Street",
			"property_group": "Brown",
			"ownable": "true",
			"cost": "60",
			"rent": "2",
			"houses": ["10", "30", "90", "160", "250"]
		},
		{
			"type": "PlotLuck",
			"position" : "3",
			"name": "Plot Luck",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "4",
			"name": "Gangsters Paradise",
			"property_group": "Brown",
			"ownable": "true",
			"cost": "60",
			"rent": "4",
			"houses": ["20", "60", "180", "320", "450"]
		},
		{
			"type": "IncomeTax",
			"position": "5",
			"name": "Income Tax"
		},
		{
			"type": "Station",
			"position": "6",
			"name": "Brighton Station",
			"ownable": "true",
			"cost": "200",
			"rent": ["25","50","100","200"]
		},
		{
			"type": "Property",
			"position": "7",
			"name": "Weeping Angel",
			"property_group": "Blue",
			"ownable": "true",
			"cost": "100",
			"rent": "6",
			"houses": ["30", "90", "270", "400", "550"]
		},
		{
			"type": "OpportunityKnocks",
			"position" : "8",
			"name": "Opportunity Knocks",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "9",
			"name": "Potts Avenue",
			"property_group": "Blue",
			"ownable": "true",
			"cost": "100",
			"rent": "6",
			"houses": ["30", "90", "270", "400", "550"]
		},
		{
			"type": "Property",
			"position": "10",
			"name": "Nardole Drive",
			"property_group": "Blue",
			"ownable": "true",
			"cost": "120",
			"rent": "8",
			"houses": ["40", "100", "300", "450", "600"]
		},
		{
			"type": "Jail",
			"position": "11",
			"name": "Jail / Just visiting",
			"ownable": "false",
			"fee": "120"
		},
		{
			"type": "Property",
			"position": "12",
			"name": "Skywalker Drive",
			"property_group": "Purple",
			"ownable": "true",
			"cost": "140",
			"rent": "10",
			"houses": ["50", "150", "450", "625", "750"]
		},
		{
			"type": "Utility",
			"position": "13",
			"name": "Tesla Power Co",
			"ownable": "true",
			"cost": "150"
		},
		{
			"type": "Property",
			"position": "14",
			"name": "Wookie Hole",
			"property_group": "Purple",
			"ownable": "true",
			"cost": "140",
			"rent": "10",
			"houses": ["50", "150", "450", "625", "750"]
		},
		{
			"type": "Property",
			"position": "15",
			"name": "Rey Lane",
			"property_group": "Purple",
			"ownable": "true",
			"cost": "160",
			"rent": "12",
			"houses": ["60", "180", "500", "700", "900"]
		},
		{
			"type": "Station",
			"position": "16",
			"name": "Hove Station",
			"ownable": "true",
			"cost": "200",
			"rent": ["25","50","100","200"]
		},
		{
			"type": "Property",
			"position": "17",
			"name": "Cooper Drive",
			"property_group": "Orange",
			"ownable": "true",
			"cost": "180",
			"rent": "14",
			"houses": ["70", "200", "550", "750", "950"]
		},
		{
			"type": "PlotLuck",
			"position" : "18",
			"name": "Plot Luck",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "19",
			"name": "Wolowitz Street",
			"property_group": "Orange",
			"ownable": "true",
			"cost": "180",
			"rent": "14",
			"houses": ["70", "200", "550", "750", "950"]
		},
		{
			"type": "Property",
			"position": "20",
			"name": "Penny Lane",
			"property_group": "Orange",
			"ownable": "true",
			"cost": "200",
			"rent": "16",
			"houses": ["80", "220", "600", "800", "1000"]
		},
		{
			"type": "FreeParking",
			"position": "21",
			"name": "Free Parking",
			"ownable": "false"
		},
		{
			"type": "Property",
			"position": "22",
			"name": "Yue Fei Square",
			"property_group": "Red",
			"ownable": "true",
			"cost": "220",
			"rent": "18",
			"houses": ["90", "250", "700", "875", "1050"]
		},
		{
			"type": "OpportunityKnocks",
			"position" : "23",
			"name": "Opportunity Knocks",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "24",
			"name": "Mulan Rouge",
			"property_group": "Red",
			"ownable": "true",
			"cost": "220",
			"rent": "18",
			"houses": ["90", "250", "700", "875", "1050"]
		},
		{
			"type": "Property",
			"position": "25",
			"name": "Han Xin Gardens",
			"property_group": "Red",
			"ownable": "true",
			"cost": "240",
			"rent": "20",
			"houses": ["100", "300", "750", "925", "1100"]
		},
		{
			"type": "Station",
			"position": "26",
			"name": "Falmer Station",
			"ownable": "true",
			"cost": "200",
			"rent": ["25","50","100","200"]
		},
		{
			"type": "Property",
			"position": "27",
			"name": "Kirk Close",
			"property_group": "Yellow",
			"ownable": "true",
			"cost": "260",
			"rent": "22",
			"houses": ["110", "330", "800", "975", "1150"]
		},
		{
			"type": "Property",
			"position": "28",
			"name": "Picard Avenue",
			"property_group": "Yellow",
			"ownable": "true",
			"cost": "260",
			"rent": "22",
			"houses": ["110", "330", "800", "975", "1150"]
		},
		{
			"type": "Utility",
			"position": "29",
			"name": "Edison Water",
			"ownable": "true",
			"cost": "150"
		},
		{
			"type": "Property",
			"position": "30",
			"name": "Crusher Creek",
			"property_group": "Yellow",
			"ownable": "true",
			"cost": "280",
			"rent": "22",
			"houses": ["120", "360", "850", "1025", "1200"]
		},
		{
			"type": "GoToJail",
			"position": "31",
			"name": "Go to Jail",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "32",
			"name": "Sirat Mews",
			"property_group": "Green",
			"ownable": "true",
			"cost": "300",
			"rent": "26",
			"houses": ["130", "390", "900", "1100", "1275"]
		},
		{
			"type": "Property",
			"position": "33",
			"name": "Ghengis Crescent",
			"property_group": "Green",
			"ownable": "true",
			"cost": "300",
			"rent": "26",
			"houses": ["130", "390", "900", "1100", "1275"]
		},
		{
			"type": "PlotLuck",
			"position" : "34",
			"name": "Plot Luck",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "35",
			"name": "Ibis Close",
			"property_group": "Green",
			"ownable": "true",
			"cost": "320",
			"rent": "28",
			"houses": ["150", "450", "1000", "1200", "1400"]
		},
		{
			"type": "Station",
			"position": "36",
			"name": "Lewes Station",
			"ownable": "true",
			"cost": "200",
			"rent": ["25","50","100","200"]
		},
		{
			"type": "OpportunityKnocks",
			"position" : "37",
			"name": "Opportunity Knocks",
			"ownable": "false",
		},
		{
			"type": "Property",
			"position": "38",
			"name": "Hawking Way",
			"property_group": "Deep Blue",
			"ownable": "true",
			"cost": "350",
			"rent": "35",
			"houses": ["175", "500", "1100", "1300", "1500"]
		},
		{
			"type": "SuperTax",
			"position" : "39",
			"name": "Super Tax",
			"ownable": "false",
			"action": {
				"action": "pay",
				"value": "100"
			}
		},
		{
			"type": "Property",
			"position": "40",
			"name": "Turning Heights",
			"property_group": "Deep Blue",
			"ownable": "true",
			"cost": "400",
			"rent": "50",
			"houses": ["200", "600", "1400", "1700", "2000"]
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
		    "type": "Go",
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