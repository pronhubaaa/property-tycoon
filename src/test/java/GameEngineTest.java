import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {

    @Before
    public void setUp() throws Exception {

        JSONObject json = new JSONObject();
        Player[] players = new Player[3];

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        players[0] = player1;
        players[1] = player2;
        players[2] = player3;

        GameType type = GameType.FULL;

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