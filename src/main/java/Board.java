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
    private HashMap<String, Group> groups;

    private HashMap<CardType, CardStack> cardStacks;


    /**
     * Board
     *
     * @param jsonObject The JSON data will come from the GameEngine, this includes all tiles, property groups, station groups, utility groups and cards. This constructor initialises the board.
     */
    public Board(JSONObject jsonObject) throws BoardTileException {
        this.groups = new HashMap<>();
        this.tiles = new ArrayList<>();


        if (jsonObject.containsKey(BoardJsonField.Tiles.toString())) {

            JSONArray tiles = jsonObject.getJSONArray(BoardJsonField.Tiles.toString());

            for (Object object : tiles) {
                if (this.tiles.size() > 40) {
                    throw new BoardTileException("More than 40 tiles");
                }
                JSONObject tile = (JSONObject) object;

                if (tile.containsKey(BoardJsonField.Type.toString())) {
                    TileType type = TileType.valueOf(tile.getString(BoardJsonField.Type.toString()));
                    String tileName = tile.getString(BoardJsonField.Name.toString());
                    int tilePosition = tile.getIntValue(BoardJsonField.Position.toString());
                    int tileValue = tile.getIntValue(BoardJsonField.Value.toString());
                    String groupType = tile.getString(BoardJsonField.Group.toString());


                    switch (type) {
                        case Go:
                            Go go = new Go(tileName, tilePosition, tileValue);
                            int value = tile.getIntValue(BoardJsonField.Value.toString());
                            go.setValue(value);
                            this.tiles.add(go);
                            break;
                        case FreeParking:
                            FreeParking freeParking = new FreeParking(tileName, tilePosition);
                            this.tiles.add(freeParking);
                            break;
                        case Utility:
                        case Station:
                            Group facilityGroup;
                            if (groups.containsKey(groupType)) {
                                facilityGroup = groups.get(groupType);
                            } else {
                                facilityGroup = new Group();
                            }
                            Facility facility;
                            if (type == TileType.Utility) {
                                facility = new Utility(tileName, tilePosition, facilityGroup);
                            } else { // (TileType.Station)
                                facility = new Station(tileName, tilePosition, facilityGroup);
                            }
                            int cost = tile.getIntValue(BoardJsonField.Cost.toString());
                            facility.setPrice(cost);

                            if (!groups.containsKey(groupType)) {
                                facilityGroup.add(facility);
                                groups.put(groupType, facilityGroup);
                            }
                            this.tiles.add(facility);
                            break;

                        case Property:
                            Group propertyGroup;
                            if (groups.containsKey(groupType)) {
                                propertyGroup = groups.get(groupType);
                            } else {
                                propertyGroup = new Group();
                            }
                            Property property = new Property(tileName, tilePosition, propertyGroup);
                            
                            JSONArray rents = tile.getJSONArray(BoardJsonField.Rent.toString());
                            ArrayList<Integer> rent = new ArrayList<>();
                            for (int i = 0; i < rents.size(); i++) {
                                rent.add(rents.getIntValue(i));
                            }
                            property.setRent(rent);
                            property.setCostOfHouse(tile.getIntValue(BoardJsonField.HouseCost.toString()));
                            property.setPrice(tile.getIntValue(BoardJsonField.Cost.toString()));

                            if (!groups.containsKey(groupType)) {
                                propertyGroup.add(property);
                                this.groups.put(groupType, propertyGroup);
                            }
                            this.tiles.add(property);
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
                            int amount = tile.getIntValue(BoardJsonField.Value.toString());
                            taxTile.setAmount(amount);
                            this.tiles.add(taxTile);
                            break;
                        case Card:
                            CardType cardType = CardType.valueOf(tile.getString(BoardJsonField.CardType.toString()));
                            CardStack cardStack = new CardStack(cardType);
                            CardTile cardTile = new CardTile(tileName, tilePosition, cardStack);
                            this.tiles.add(cardTile);
                            break;
                        default:
                            throw new BoardTileException("Tile type is invalid");

                    }

                }
            }


        }


    }

    /**
     * getTiles
     *
     * @return An array of tiles
     * This method will get all tiles on the board.
     */
    public ArrayList<Tile> getTiles() {
        return this.tiles;
    }


    /**
     * addTile
     *
     * @param tile The tile being added to the board
     *             This allows the game board to be initialised, tiles can be added in this way.
     */
    public void addTile(Tile tile) {
        this.tiles.add(tile);

    }

    public Tile getTile(String name) {
        for (Tile tile : tiles) {
            if (tile.getName().toLowerCase().equals(name.toLowerCase())) {
                return tile;
            }
        }
        return null;
    }

    /**
     * This method is to see what other tiles in a set are owned. It is given a tile, then it must return the amount of tiles owned by the player that owns the most
     * This could be 1 if two players own one, 2 if a player owns 2 etc.
     *
     * @param ownable
     * @return mostTilesOwned
     */
    public int getPlayerOwned(Ownable ownable) {
        int mostTilesOwned = 0;
        for (Tile tile : getTiles()) {
            if (tile instanceof Ownable) {
                if (ownable.getOwner() != null) {
                    if (ownable.getOwner().equals(((Ownable) tile).getOwner())) {
                        mostTilesOwned++;
                    }
                }
            }
        }
        return mostTilesOwned;

    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public HashMap<CardType, CardStack> getCardStacks() {
        return cardStacks;
    }

    public void setCardStacks(HashMap<CardType, CardStack> cardStacks) {
        this.cardStacks = cardStacks;
    }

    public void addToCardStack(Card card, CardType cardType) {
        this.cardStacks.get(cardType).add(card);
    }
}
