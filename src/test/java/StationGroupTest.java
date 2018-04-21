import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StationGroupTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkOwnedStations() {
        // Creates station group
        // Adds 2 stations owned by player
        StationGroup group = new StationGroup();
        Player player = new Player(0, "", null);
        Station station = new Station("", 0, group);
        station.setOwner(player);
        Station station2 = new Station("", 0, group);
        station2.setOwner(player);

        group.add(station);
        group.add(station2);

        assertEquals(2, group.checkOwnedStations(player));

        // Adds an ownable and station without player being the owner
        group.add(new Ownable("", 2, group));
        group.add(new Station("", 3, group));
        assertEquals(2, group.checkOwnedStations(player));


    }
}