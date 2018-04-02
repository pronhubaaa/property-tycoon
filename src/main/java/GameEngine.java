import com.alibaba.fastjson.JSONObject;


import java.util.*;

/**
 * The game engine will be responsible for any action that happens on the board and controlling all of the players actions.
 */
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
    private ArrayList<Player> players;

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
     * timeLeft: int
     * This is the time left of the game.
     */
    private int timeLeft;


    /**
     * gameType: GameType
     * This is the type of game e.g. Abridged or Full.
     */
    private GameType gameType;

    private GameType checkGameType(String str){
        for (GameType me : gameType.values()) {
            if (me.name().equals(str))
                return me;
        }
        return null;
    }

    /**
     * GameEngine
     * @param jsonObject JsonObject of save file data
     * This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time.
     * This method will be used to load a save file, so it should fully restore a previous game state and initial the board.
     */
    public GameEngine(JSONObject jsonObject) throws GameEngineException {
        if(jsonObject.containsKey("game_type")){

            GameType type = checkGameType(jsonObject.getString("game_type"));
            if(type != null){
                this.gameType = type;
                System.out.println(this.gameType);
            } else {
                throw new GameEngineException("Game Type is invalid. Please use either FullGame or AbridgedGame");
            }

        }

        if(jsonObject.containsKey("remaining_time")){
            int time = jsonObject.getIntValue("remaining_time");
            if(time < 0){
                this.timeLeft = 0;
            } else {
                this.timeLeft = time;
            }

        }

        if(jsonObject.containsKey("current_player")){
            this.currentPlayer = this.players.get(jsonObject.getIntValue("current_player"));
        }

        if(jsonObject.containsKey("number_of_turns")){
            this.numberOfTurns = jsonObject.getIntValue("number_of_turns");
        }

       // this.gameBoard = constructGameBoard(jsonObject);

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
    public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type, int numberOfMinutes){
        this.players = players;
        this.currentPlayer = this.players.get(0);
        this.gameType = type;
        this.gameBoard = constructGameBoard(jsonObject);
        this.numberOfTurns = 0;
        this.timeLeft = numberOfMinutes;
        this.timer = new Timer();
    }

    /**
     * GameEngine
     * @param jsonObject JsonObject of imported board data
     * @param players Array of Players
     * @param type GameType enum
     *
     * This is the constructor method. It will be used to start a new game and initialise the board.
     */
    public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type){
        this(jsonObject, players, type, -1);
    }

    /**
     * startGame
     * This method is intended to be accessed from the UI class. It will start the game.
     */
    public void startGame(){
        if(this.gameType.equals(GameType.AbridgedGame)){
            this.startTimer();
        }
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
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer)+1)%this.players.size());
        this.incrementNumberOfTurns();
        return this.currentPlayer;

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
     * @return Boolean to show if the game is over
     * This methods increments the numberOfTurns attribute by one.
     */
    public boolean incrementNumberOfTurns(){
        if(this.endGame()){
            this.stopTimer();
            return false;
        } else {
            this.numberOfTurns++;
            return true;
        }


    }

    /**
     * startTimer
     * This starts the timer for the abridged version of the game.
     */
    public void startTimer() {
        if (this.gameType.equals(GameType.AbridgedGame)) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (timeLeft > 0) {
                        timeLeft -= 1;
                    }
                }
            };
            Date date = new Date();
            date.setTime(date.getTime() + 1000);
            this.timer.schedule(task, date, 1000);
        }
    }

    /**
     * stopTimer
     * This stops the timer for the abridged version of the game.
     */
    public void stopTimer(){
        this.timer.cancel();


    }

    /**
     * getTime
     * @return time
     *
     * This gets the amount of time left in the abridged version.
     */
    public int getTime(){
        return this.timeLeft;
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
        if((getTime() == 0) && getCurrentPlayer().equals(this.players.get(this.players.size()-1))){
            return true;
        }
        return false;
    }


    /**
     * addPlayer
     *
     * This method is used by the constructor to add a player to the engine. It will populate the players attribute array.
     */
    private void addPlayer(Player player){
        this.players.add(player);


    }
}
