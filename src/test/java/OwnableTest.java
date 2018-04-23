import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnableTest {

    private final static String TEST_OWNABLE_NAME = "test";
    private final static int TEST_OWNABLE_POSITION = 5;
    private final static int TEST_OWNABLE_PRICE = 20;
    private final static int TEST_OWNABLE_SETPRICE_VALUE = 30;
    private final static String TEST_INITIAL_OWNER_NAME = "A";
    private final static String TEST_SECOND_OWNER_NAME = "B";

    private Player initialOwner;
    private Player secondOwner;
    private Group initialGroup;
    private Group secondGroup;
    private Ownable ownable;


    @Before
    public void setUp() throws Exception {
        Board board = new Board(new JSONObject());
        initialOwner = new Player(0, TEST_INITIAL_OWNER_NAME, board);
        secondOwner = new Player(0, TEST_SECOND_OWNER_NAME, board);
        initialGroup = new Group();
        secondGroup = new Group();
        ownable = new Ownable(TEST_OWNABLE_NAME, TEST_OWNABLE_POSITION, initialGroup);
    }

    @Test
    public void isOwned() {
        ownable.setOwner(initialOwner);
        assertTrue(ownable.isOwned());
    }

    @Test
    public void getOwner() {
        ownable.setOwner(initialOwner);
        assertEquals(initialOwner.getName(), ownable.getOwner().getName());
    }

    @Test
    public void setOwner() {
        ownable.setOwner(secondOwner);
        assertEquals(secondOwner.getName(), ownable.getOwner().getName());
    }

    @Test
    public void getPrice() {
        ownable.setPrice(TEST_OWNABLE_PRICE);
        assertEquals(TEST_OWNABLE_PRICE, ownable.getPrice());
    }

    @Test
    public void setPrice() {
        ownable.setPrice(TEST_OWNABLE_SETPRICE_VALUE);
        assertEquals(TEST_OWNABLE_SETPRICE_VALUE, ownable.getPrice());
    }

    @Test
    public void getMortgagePrice() {
        ownable.setMortgagePrice(TEST_OWNABLE_PRICE);
        assertEquals(TEST_OWNABLE_PRICE, ownable.getMortgagePrice());

    }

    @Test
    public void setMortgagePrice() {
        ownable.setMortgagePrice(TEST_OWNABLE_SETPRICE_VALUE);
        assertEquals(TEST_OWNABLE_SETPRICE_VALUE, ownable.getMortgagePrice());
    }

    @Test
    public void getSellPrice() {
        ownable.setSellPrice(TEST_OWNABLE_PRICE);
        assertEquals(TEST_OWNABLE_PRICE, ownable.getSellPrice());
    }

    @Test
    public void setSellPrice() {
        ownable.setSellPrice(TEST_OWNABLE_SETPRICE_VALUE);
        assertEquals(TEST_OWNABLE_SETPRICE_VALUE, ownable.getSellPrice());
    }

    @Test
    public void isMortgaged() {
        assertFalse(ownable.isMortgaged());
    }

    @Test
    public void setMortgaged() {
        ownable.setMortgaged(true);
        assertTrue(ownable.isMortgaged());
    }

    @Test
    public void getGroup() {
        // TODO
    }

    @Test
    public void setGroup() {
        // TODO
    }
}