import com.alibaba.fastjson.JSONObject;

import java.sql.Time;
import java.util.Timer;


public class GameEngine {


    /**
     * gameBoard: Board
     * This is the representation of the board, which contains tiles, player locations, etc.
     */
    private Board gameBoard;

    /**
     * players: Array of Players
     * This array represents all the players playing the game. The order of the array will represent the order of play.
     */
    private Player[] players;

    /**
     * numberOfTurns: Int
     * This represents the current turn number. This will increment at the end of each turn.
     */
    private int numberOfTurns;

    /**
     * currentTurn: Player
     * This is a pointer to the player object whose turn it currently is.
     */
    private Player currentPlayer;


    /**
     * timer: Timer
     * This is the timer counting down for the abridged version of the game.
     */
    private Timer timer;

    /**
     * gameTimeLimit: int
     * This is the time limit of the game.
     */
    private int gameTimeLimit;


    /**
     * gameType: GameType
     * This is the type of game e.g. Abridged or Full.
     */
    private GameType gameType;


    /**
     * GameEngine
     * @param jsonObject JsonObject of save file data
     * This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time.
     * This method will be used to load a save file, so it should fully restore a previous game state and initial the board.
     */
    public GameEngine(JSONObject jsonObject){

    }

    /**
     * GameEngine
     * @param jsonObject JsonObject of imported board data
     * @param players Array of Players
     * @param type GameType enum
     * @param numberOfMinutes Int number of minutes
     *
     * This is the constructor method. It will be used to start a new game and initialise the board.
     */
    public GameEngine(JSONObject jsonObject, Player[] players, GameType type, int numberOfMinutes){
        this.players = players;
        this.gameTimeLimit = numberOfMinutes;
        this.gameType = type;
        this.gameBoard = constructGameBoard(jsonObject);


    }



    /**
     * GameEngine
     * @param jsonObject JsonObject of imported board data
     * @param players Array of Players
     * @param type GameType enum
     *
     * This is the constructor method. It will be used to start a new game and initialise the board.
     */
    public GameEngine(JSONObject jsonObject, Player[] players, GameType type){
        this.players = players;
        this.gameType = type;

        this.gameBoard = constructGameBoard(jsonObject);

    }

    /**
     * startGame
     * This method is intended to be accessed from the UI class. It will start the game.
     */
    public void startGame(){

    }

    /**
     * getCurrentPlayer
     * @return Player Player whose goes it is.
     *
     * This method return a pointer to the player whose turn it currently is.
     */
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * nextTurn
     * @return Player whose go it is _now_ is.
     *
     * This method will be used by the UI class to end the current player's turn and begin the next player's turn.
     * It will be responsible for checking whether the game is over (using endGame method), changing the current player reference and incrementing the numberOfTurns attribute.
     */
    public Player nextTurn(){

        return null;
    }

    /**
     * getNumberOfTurns
     * @return Int representing the number of turns
     *
     * This method returns the accumulated number of turns in the game.
     */
    public int getNumberOfTurns(){
        return this.numberOfTurns;
    }

    /**
     * incrementNumberOfTurns
     * This methods increments the numberOfTurns attribute by one.
     */
    public void incrementNumberOfTurns(){
        this.numberOfTurns++;

    }

    /**
     * startTimer
     * This starts the timer for the abridged version of the game.
     */
    public void startTimer(){

    }

    /**
     * stopTimer
     * This stops the timer for the abridged version of the game.
     */
    public void stopTimer(){

    }

    /**
     * getTime
     * @return time
     *
     * This gets the amount of time left in the abridged version.
     */
    public Time getTime(){
        return null;
    }


    /**
     * constructGameBoard
     * @param jsonObject
     * @return Board
     *
     * Sets up a board using the imported board data.
     * If the JSON object contains additional data (eg. from a save file) this should be filtered out before constructing the Board object.
     */
    private Board constructGameBoard(JSONObject jsonObject){
        return new Board(jsonObject);
    }


    /**
     * endGame
     * @return Boolean
     *
     * This method is intended to be accessed from incrementCurrentTurn. It will determine whether the game is over, by using methods such as getTime (if it is the abridged version) and also by checking the number of players still in the game.
     */
    private Boolean endGame(){
        return null;
    }


    /**
     * addPlayer
     *
     * This method is used by the constructor to add a player to the engine. It will populate the players attribute array.
     */
    private void addPlayer(Player player){


    }
}

