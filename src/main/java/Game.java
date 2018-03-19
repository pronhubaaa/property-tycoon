/**
 * Game
 * @date 2018-03-19
 *
 */
public class Game {

    /**
     * gameEngine: GameEngine
     * The current game being played.
     */
    private GameEngine gameEngine;

    /**
     *  ui: UI
     *  The current interface objects being used.
     */
    private UI ui;

    /**
     * minPlayers: Int
     * The minimum amount of players able to play.
     */
    private int minPlayers;

    /**
     * maxPlayers: Int
     * The maximum amount of players able to play.
     */
    private int maxPlayers;


    /**
     * Game()
     * This constructor will construct the game user interface.
     */
    public Game(){
        //this.gameEngine = new GameEngine();
        this.constructUI(this.gameEngine);
    }

    /**
     * constructUI(GameEngine)
     * @param gameEngine
     * This will build a user interface given a setup game engine, this being the data used to initialise the board.
     */
    private void constructUI(GameEngine gameEngine){
        this.ui = new UI();
    }


    public static void main(String[] args) {
        new Game();
    }

}
