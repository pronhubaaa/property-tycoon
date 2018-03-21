import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        GameEngine gameEngine = new GameEngine();

        assertTrue(gameEngine.getCurrentPlayer() instanceof Player);
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