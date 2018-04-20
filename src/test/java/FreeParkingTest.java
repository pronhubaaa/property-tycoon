import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeParkingTest {

    private final static int TEST_INCOME_VALUE = 100;
    private final static String TEST_PLAYER_NAME = "test";

    private FreeParking freeParking;
    private Player player;

    @Before
    public void setUp() throws Exception {
        freeParking = new FreeParking("", 0);
        Board board = new Board(new JSONObject());
        player = new Player(0, TEST_PLAYER_NAME, board);
    }

    @Test
    public void collect() {
        int preTestBalance = player.getBalance();
        freeParking.setValue(TEST_INCOME_VALUE);
        freeParking.collect(player);
        assertEquals(preTestBalance + TEST_INCOME_VALUE, player.getBalance());
        assertEquals(0, freeParking.getValue());
    }
}