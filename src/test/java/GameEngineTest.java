import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameEngineTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void startGame() {
    }

    @Test
    public void getCurrentPlayer() {

        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<Player>(5);

        players.add(new Player(10, "Peter"));
        players.add(new Player(10, "Elliot"));
        players.add(new Player(10, "Sam"));
        players.add(new Player(10, "Liam"));
        players.add(new Player(10, "Guy"));


        GameType type = GameType.FullGame;

        GameEngine gameEngineFull = new GameEngine(json, players, type);

        assertEquals(players.get(0), gameEngineFull.getCurrentPlayer());




    }

    @Test
    public void nextTurn() {
        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<Player>(5);

        players.add(new Player(10, "Peter"));
        players.add(new Player(10, "Elliot"));
        players.add(new Player(10, "Sam"));
        players.add(new Player(10, "Liam"));
        players.add(new Player(10, "Guy"));

        GameType type = GameType.FullGame;

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


    }

    @Test
    public void getNumberOfTurns() {
        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<Player>(5);

        players.add(new Player(10, "Peter"));
        players.add(new Player(10, "Elliot"));
        players.add(new Player(10, "Sam"));
        players.add(new Player(10, "Liam"));
        players.add(new Player(10, "Guy"));

        GameType type = GameType.FullGame;

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
    }


    @Test
    public void startTimer() {
    }

    @Test
    public void stopTimer() {
    }

    @Test
    public void getTime() {
    }
}