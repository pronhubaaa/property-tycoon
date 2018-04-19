import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Dictionary;
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
        CardType("cardType");

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
                            Utility utility = new Utility(tileName, tilePosition);
                            this.tiles.add(utility);
                            if(groupType != "") {
                                if (this.utilityGroups.containsKey(groupType)) {
                                    this.utilityGroups.get(groupType).add(utility);
                                } else {
                                    UtilityGroup utilityGroup = new UtilityGroup();
                                    utilityGroup.add(utility);
                                    this.utilityGroups.put(groupType, utilityGroup);
                                }
                            }

                            break;
                        case Station:
                            Station station = new Station(tileName, tilePosition);
                            this.tiles.add(station);
                            if(groupType != "") {
                                if (this.stationGroups.containsKey(groupType)) {
                                    this.stationGroups.get(groupType).add(station);
                                } else {
                                    StationGroup stationGroup = new StationGroup();
                                    stationGroup.add(station);
                                    this.stationGroups.put(groupType, stationGroup);
                                }
                            }
                            break;
                        case Property:
                            Property property = new Property(tileName, tilePosition);
                            this.tiles.add(property);
                            if(groupType != ""){
                                if(this.propertyGroups.containsKey(groupType)){
                                    this.propertyGroups.get(groupType).add(property);
                                } else {
                                    PropertyGroup propertyGroup = new PropertyGroup();
                                    propertyGroup.add(property);
                                    this.propertyGroups.put(groupType, propertyGroup);
                                }
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
                            Tax tax = new Tax(tileName, tilePosition, tileValue);
                            this.tiles.add(tax);
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

                if(tile.containsKey("ownable")){
                    boolean ownable = tile.getBooleanValue("ownable");
                    System.out.println(ownable);

                }

                if(tile.containsKey("property_group")){
                    String group = tile.getString("property_group");
                    System.out.println(group);

                }

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
