import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.robot.FXRobotFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameBoardTest extends ApplicationTest {
    @BeforeClass
    public static void beforeClass() {
    }

    @Override
    public void start(Stage stage) {
        URL boardUrl = getClass().getResource("./resources/board.json");
        File boardFile = new File(boardUrl.getPath());

        String boardJSON = null;
        try {
            boardJSON = new Scanner(boardFile).useDelimiter("\\Z").next();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        JSONObject boardData = (JSONObject) JSONObject.parse(boardJSON);

        ArrayList<Player> players = new ArrayList<Player>(){{
            add(new Player(10, "Elliot", null));
            add(new Player(10, "Pete", null));
            add(new Player(10, "Sam", null));
        }};

        GameEngine gameEngine = null;
        try {
            gameEngine = new GameEngine(boardData, players, GameType.FullGame);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        UI ui = new UI(stage, gameEngine);
        stage.setTitle("Property Tycoon");

        GameBoard gameBoard = new GameBoard(gameEngine);

        ui.showScene(this.createSandboxScene(gameBoard));
        //stage.setFullScreen(true);
        stage.show();
    }

    public Scene createSandboxScene(GameBoard gameBoard) {
        return new Scene(gameBoard.getLayout());
    }

    @Test
    public void canDisplayAndHidePropertyDetails() {
        // Property details should not be visible initially
        FxAssert.verifyThat("#property-details", NodeMatchers.isNull());

        // Assert that a tile exists
        Node tileButton = lookup("#tile-2").query();
        assertThat(tileButton, is(not(nullValue())));
        FxAssert.verifyThat("#tile-2", NodeMatchers.isVisible());

        // Click the tile
        clickOn("#tile-2");

        // We expect that property details will appear
        Node detailsNode = lookup("#property-details").query();
        assertThat(detailsNode, is(not(nullValue())));
        FxAssert.verifyThat("#property-details", NodeMatchers.isVisible());

        // Click the tile again
        clickOn("#tile-2");

        try {
            wait(20000);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // When we click again it should disappear
        detailsNode = lookup("#property-details").query();
        assertThat(detailsNode, is(nullValue()));
        FxAssert.verifyThat("#property-details", NodeMatchers.isNull());
    }
}