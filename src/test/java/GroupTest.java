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
        this.group.add(new Property("", 0));
        assertEquals(1, this.group.getGroup().size());

        ArrayList<Ownable> groups = new ArrayList<>();
        groups.add(new Property("", 0));
        groups.add(new Property("", 1));
        this.group.setGroups(groups);
        assertEquals(2, this.group.getGroup().size());

    }


}