import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
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

    /**
     * trading: Boolean
     * This is a variable to store if trading is on or off.
     */
    private boolean trading;

    /**
     * checkGameType
     *
     * @param str
     * @return GameType or null
     */
    private GameType checkGameType(String str) {
        for (GameType me : GameType.values()) {
            if (me.name().equals(str))
                return me;
        }
        return null;
    }

    /**
     * checkPieceType
     *
     * @param str
     * @return PlayerPiece or null
     */
    private PlayerPiece checkPieceType(String str) {
        for (PlayerPiece me : PlayerPiece.values()) {
            if (me.name().equals(str))
                return me;
        }
        return null;
    }


    /**
     * GameEngine
     *
     * @param jsonObject JsonObject of save file data
     *                   This is the constructor method. The JSON data will include board data, player data, the game type and any remaining time.
     *                   This method will be used to load a save file, so it should fully restore a previous game state and initial the board.
     */
    public GameEngine(JSONObject jsonObject) throws GameEngineTypeException, GameEngineTimeException, GameEngineTradingException, BoardTileException {
        this.players = new ArrayList<>();

        if (jsonObject.containsKey(JsonField.GameType.toString())) {

            GameType type = checkGameType(jsonObject.getString(JsonField.GameType.toString()));
            if (type != null) {
                this.gameType = type;

                if (this.gameType.equals(GameType.AbridgedGame)) {
                    if (jsonObject.containsKey(JsonField.TimeLeft.toString())) {
                        int time = jsonObject.getIntValue(JsonField.TimeLeft.toString());
                        if (time < 0) {
                            this.timeLeft = 0;
                        } else {
                            this.timeLeft = time;
                        }

                    } else {
                        throw new GameEngineTimeException("Please include a time parameter for an abridged game");
                    }
                }


            } else {
                throw new GameEngineTypeException("Game Type is invalid. Please use either FullGame or AbridgedGame");
            }
        }

        if (jsonObject.containsKey(JsonField.NumberTurns.toString())) {
            this.numberOfTurns = jsonObject.getIntValue(JsonField.NumberTurns.toString());
        } else {
            this.numberOfTurns = 0;
        }

        if (jsonObject.containsKey(JsonField.Trade.toString())) {
            this.trading = jsonObject.getBooleanValue(JsonField.Trade.toString());
        } else {
            throw new GameEngineTradingException("Please include trading boolean");
        }

        this.gameBoard = constructGameBoard(jsonObject);

        if (jsonObject.containsKey(JsonField.Player.toString())) {

            JSONArray players = jsonObject.getJSONArray(JsonField.Player.toString());

            for (Object object : players) {

                JSONObject player = (JSONObject) object;

                boolean inJail = player.getBooleanValue(JsonField.Jail.toString());
                int balance = player.getIntValue(JsonField.Balance.toString());
                String name = player.getString(JsonField.Name.toString());
                int position = player.getIntValue(JsonField.Position.toString());

                JSONArray ownedTiles = player.getJSONArray(JsonField.Owned.toString());

                ArrayList<Integer> ownedTile = new ArrayList<>();
                for (int i = 0; i < ownedTiles.size(); i++) {
                    ownedTile.add(ownedTiles.getIntValue(i));
                }

                PlayerPiece type = checkPieceType(jsonObject.getString(JsonField.Piece.toString()));

                Player player1 = new Player(balance, name, this.gameBoard);
                player1.setPiece(type);
                player1.setPosition(this.gameBoard.getTiles().get(position));
                player1.setInJail(inJail);
                this.players.add(player1);


            }
            if (jsonObject.containsKey(JsonField.CurrentPlayer.toString()) && this.players.size() > jsonObject.getIntValue(JsonField.CurrentPlayer.toString())) {
                this.currentPlayer = this.players.get(jsonObject.getIntValue(JsonField.CurrentPlayer.toString()));
            }


        }

    }

    /**
     * GameEngine
     *
     * @param jsonObject      JsonObject of imported board data
     * @param players         Array of Players
     * @param type            GameType enum
     * @param numberOfMinutes Int number of minutes
     *                        <p>
     *                        This is the constructor method. It will be used to start a new game and initialise the board.
     */
    public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type, int numberOfMinutes) throws BoardTileException {
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
     *
     * @param jsonObject JsonObject of imported board data
     * @param players    Array of Players
     * @param type       GameType enum
     *                   <p>
     *                   This is the constructor method. It will be used to start a new game and initialise the board.
     */
    public GameEngine(JSONObject jsonObject, ArrayList<Player> players, GameType type) throws BoardTileException {
        this(jsonObject, players, type, -1);
    }

    /**
     * saveGame
     * Saves the whole game to a json file
     */
    public void saveGame() {
        JSONObject json = new JSONObject();
        json.put(JsonField.GameType.toString(), this.gameType.name());
        json.put(JsonField.CurrentPlayer.toString(), String.valueOf(this.players.indexOf(this.currentPlayer)));
        json.put(JsonField.NumberTurns.toString(), String.valueOf(this.numberOfTurns));
        json.put(JsonField.Trade.toString(), String.valueOf(this.trading));
        json.put(JsonField.TimeLeft.toString(), String.valueOf(this.timeLeft));

        JSONArray players = new JSONArray();


        for(Player player: this.players){
            JSONObject playerObject = new JSONObject();
            playerObject.put(JsonField.Jail.toString(), String.valueOf(player.getInJail()));
            playerObject.put(JsonField.Balance.toString(), String.valueOf(player.getBalance()));
            playerObject.put(JsonField.Name.toString(), String.valueOf(player.getName()));

            playerObject.put(JsonField.Position.toString(), String.valueOf(this.gameBoard.getTiles().indexOf(player.getPosition())));
            if(player.getPiece() != null){
                playerObject.put(JsonField.Piece.toString(), player.getPiece().toString());
            }

            JSONArray ownedTiles = new JSONArray();
            for(Tile tile: player.getOwnedTiles()){
                ownedTiles.add(this.gameBoard.getTiles().indexOf(tile));
            }
            playerObject.put(JsonField.Owned.toString(), ownedTiles);
            players.add(playerObject);
        }

        json.put(JsonField.Player.toString(), players);

        try {
            URL url = getClass().getResource("./resources/board.json");
            File file = new File(url.getPath());

            String board = new Scanner(file).useDelimiter("\\Z").next();

            JSONObject boardJson = (JSONObject) JSONObject.parse(board);


            json.put(JsonField.Tiles.toString(), boardJson.getJSONArray(JsonField.Tiles.toString()));
        } catch(FileNotFoundException e) {

        }

        String fileName = "";
        for(Player player: this.players){
            fileName += player.getName();
        }
        fileName += ".json";

        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(json.toString());
            out.close();
        } catch (Exception e) {

        }

    }

    /**
     * startGame
     * This method is intended to be accessed from the UI class. It will start the game.
     */
    public void startGame() {
        if (this.gameType.equals(GameType.AbridgedGame)) {
            this.startTimer();
        }
    }

    /**
     * getCurrentPlayer
     *
     * @return Player Player whose goes it is.
     * <p>
     * This method return a pointer to the player whose turn it currently is.
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * nextTurn
     *
     * @return Player whose go it is _now_ is.
     * <p>
     * This method will be used by the UI class to end the current player's turn and begin the next player's turn.
     * It will be responsible for checking whether the game is over (using endGame method), changing the current player reference and incrementing the numberOfTurns attribute.
     */
    public Player nextTurn() {
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % this.players.size());
        this.incrementNumberOfTurns();
        return this.currentPlayer;

    }

    /**
     * getNumberOfTurns
     *
     * @return Int representing the number of turns
     * <p>
     * This method returns the accumulated number of turns in the game.
     */
    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }

    /**
     * incrementNumberOfTurns
     *
     * @return Boolean to show if the game is over
     * This methods increments the numberOfTurns attribute by one.
     */
    public boolean incrementNumberOfTurns() {
        if (this.endGame()) {
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
            this.timer.schedule(task, date, 1000);
        }
    }

    /**
     * stopTimer
     * This stops the timer for the abridged version of the game.
     */
    public void stopTimer() {
        this.timer.cancel();


    }

    /**
     * getTime
     *
     * @return time
     * <p>
     * This gets the amount of time left in the abridged version.
     */
    public int getTime() {
        return this.timeLeft;
    }


    /**
     * constructGameBoard
     *
     * @param jsonObject
     * @return Board
     * <p>
     * Sets up a board using the imported board data.
     * If the JSON object contains additional data (eg. from a save file) this should be filtered out before constructing the Board object.
     */
    private Board constructGameBoard(JSONObject jsonObject) throws BoardTileException {
        return new Board(jsonObject);

    }


    /**
     * endGame
     *
     * @return Boolean
     * <p>
     * This method is intended to be accessed from incrementCurrentTurn. It will determine whether the game is over, by using methods such as getTime (if it is the abridged version) and also by checking the number of players still in the game.
     */
    private Boolean endGame() {
        return (getTime() == 0) &&
                getCurrentPlayer().equals(this.players.get(this.players.size() - 1));
    }


    /**
     * addPlayer
     * <p>
     * This method is used by the constructor to add a player to the engine. It will populate the players attribute array.
     */
    private void addPlayer(Player player) {
        this.players.add(player);

    }

    /**
     * getTrading
     *
     * @return trading boolean
     * <p>
     * This gets the trading boolean.
     */
    public boolean getTrading() {
        return this.trading;
    }

    /**
     * setTrading
     * <p>
     * This sets the trading boolean.
     */
    public void setTrading(boolean trading) {
        this.trading = trading;
    }
}
