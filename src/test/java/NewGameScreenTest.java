import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class NewGameScreenTest extends ApplicationTest {
    private NewGameScreen _newGameScene;
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
        UI ui = new UI(stage, gameEngine, true);
        stage.setTitle("Property Tycoon");
        _newGameScene = new NewGameScreen(new VBox(), ui, gameEngine);
        ui.showScene(this._newGameScene);
        stage.show();

        this._primaryStage = stage;
    }

//    @Test
//    public void canInputText() {
//        // Click on the first player name TextField
//        clickOn("#test-input");
//
//        // Write in the field
//        write("Player 1");
//
//        //Assert the field isn't blank
//        assertNotEquals("", _newGameScene.getPlayerOneName());
//    }

    @Test
    public void canChangeGameType() {
        boolean currentType = _newGameScene.getGameType();
        assertTrue(currentType);

        VBox abridged = _newGameScene.getAbridgedBox();
        clickOn(abridged);

        currentType = _newGameScene.getGameType();
        assertFalse(currentType);
    }

    @Test
    public void canClickReturnToMenu() {
        // Click on the return to menu button
        clickOn("#menu-text");

        // Ensure we've returned to main menu
        assertNotEquals(this._newGameScene, this._primaryStage.getScene());
    }

//    @Test
//    public void canOnlyInputNumbers() {
//        //Click on timer input box
//        TextField timer = _newGameScene.getTimer();
//        clickOn(timer);
//        write("a1b2c3");
//        timer = _newGameScene.getTimer();
//        int timerValue = Integer.parseInt(timer.getText());
//        assertEquals("123", timerValue);
//    }
}
