import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    public void getAndAddGroups() {

        assertEquals(0, this.group.getGroup().size());
        this.group.add(new Property("", 0, null));
        assertEquals(1, this.group.getGroup().size());

        ArrayList<Ownable> groups = new ArrayList<>();
        groups.add(new Property("", 0, null));
        groups.add(new Property("", 1, null));
        this.group.setGroups(groups);
        assertEquals(2, this.group.getGroup().size());

    }


    @Test
    public void getGroupOwners() {



        Player player1 = new Player(50, "", null);
        Player player2 = new Player(50, "", null);

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


        assertEquals(players, this.group.getGroupOwners());
        assertEquals(players, this.group.getGroupOwners());
        assertEquals(players, this.group.getGroupOwners());

        assertEquals(new ArrayList<Player>(), this.group.getGroupOwners());




    }
}


//    public ArrayList<Player> getGroupOwners(Ownable ownable){
//        ArrayList<Player> players = new ArrayList<>();
//
//        for(Ownable owned: ownable.getGroup().getGroup()) {
//            players.add(owned.getOwner());
//        }
//
//        return players;
//    }
//
//}
