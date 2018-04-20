

import java.util.ArrayList;

/**
 * The player class is responsible for storing a players assets and storing methods for how players can perform actions
 */
public class Player {

    /**
     * inJail: Boolean
     * This represents if the player is in jail or not.
     */
    private boolean inJail;

    /**
     * balance: Int
     * This is the players avaliable money.
     */
    private int balance;

    /**
     * name: String
     * This is the name of the player.
     */
    private String name;

    /**
     * position: Tile
     * The players current position on the board, represented by a tile object which is the location on the board.
     */
    private Tile position;

    /**
     * ownedTiles: [Ownable]
     * This is an array of all the 'ownable' tiles that the player owns. 'Ownable' is an array of all tiles that is is possible for a player to posses.
     */
    private ArrayList<Ownable> ownedTiles;

    /**
     * piece: PlayerPiece
     * This is the object that the player is displayed as in the GUI.
     */
    private PlayerPiece piece;


    /**
     * board: Board
     * This is the board object.
     */
    private Board board;

    /**
     * Player
     *
     * @param balance Int for the player balance
     * @param name String for the players name
     * This is the initialiser for the object, it initialises the name and balance.
     */
    public Player(int balance, String name, Board board) {
        this.board = board;
        setBalance(balance);
        setName(name);
        setInJail(false);

    }

    /**
     * buyTile
     *
     * @param tile The tile the player wishes to buy
     * @return Boolean- true if purchase successful
     * This allows a player to purchase a tile on the board.
     */
    public boolean buyTile(Tile tile) {
        if(tile instanceof Ownable){
            Ownable ownable = (Ownable) tile;
            if(!ownable.isOwned()){
                if(this.balance >= ownable.getPrice()){
                    ownable.setOwner(this);
                    setBalance(getBalance() - ownable.getPrice());
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * sellTile
     *
     * @param tile The tile the player wishes to sell
     * @return Boolean- true if sale was successful
     * This allows a player to sell a tile on the board.
     */
    public boolean sellTile(Tile tile) {
        if(tile instanceof Ownable){
            Ownable ownable = (Ownable) tile;
            if(ownable.isOwned() && ownable.getOwner().equals(this)){
                ownable.setOwner(null);
                this.addBalance(ownable.getSellPrice());
            }
        }
        return false;
    }

    /**
     * isBankrupt
     *
     * @return Boolean- true if player has no funds avaliable, cash or property
     * This method returns if a player has no funds and is thus out of the game.
     */

    public boolean isBankrupt(){
        return this.balance <= 0;

    }

    /**
     * mortgageTile
     *
     * @param tile The tile the player wishes to mortgage
     * @return Boolean - true if mortgage successful
     * This method allows a player to mortgage a tile.
     */
    public boolean mortgageTile(Tile tile) {
        if(tile instanceof Ownable){
            Ownable ownable = (Ownable) tile;
            if(ownable instanceof Property){
                if(((Property) ownable).getAmountOfHouses() > 0){
                    return false;
                }
            }
            ownable.setMortgaged(true);
            this.addBalance(ownable.getMortgagePrice());
            return true;

        }
        return false;
    }

    /**
     * getName
     *
     * @return The players name
     * This method will give the name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * setName
     *
     * @param name Player name
     *             This method sets the players name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getInJail
     *
     * @return Boolean- true if player is in jail
     * This method checks if the player is in jail.
     */
    public boolean getInJail() {
        return this.inJail;
    }


    /**
     * setBoard
     * @param board
     * This method sets the board within a player object.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * getBoard
     * @return board
     * This method gets the board within a player object.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * setInJail
     *
     * @param inJail Boolean true if moving to jail, false if moving to just visiting
     *               This method moves a player in and out of jail.
     */
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    /**
     * getBalance
     *
     * @return Players available balance
     * This method returns the amount of money the player currently has.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * setBalance
     *
     * @param balance Amount of money the player now has
     *                This method sets the amount of money the player has.
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * addBalance
     *
     * @param amount Amount of money to adjust the player's balance by
     */
    public void addBalance(int amount) {
        this.balance += amount;
    }

    /**
     * getPosition
     *
     * @return The tile the player is currently on
     * This shows the current location of a player.
     */
    public Tile getPosition() {
        return this.position;
    }

    /**
     * setPosition
     *
     * @param position The tile the player is moving to
     *                 This method moves the player to another space on the board.
     */
    public void setPosition(Tile position) {
        this.position = position;
    }

    /**
     * getOwnedTiles
     *
     * @return All tiles owned by the player
     * This returns an array of the abstract objects called ownables that the player currently owns. Ownables are tiles that is it possible for a player to buy.
     */
    public ArrayList<Ownable> getOwnedTiles() {
        return this.ownedTiles;
    }

    /**
     * addOwnable
     *
     * @param ownedTiles A tile that a player can possess
     *                   Allows a player to own a property, through purchasing auction or otherwise.
     */
    public void setOwnedTiles(ArrayList<Ownable> ownedTiles) {
        this.ownedTiles = ownedTiles;
    }

    /**
     * getPiece
     *
     * @return The piece the player is playing as
     * Return the piece that the player is playing as this could be a hatstand, cat, etc
     */
    public PlayerPiece getPiece() {
        return this.piece;
    }

    /**
     * setPiece
     *
     * @param piece A PlayerPiece object from the enumerator
     *              This assigns a player a specific player piece, this could be a hatstand, cat, etc.
     */
    public void setPiece(PlayerPiece piece) {
        this.piece = piece;
    }


}
