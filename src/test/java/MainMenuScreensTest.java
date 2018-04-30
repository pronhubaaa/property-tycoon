import com.sun.javafx.robot.impl.FXRobotHelper;
import com.sun.javafx.stage.StageHelper;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

public class MainMenuScreensTest extends ApplicationTest {
    private Scene _mainMenuScene;
    private Scene _newGameScene;
    private Scene _loadGameScene;
    private Scene _importBoardScene;
    private Scene _settingsScene;

    private Stage _primaryStage;

    @BeforeClass
    public static void beforeClass() throws TimeoutException {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "false");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
    }

    @Override
    public void start(Stage stage) {
        this._primaryStage = stage;

        GameEngine gameEngine = null;
        stage.setTitle("Property Tycoon");

        UI ui = new UI(stage, gameEngine, true);

        this._mainMenuScene = MainMenuScreens.getMainMenu(ui, gameEngine);
        this._newGameScene = MainMenuScreens.getNewGame(ui, gameEngine);
        this._loadGameScene = MainMenuScreens.getLoadGame(ui);
        this._importBoardScene = MainMenuScreens.getImportBoard(ui);
        this._settingsScene = MainMenuScreens.getSettings(ui);

        ui.showScene(this._mainMenuScene);
    }

    @Override
    public void stop() {
        this._primaryStage.setScene(null);
    }

    @Test
    public void canClick() {
        // Click on the new game button which should change the scene
        clickOn("#new-game-button");

        // The scene should now not be the main menu scene
        assertNotEquals(this._primaryStage.getScene(), this._mainMenuScene);
    }

    @Test
    public void displaysNewGameScreen() {
        // Click on the new game button which should change the scene
        clickOn("#new-game-button");

        // The scene should now display new game screens
        assertTrue(this._primaryStage.getScene() instanceof NewGameScreen);
    }

    @Test
    public void displaysLoadGameScreen() {
        // Click on the load game button which should change the scene
        clickOn("#load-game-button");

        // The scene should now display load game screens
        assertTrue(this._primaryStage.getScene() instanceof LoadGameScreen);
    }

    @Test
    public void displaysImportBoardScreen() {
        // Click on the import board button which should change the scene
        clickOn("#import-board-button");

        // The scene should now display import board screens
        assertTrue(this._primaryStage.getScene() instanceof ImportBoardScreen);
    }

    @Test
    public void displaysSettingsScreen() {
        // Click on the settings button which should change the scene
        clickOn("#settings-button");

        // The scene should now display settings screens
        assertTrue(this._primaryStage.getScene() instanceof SettingsScreen);
    }

    @Test
    public void exits() {
        // Click on the exit button which should close the window
        clickOn("#exit-button");

        // The stage should now be closed
        assertFalse(this._primaryStage.isShowing());
    }
}