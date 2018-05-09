import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class NewGameScreenTest extends ApplicationTest {
    private NewGameScreen _newGameScene;
    private Stage _primaryStage;

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

    @Test
    public void canChangeGameType() {
        boolean currentType = _newGameScene.getGameType();
        assertTrue(currentType);

        clickOn("#game-type");

        currentType = _newGameScene.getGameType();
        assertFalse(currentType);
    }
}
