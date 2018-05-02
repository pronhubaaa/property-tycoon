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
                            Group utilityGroup = groups.containsKey(groupType) ? groups.get(groupType) : new Group();
                            Utility utility = new Utility(tileName, tilePosition, utilityGroup) {{
                                setPrice(tile.getIntValue(BoardJsonField.Cost.toString()));
                            }};
                            if (!groups.containsKey(groupType)) {
                                addNewGroup(utilityGroup, groupType, utility);
                            }
                            this.tiles.add(utility);
                        case Station:
                            Group stationGroup = groups.containsKey(groupType) ? groups.get(groupType) : new Group();
                            Station station = new Station(tileName, tilePosition, stationGroup) {{
                                setPrice(tile.getIntValue(BoardJsonField.Cost.toString()));
                                setRent(parseJsonRents(tile.getJSONArray(BoardJsonField.Rent.toString())));
                            }};
                            if (!groups.containsKey(groupType)) {
                                addNewGroup(stationGroup, groupType, station);
                            }
                            this.tiles.add(station);
                            break;
                        case Property:
                            Group propertyGroup = groups.containsKey(groupType) ? groups.get(groupType) : new Group();
                            Property property = new Property(tileName, tilePosition, propertyGroup) {{
                                setPrice(tile.getIntValue(BoardJsonField.Cost.toString()));
                                setRent(parseJsonRents(tile.getJSONArray(BoardJsonField.Rent.toString())));
                                setCostOfHouse(tile.getIntValue(BoardJsonField.HouseCost.toString()));
                            }};
                            propertyGroup.setColour(Colour.valueOf(groupType));
                            if (!groups.containsKey(groupType)) {
                                addNewGroup(propertyGroup, groupType, property);
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

    private static ArrayList<Integer> parseJsonRents(JSONArray jsonRents) {
        ArrayList<Integer> parsedRents = new ArrayList<>();
        jsonRents.iterator().forEachRemaining(s -> parsedRents.add((int) s));
        return parsedRents;
    }

    private void addNewGroup(Group group, String groupType, Ownable ownable) {
        group.add(ownable);
        groups.put(groupType, group);
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
