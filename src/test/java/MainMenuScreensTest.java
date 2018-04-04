import com.alibaba.fastjson.JSONObject;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class MainMenuScreensTest extends ApplicationTest {
    private Scene _mainMenuScene;
    private Stage _primaryStage;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
    }

    @Override
    public void start(Stage stage) {
        GameEngine gameEngine = null;
        UI ui = new UI(stage, gameEngine);
        stage.setTitle("Property Tycoon");

        this._mainMenuScene = MainMenuScreens.getMainMenu(ui);
        ui.showScene(this._mainMenuScene);
        stage.show();

        this._primaryStage = stage;
    }

    @Test
    public void getMainMenu() {
        // Click on the new game button which should change the scene
        clickOn("#new-game-button");

        // The scene should now not be the main menu scene
        assertNotEquals(this._primaryStage.getScene(), this._mainMenuScene);
    }
}