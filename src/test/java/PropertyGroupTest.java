import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyGroupTest {

    private PropertyGroup group;

    @Before
    public void setUp() throws Exception {
        this.group = new PropertyGroup();

    }

    @After
    public void tearDown() throws Exception {
        this.group = null;
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

        assertFalse(this.group.checkOwnedStreet(player1));

        property2.setOwner(player1);
        assertTrue(this.group.checkOwnedStreet(player1));


    }

    @Test
    public void getColour() {
        assertEquals(Colour.White, this.group.getColour());
    }

    @Test
    public void setColour() {
        this.group.setColour(Colour.Blue);
        assertEquals(Colour.Blue, this.group.getColour());

    }
}