import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyTest {

    private static final int TEST_INITIAL_COSTOFHOUSE = 100;
    private static final int TEST_SECOND_COSTOFHOUSE = 200;
    private static final int TEST_AMOUNT_OF_HOUSES = 1;

    private Group group;
    private Property property;
    private Player owner;
    private Player player;

    @Before
    public void setUp() throws Exception {
        group = new Group();
        property = new Property("", 0, group);
        Board board = new Board(new JSONObject());
        owner = new Player(0, "", board);
        player = new Player(0, "", board);
        property.setCostOfHouse(TEST_INITIAL_COSTOFHOUSE);
    }

    @Test
    public void getCostOfHouse() {
        assertEquals(TEST_INITIAL_COSTOFHOUSE, property.getCostOfHouse());
    }

    @Test
    public void setCostOfHouse() {
        property.setCostOfHouse(TEST_SECOND_COSTOFHOUSE);
        assertEquals(TEST_SECOND_COSTOFHOUSE, property.getCostOfHouse());
    }

    @Test
    public void addRemoveHouses() {
        owner.setBalance(property.getCostOfHouse() * TEST_AMOUNT_OF_HOUSES);
        property.addHouses(owner, TEST_AMOUNT_OF_HOUSES);
        assertEquals(0, owner.getBalance());
        assertEquals(TEST_AMOUNT_OF_HOUSES, property.getAmountOfHouses());
        property.removeHouses(TEST_AMOUNT_OF_HOUSES);
        assertEquals(0, property.getAmountOfHouses());
    }

    @Test
    public void getAmountOfHouses() {
        owner.setBalance(property.getCostOfHouse() * TEST_AMOUNT_OF_HOUSES);
        property.addHouses(owner, TEST_AMOUNT_OF_HOUSES);
        assertEquals(0, owner.getBalance());
        assertEquals(TEST_AMOUNT_OF_HOUSES, property.getAmountOfHouses());
    }

    @Test
    public void applyRentPayment() {
        // TODO
    }
}