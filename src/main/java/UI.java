import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The UI class is the controller used to go between the game engine and UI.
 * It will create all standard scenes to be used in the game.
 */
public class UI {
    // The game engine, all data for the current game.
    private GameEngine _gameEngine;

    // The primary stage for the UI.
    private Stage _primaryStage;

    /**
     * Initialise the user interface for the current dataset.
     * @param primaryStage  The primary stage for the UI.
     * @param gameEngine    The current game engine.
     */
    public UI(Stage primaryStage, GameEngine gameEngine) {
        primaryStage.setTitle("Property Tycoon");

        this._primaryStage = primaryStage;

        this._factoryMainMenu(gameEngine);
    }

    /**
     * This will show the main menu screen in the UI.
     * @param gameEngine    The current game engine.
     * @return An object of class MainMenu.
     */
    private MainMenu _factoryMainMenu(GameEngine gameEngine) {
        Scene scene = new Scene();
        this._primaryStage.setScene(scene);
        this._primaryStage.show();
    }

    /**
     * This will create the UI screen for the current game.
     * @param gameEngine    The current game engine.
     * @return A game object.
     */
    private Game _createGame(GameEngine gameEngine) {}

    /**
     * This will create a results screen for after the game.
     * @param gameEngine    The current game engine.
     * @return A post game object showing the leaderboard.
     */
    private PostGame _createPostGame(GameEngine gameEngine) {}

    /**
     * This method allows us to view a specific scene, game, menu etc.
     * @param scene     The screen being displayed.
     */
    private void _showScene(Scene scene) {}
}
