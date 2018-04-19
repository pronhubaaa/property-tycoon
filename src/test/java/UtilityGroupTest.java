import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilityGroupTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void checkOwnedUtility() {
        // Creates utility group
        // Adds 2 utility owned by player
        UtilityGroup group = new UtilityGroup();
        Player player = new Player(0, "", null);
        Utility utility = new Utility("", 0);
        utility.setOwner(player);
        Utility utility2 = new Utility("", 0);
        utility2.setOwner(player);

        group.add(utility);
        group.add(utility2);

        assertEquals(2, group.checkOwnedUtility(player));

        // Adds an ownable and station without player being the owner
        group.add(new Ownable("", 2));
        group.add(new Utility("", 3));
        assertEquals(2, group.checkOwnedUtility(player));
    }
}