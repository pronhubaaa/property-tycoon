import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Dictionary;


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
    private ArrayList<PropertyGroup> propertyGroups;

    /**
     * stationGroups: [StationGroup]
     * The train station tiles shown on the board.
     */
    private ArrayList<StationGroup> stationGroups;

    /**
     * UtilityGroups: [UtilityGroup]
     * The utility tiles shown on the board.
     */
    private ArrayList<UtilityGroup> utilityGroups;

    /**
     * cards: [Card]
     * The "Opportunity Knocks" and "Pot Luck" cards on the board.
     */
    private ArrayList<Card> cards;

    /**
     * Board
     * @param jsonObject
     * The JSON data will come from the GameEngine, this includes all tiles, property groups, station groups, utility groups and cards. This constructor initialises the board.
     */
    public Board(JSONObject jsonObject){
        if(jsonObject.containsKey("tile")){

            JSONArray tiles = jsonObject.getJSONArray("tile");

            for(Object object: tiles){
                JSONObject tile = (JSONObject) object;

                if(tile.containsKey("type")){
                    TileType type = TileType.valueOf(tile.getString("type"));
                    String tileName = tile.getString("name");
                    int tilePosition = tile.getIntValue("position");
                    int tileValue = tile.getIntValue("value");



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

                            break;
                        case Station:
                            break;
                        case Property:
                            Property property = new Property(tileName, tilePosition);
                            this.tiles.add(property);
                            break;
                        case Jail:
                            Jail jail = new Jail(tileName, tilePosition);
                            this.tiles.add(jail);
                            break;
                        case GoToJail:
                            GoToJail goToJail = new GoToJail(tileName, tilePosition);
                            this.tiles.add(goToJail);
                            break;

                        default:
                            break;

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
     * reorderCards
     * @param cardType The card being shuffled into the pack
     * This allows the game to add the card to the end of a stack.
     */
    public void reorderCards(CardType cardType){

    }

    public int getPlayerOwned(Tile){
        int mostTilesOwned = 0;

        // This method is to see what other tiles in a set are owned. It is given a tile, then it must return the amount of tiles owned by the player that owns the most
        // This could be 1 if two players own one, 2 if a player owns 2 etc.
        return mostTilesOwned;

    }

    public int groupSize(Tile){
        return 1;
    }

    public boolean isStreetOwned(Tile){
        return true;
    }


    /**
     * addTile
     * @param tile The tile being added to the board
     * This allows the game board to be initialised, tiles can be added in this way.
     */
    private void addTile(Tile tile){

    }

    /**
     * randomiseCards
     * @param cardType The card type e.g. 'opportunity knocks' or 'pot luck'
     * This method randomises the opportunity knocks and pot luck cards at the start of a game.
     */
    private void randomiseCards(CardType cardType){

    }
}
