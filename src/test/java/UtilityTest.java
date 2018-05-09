import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilityTest {

    private static final int TEST_SOME_UTILITIES_OWNED_FACTOR = 4;
    private static final int TEST_ALL_UTILITIES_OWNED_FACTOR = 10;

    private Utility firstUtility;
    private Utility secondUtility;
    private Group group;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "", new Board(new JSONObject()));
        group = new Group();
        firstUtility = new Utility("", 0, group);
        firstUtility.setOwner(player);
        secondUtility = new Utility("", 0, group);
        group.add(firstUtility);
        group.add(secondUtility);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateRent() {
        assertEquals(TEST_SOME_UTILITIES_OWNED_FACTOR, firstUtility.calculateRent(player, 1));
        secondUtility.setOwner(player);
        assertEquals(TEST_ALL_UTILITIES_OWNED_FACTOR, firstUtility.calculateRent(player, 1));
    }
}