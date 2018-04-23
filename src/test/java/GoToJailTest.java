import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GoToJailTest {

    private GoToJail goToJail;
    private Player player;

    @Before
    public void setUp() throws Exception {
        goToJail = new GoToJail("", 0);
        Board board = new Board(new JSONObject());
        player = new Player(0, "", board);
    }

    @Test
    public void sendToJail() {
        goToJail.sendToJail(player);
        assertTrue(player.getInJail());
    }
}