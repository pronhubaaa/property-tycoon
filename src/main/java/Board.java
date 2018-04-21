import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * The board class controls all tiles on the board, initialising them, keeping track of player locations property sales, etc.
 */
public class Board {

    /**
     * tiles: [Tile]
     * All tiles that appear on the board.
     */
    private ArrayList<Tile> tiles;

    /**
     * propertyGroups: [PropertyGroup]
     * The groups of properties as shown by their colour groups on the board.
     */
    private HashMap<String, PropertyGroup> propertyGroups;

    /**
     * stationGroups: [StationGroup]
     * The train station tiles shown on the board.
     */
    private HashMap<String, StationGroup> stationGroups;

    /**
     * UtilityGroups: [UtilityGroup]
     * The utility tiles shown on the board.
     */
    private HashMap<String, UtilityGroup> utilityGroups;

    /**
     * cards: [Card]
     * The "Opportunity Knocks" and "Pot Luck" cards on the board.
     */
    private ArrayList<Card> cards;

    /**
     * jsonFields
     */
    private enum jsonFields{
        Tile("tile"),
        Type("type"),
        Name("name"),
        Position("position"),
        Value("value"),
        Group("group"),
        CardType("cardType"),
        Rent("rent"),
        Cost("cost"),
        HouseCost("house");


        private String value;

        jsonFields(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }


    /**
     * Board
     * @param jsonObject
     * The JSON data will come from the GameEngine, this includes all tiles, property groups, station groups, utility groups and cards. This constructor initialises the board.
     */
    public Board(JSONObject jsonObject) throws BoardTileException {
        this.propertyGroups = new HashMap<>();
        this.stationGroups = new HashMap<>();
        this.utilityGroups = new HashMap<>();
        this.tiles = new ArrayList<>();


        if(jsonObject.containsKey(jsonFields.Tile.toString())){

            JSONArray tiles = jsonObject.getJSONArray(jsonFields.Tile.toString());

            for(Object object: tiles){
                if(this.tiles.size() > 40){
                    throw new BoardTileException("More than 40 tiles");
                }
                JSONObject tile = (JSONObject) object;

                if(tile.containsKey(jsonFields.Type.toString())){
                    TileType type = TileType.valueOf(tile.getString(jsonFields.Type.toString()));
                    String tileName = tile.getString(jsonFields.Name.toString());
                    int tilePosition = tile.getIntValue(jsonFields.Position.toString());
                    int tileValue = tile.getIntValue(jsonFields.Value.toString());
                    String groupType = tile.getString(jsonFields.Group.toString());


                    switch(type) {
                        case Go:
                            Go go = new Go(tileName, tilePosition, tileValue);
                            this.tiles.add(go);
                            break;
                        case FreeParking:
                            FreeParking freeParking = new FreeParking(tileName, tilePosition);
                            this.tiles.add(freeParking);
                            break;
                        case Utility:
                            if (this.utilityGroups.containsKey(groupType)) {
                                Utility utility = new Utility(tileName, tilePosition, this.utilityGroups.get(groupType));
                                this.tiles.add(utility);
                             } else {
                                UtilityGroup utilityGroup = new UtilityGroup();
                                Utility utility = new Utility(tileName, tilePosition, utilityGroup);
                                utilityGroup.add(utility);
                                this.utilityGroups.put(groupType, utilityGroup);
                                this.tiles.add(utility);
                            }




                            break;
                        case Station:

                            if (this.stationGroups.containsKey(groupType)) {
                                Station station = new Station(tileName, tilePosition, this.stationGroups.get(groupType));
                                this.tiles.add(station);
                            } else {
                                StationGroup stationGroup = new StationGroup();
                                Station station = new Station(tileName, tilePosition, stationGroup);
                                stationGroup.add(station);
                                this.stationGroups.put(groupType, stationGroup);
                                this.tiles.add(station);
                            }

                            break;
                        case Property:

                            if (this.propertyGroups.containsKey(groupType)) {
                                Property property = new Property(tileName, tilePosition, this.propertyGroups.get(groupType));
                                JSONArray rents = tile.getJSONArray(jsonFields.Rent.toString());

                                ArrayList<Integer> rent = new ArrayList<>();
                                for(int i = 0; i < rents.size(); i++){
                                    rent.add(rents.getIntValue(i));
                                }
                                property.setRent(rent);
                                int houseCost = tile.getIntValue(jsonFields.HouseCost.toString());
                                property.setCostOfHouse(houseCost);

                                int propertyCost = tile.getIntValue(jsonFields.Cost.toString());
                                property.setPrice(propertyCost);

//                                property.setSellPrice();
//                                property.setMortgagePrice();

                                this.tiles.add(property);
                            } else {
                                PropertyGroup propertyGroup = new PropertyGroup();
                                Property property = new Property(tileName, tilePosition, propertyGroup);
                                propertyGroup.add(property);
                                this.propertyGroups.put(groupType, propertyGroup);
                                this.tiles.add(property);
                            }


                            break;
                        case Jail:
                            Jail jail = new Jail(tileName, tilePosition, tileValue);
                            this.tiles.add(jail);
                            break;
                        case GoToJail:
                            GoToJail goToJail = new GoToJail(tileName, tilePosition);
                            this.tiles.add(goToJail);
                            break;
                        case Tax:
                            TaxTile taxTile = new TaxTile(tileName, tilePosition, tileValue);
                            this.tiles.add(taxTile);
                            break;
                        case Card:
                            CardType cardType = CardType.valueOf(tile.getString(jsonFields.CardType.toString()));
                            Card card = new Card(tileName, tilePosition, cardType);
                            this.tiles.add(card);
                            break;
                        default:
                            throw new BoardTileException("Tile type is invalid");

                    }

                }




/*

                if(tile.containsKey("action")){
                    JSONObject actionObject = tile.getJSONObject("action");

                    String action = actionObject.getString("action");
                    int value =  actionObject.getIntValue("value");
                }

                if(tile.containsKey("cost")){
                    int cost = tile.getIntValue("cost");
                    System.out.println(cost);

                }

                if(tile.containsKey("rent")){
                    int rent = tile.getIntValue("rent");
                    System.out.println(rent);

                }

                if(tile.containsKey("houses")){
                    for(Object price: tile.getJSONArray("houses")){
                        System.out.println(price);
                    }

                }*/
            }


        }


    }

    /**
     * getTiles
     * @return An array of tiles
     * This method will get all tiles on the board.
     */
    public ArrayList<Tile> getTiles(){
        return this.tiles;
    }


    /**
     * addTile
     * @param tile The tile being added to the board
     * This allows the game board to be initialised, tiles can be added in this way.
     */
    public void addTile(Tile tile){
        this.tiles.add(tile);

    }


    /**
     * getPropertyGroups
     * @return propertyGroups
     */
    public HashMap<String, PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    /**
     * setPropertyGroups
     * @param propertyGroups
     */
    public void setPropertyGroups(HashMap<String, PropertyGroup> propertyGroups) {
        this.propertyGroups = propertyGroups;
    }

    /**
     * getStationGroups
     * @return stationGroups
     */
    public HashMap<String, StationGroup> getStationGroups() {
        return this.stationGroups;
    }

    /**
     * setStationGroups
     * @param stationGroups
     */
    public void setStationGroups(HashMap<String, StationGroup> stationGroups) {
        this.stationGroups = stationGroups;
    }

    /**
     * getUtilityGroups
     * @return utilityGroups
     */
    public HashMap<String, UtilityGroup> getUtilityGroups() {
        return this.utilityGroups;
    }

    /**
     * setUtilityGroups
     * @param utilityGroups
     */
    public void setUtilityGroups(HashMap<String, UtilityGroup> utilityGroups) {
        this.utilityGroups = utilityGroups;
    }

}
