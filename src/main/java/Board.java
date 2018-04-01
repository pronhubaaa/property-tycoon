import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;


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
