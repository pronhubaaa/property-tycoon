import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoTest {

    private final static int TEST_INITIAL_GO_VALUE = 100;
    private final static int TEST_SECOND_GO_VALUE = 200;
    private final static String TEST_PLAYER_NAME = "test";

    private Go go;
    private Player player;

    @Before
    public void setUp() throws Exception {
        go = new Go("go", 0, TEST_INITIAL_GO_VALUE);
        Board board = new Board(new JSONObject());
        player = new Player(0, TEST_PLAYER_NAME, board);
    }

    @Test
    public void getValue() {
        assertEquals(TEST_INITIAL_GO_VALUE, go.getValue());
    }

    @Test
    public void setValue() {
        go.setValue(TEST_SECOND_GO_VALUE);
        assertEquals(TEST_SECOND_GO_VALUE, go.getValue());
    }

    @Test
    public void collect() {
        int preTestBalance = player.getBalance();
        go.collect(player);
        assertEquals(preTestBalance + TEST_INITIAL_GO_VALUE, player.getBalance());
    }
}