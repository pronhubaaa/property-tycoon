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

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static int getMinPlayers() {
        return minPlayers;
    }

    @Override
    public void start(Stage primaryStage) {
        //this._primaryStage = primaryStage;
        this.gameEngine = null;
        this.ui = new UI(primaryStage, gameEngine, false);
        this.ui.showScene(MainMenuScreens.getMainMenu(this.ui,gameEngine));

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
