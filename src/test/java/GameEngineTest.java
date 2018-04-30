import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class GameEngineTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void constructSavedGame() throws Exception {

        URL url = getClass().getResource("./resources/savedGame.json");
        File file = new File(url.getPath());

        String myJson = new Scanner(file).useDelimiter("\\Z").next();


        JSONObject json = (JSONObject) JSONObject.parse(myJson);


        try {
            GameEngine gameEngineSaved = new GameEngine(json);
            assertEquals(0, gameEngineSaved.getTime());
            assertFalse(gameEngineSaved.getTrading());
        } catch (Exception e) {
            System.out.println(e);
            fail();
        }
    }


    @Test
    public void getCurrentPlayer() {

        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<>(5);

        players.add(new Player(10, "Peter", null));
        players.add(new Player(10, "Elliot", null));
        players.add(new Player(10, "Sam", null));
        players.add(new Player(10, "Liam", null));
        players.add(new Player(10, "Guy", null));


        GameType type = GameType.FullGame;
        try {
            GameEngine gameEngineFull = new GameEngine(json, players, type);

            assertEquals(players.get(0), gameEngineFull.getCurrentPlayer());
        } catch (Exception e) {
            fail();
        }


    }

    @Test
    public void nextTurn() {
        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<>(5);

        players.add(new Player(10, "Peter", null));
        players.add(new Player(10, "Elliot", null));
        players.add(new Player(10, "Sam", null));
        players.add(new Player(10, "Liam", null));
        players.add(new Player(10, "Guy", null));

        GameType type = GameType.FullGame;

        try {
            GameEngine gameEngineFull = new GameEngine(json, players, type);

            assertEquals(players.get(0), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(1), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(2), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(3), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(4), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(0), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(1), gameEngineFull.getCurrentPlayer());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(players.get(2), gameEngineFull.getCurrentPlayer());
        } catch (Exception e) {
            fail();
        }


    }

    @Test
    public void getNumberOfTurns() {
        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<>(5);

        players.add(new Player(10, "Peter", null));
        players.add(new Player(10, "Elliot", null));
        players.add(new Player(10, "Sam", null));
        players.add(new Player(10, "Liam", null));
        players.add(new Player(10, "Guy", null));

        GameType type = GameType.FullGame;

        try {
            GameEngine gameEngineFull = new GameEngine(json, players, type);

            assertEquals(0, gameEngineFull.getNumberOfTurns());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(1, gameEngineFull.getNumberOfTurns());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(2, gameEngineFull.getNumberOfTurns());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(3, gameEngineFull.getNumberOfTurns());
            assertNotNull(gameEngineFull.nextTurn());
            assertEquals(4, gameEngineFull.getNumberOfTurns());
            assertNotNull(gameEngineFull.nextTurn());
        } catch (Exception e) {
            fail();
        }

    }


    @Test
    public void getTime() {
        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<>(5);

        players.add(new Player(10, "Peter", null));
        players.add(new Player(10, "Elliot", null));
        players.add(new Player(10, "Sam", null));
        players.add(new Player(10, "Liam", null));
        players.add(new Player(10, "Guy", null));


        GameType type = GameType.FullGame;

        try {
            GameEngine gameEngineFull = new GameEngine(json, players, type);
            assertEquals(-1, gameEngineFull.getTime());
        } catch (Exception e) {
            fail();
        }


        type = GameType.AbridgedGame;
        try {
            GameEngine gameEngineAbridgedGame = new GameEngine(json, players, type, 105);
            assertEquals(105, gameEngineAbridgedGame.getTime());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void saveGame() throws FileNotFoundException {
        URL url = getClass().getResource("./resources/board.json");
        File file = new File(url.getPath());

        String myJson = new Scanner(file).useDelimiter("\\Z").next();


        JSONObject json = (JSONObject) JSONObject.parse(myJson);


        ArrayList<Player> players = new ArrayList<>(5);

        try {
            Board board = new Board(json);
            players.add(new Player(10, "Peter", board));
            players.add(new Player(10, "Elliot", board));
            players.add(new Player(10, "Sam", board));
            players.add(new Player(10, "Liam", board));
            players.add(new Player(10, "Guy", board));


            GameType type = GameType.FullGame;

            try {
                GameEngine gameEngineFull = new GameEngine(json, players, type);
                gameEngineFull.saveGame();
            } catch (Exception e) {
                fail();
            }
        } catch (Exception e) {

        }


        try {
            GameType type = GameType.FullGame;
            GameEngine gameEngineFull = new GameEngine(json, players, type);
            gameEngineFull.saveGame();
        } catch (Exception e) {
            fail();
        }


    }
}