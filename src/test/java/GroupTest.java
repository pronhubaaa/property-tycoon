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


        Ownable ownable1 = new Ownable("", 0, group);
        ownable1.setOwner(player1);
        Ownable ownable2 = new Ownable("", 1, group);
        ownable2.setOwner(player2);

        Ownable ownable3 = new Ownable("", 2, group);

        group.add(ownable1);
        group.add(ownable2);
        group.add(ownable3);


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

        // Adds an ownable and station without player being the owner
        group.add(new Ownable("", 2, group));
        group.add(new Station("", 3, group));
        assertEquals(2, group.getAmountOwned(player));
    }
}
