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
//        Player player1 = new Player(0, "", null);
//
//
//        PropertyGroup group = new PropertyGroup();
//
//
//        Property property1 = new Property("", 0, group);
//        property1.setOwner(player1);
//        group.add(property1);
//
//
//        Property property2 = new Property("", 0, group);
//        group.add(property1);
//
//        assertFalse(this.group.checkOwnedStreet(player1));
//
//        property2.setOwner(player1);
//        assertTrue(this.group.checkOwnedStreet(player1));


    }

    @Test
    public void getColour() {
        assertTrue(this.group.getColour() instanceof Colour);
        assertEquals(Colour.White, this.group.getColour());
    }

    @Test
    public void setColour() {
        assertTrue(this.group.getColour() instanceof Colour);
        this.group.setColour(Colour.Blue);
        assertEquals(Colour.Blue, this.group.getColour());

    }
}