import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeTileTest {

    private final static int TEST_INITIAL_INCOME_VALUE = 100;
    private final static int TEST_SECOND_INCOME_VALUE = 200;
    private final static String TEST_PLAYER_NAME = "test";

    private IncomeTile incomeTile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        incomeTile = new IncomeTile("incomeTile", 0, TEST_INITIAL_INCOME_VALUE);
        Board board = new Board(new JSONObject());
        player = new Player(0, TEST_PLAYER_NAME, board);
    }

    @Test
    public void getValue() {
        assertEquals(TEST_INITIAL_INCOME_VALUE, incomeTile.getValue());
    }

    @Test
    public void setValue() {
        incomeTile.setValue(TEST_SECOND_INCOME_VALUE);
        assertEquals(TEST_SECOND_INCOME_VALUE, incomeTile.getValue());
    }

    @Test
    public void addValue() {
        incomeTile.addValue(TEST_SECOND_INCOME_VALUE);
        assertEquals(TEST_SECOND_INCOME_VALUE * 2, incomeTile.getValue());
    }

    @Test
    public void collect() {
        int preTestBalance = player.getBalance();
        incomeTile.collect(player);
        assertEquals(preTestBalance + TEST_INITIAL_INCOME_VALUE, player.getBalance());
    }
}