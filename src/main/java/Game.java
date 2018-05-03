import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Game
 *
 * @date 2018-03-19
 */
public class Game extends Application {

    /**
     * gameEngine: GameEngine
     * The current game being played.
     */
    private GameEngine gameEngine;

    //private Stage _primaryStage;

    @Override
    public void start(Stage primaryStage) {
        //this._primaryStage = primaryStage;
        GameEngine gameEngine = null;
        UI ui = new UI(primaryStage, gameEngine, false);
        ui.showScene(MainMenuScreens.getMainMenu(ui,gameEngine));
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * ui: UI
     * The current interface objects being used.
     */
    private UI ui;

    /**
     * minPlayers: Int
     * The minimum amount of players able to play.
     */
    private static int minPlayers = 2;

    /**
     * maxPlayers: Int
     * The maximum amount of players able to play.
     */
    private static int maxPlayers = 6;



    /**
     * Game()
     * This constructor will construct the game user interface.
     */
    public Game() {
        //this.gameEngine = new GameEngine();
        this.constructUI(null);
    }

    /**
     * constructUI(GameEngine)
     *
     * @param gameEngine This will build a user interface given a setup game engine, this being the data used to initialise the board.
     */
    private void constructUI(GameEngine gameEngine) {

    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }


}
