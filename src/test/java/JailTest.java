import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JailTest {

    private static final int TEST_INITIAL_FEE = 100;
    private static final int TEST_SECOND_FEE = 200;

    private Jail jail;
    private Player player;

    @Before
    public void setUp() throws Exception {
        jail = new Jail("", 0, TEST_INITIAL_FEE);
        Board board = new Board(new JSONObject());
        player = new Player(0, "", board);
    }

    @Test
    public void getFee() {
        assertEquals(TEST_INITIAL_FEE, jail.getFee());
    }

    @Test
    public void setFee() {
        jail.setFee(TEST_SECOND_FEE);
        assertEquals(TEST_SECOND_FEE, jail.getFee());
    }

    @Test
    public void freeFromJail() {
        player.setInJail(true);
        jail.freeFromJail(player);
        assertFalse(player.getInJail());
    }
}