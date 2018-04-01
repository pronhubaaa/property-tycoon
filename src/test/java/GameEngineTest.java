import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GameEngineTest {

    @Before
    public void setUp() throws Exception {

        JSONObject json = new JSONObject();
        ArrayList<Player> players = new ArrayList<Player>(5);

        players.add(new Player(10, "Peter"));
        players.add(new Player(10, "Elliot"));
        players.add(new Player(10, "Sam"));
        players.add(new Player(10, "Liam"));
        players.add(new Player(10, "Guy"));


        GameType type = GameType.FullGame;

        GameEngine gameEngineFull = new GameEngine(json, players, type);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void startGame() {
    }

    @Test
    public void getCurrentPlayer() {



    }

    @Test
    public void nextTurn() {
    }

    @Test
    public void getNumberOfTurns() {
    }

    @Test
    public void incrementNumberOfTurns() {
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