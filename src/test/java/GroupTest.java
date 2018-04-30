import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GroupTest {


    private Group group;

    @Before
    public void setUp() throws Exception {
        this.group = new Group();
    }

    @After
    public void tearDown() throws Exception {
        this.group = null;
    }

    @Test
    public void getGroupOwners() {


        Player player1 = new Player(50, "Liam", null);
        Player player2 = new Player(50, "Pete", null);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(null);

        Group group = new Group();


        Utility Utility1 = new Utility("", 0, group);
        Utility1.setOwner(player1);
        Utility Utility2 = new Utility("", 1, group);
        Utility2.setOwner(player2);

        Utility Utility3 = new Utility("", 2, group);

        group.add(Utility1);
        group.add(Utility2);
        group.add(Utility3);


        assertEquals(players, group.getGroupOwners());


    }

    @Test
    public void checkOwnedStreet() {
        Player player1 = new Player(0, "", null);


        Property property1 = new Property("", 0, null);
        property1.setOwner(player1);
        group.add(property1);


        Property property2 = new Property("", 0, null);
        group.add(property2);

        property1.setGroup(group);
        property2.setGroup(group);

        assertFalse(this.group.isGroupAllOwned(player1));

        property2.setOwner(player1);
        assertTrue(this.group.isGroupAllOwned(player1));
    }

    @Test
    public void howManyAreOwned() {
        // Creates station group
        // Adds 2 stations owned by player
        Group group = new Group();
        Player player = new Player(0, "", null);
        Station station = new Station("", 0, group);
        station.setOwner(player);
        Station station2 = new Station("", 0, group);
        station2.setOwner(player);

        group.add(station);
        group.add(station2);

        assertEquals(2, group.getAmountOwned(player));

        // Adds an Utility and station without player being the owner
        group.add(new Utility("", 2, group));
        group.add(new Station("", 3, group));
        assertEquals(2, group.getAmountOwned(player));
    }
}
