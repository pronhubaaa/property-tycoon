import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StationTest {

    private int[] TEST_INITIAL_RENT_LEVELS = {1, 2, 3, 4};
    private int[] TEST_SECOND_RENT_LEVELS = {5, 6, 7, 8};

    private ArrayList<Integer> initialRent;
    private ArrayList<Integer> secondRent;
    private Station station;
    private Player player;

    @Before
    public void setUp() throws BoardTileException {
        Group group = new Group();
        station = new Station("", 0, group);
        group.add(station);
        initialRent = new ArrayList<>();
        for (int i = 0; i < TEST_INITIAL_RENT_LEVELS.length; i++) {
            initialRent.add(TEST_INITIAL_RENT_LEVELS[i]);
        }
        station.setRent(initialRent);
        player = new Player(0, "", new Board(new JSONObject()));
    }

    @Test
    public void getRent() {
        assertEquals(initialRent, station.getRent());
    }

    @Test
    public void setRent() {
        station.setRent(secondRent);
        assertEquals(secondRent, station.getRent());
    }

    @Test
    public void applyRentPayment() {
        station.setOwner(player);
        player.setBalance(1);
        station.applyRentPayment(player);
        assertEquals(0, player.getBalance());
    }
}