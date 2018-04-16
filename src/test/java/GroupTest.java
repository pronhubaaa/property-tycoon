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

        assertEquals(0, this.group.getGroups().size());
        this.group.add(new Group());
        assertEquals(1, this.group.getGroups().size());

        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group());
        groups.add(new Group());
        this.group.setGroups(groups);
        assertEquals(2, this.group.getGroups().size());
    }


}