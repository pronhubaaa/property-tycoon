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

        Scene mainMenuScene = MainMenuScreens.getMainMenu(this);
        this.showScene(mainMenuScene);
        this._primaryStage.show();
    }

    /**
     * This method allows us to view a specific scene, game, menu etc.
     * @param scene     The screen being displayed.
     */
    public void showScene(Scene scene) {
        this._primaryStage.setScene(scene);
    }

    /**
     * This method closes the UI windows
     */
    public void close() {
        this._primaryStage.close();
    }
}
