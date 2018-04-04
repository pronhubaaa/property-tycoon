import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    @Before
    public void setUp() throws Exception {
        this.player = new Player(10, "Peter");

    }

    @After
    public void tearDown() throws Exception {
        this.player = null;
    }

    @Test
    public void buyTile() {
    }

    @Test
    public void isBankrupt() {
        this.player.setBalance(100);
        assertFalse(this.player.isBankrupt());
        this.player.setBalance(0);
        assertTrue(this.player.isBankrupt());

    }

    @Test
    public void morgageTile() {
    }

    @Test
    public void getName() {
        assertEquals("Peter", this.player.getName());
    }

    @Test
    public void setName() {
        assertEquals("Peter", this.player.getName());
        this.player.setName("Test");
        assertEquals("Test", this.player.getName());
    }

    @Test
    public void getInJail() {
        assertFalse(this.player.getInJail());
    }

    @Test
    public void setInJail() {
        assertFalse("Peter", this.player.getInJail());
        this.player.setInJail(true);
        assertTrue("Test", this.player.getInJail());
        this.player.setInJail(false);
        assertFalse("Test", this.player.getInJail());
    }

    @Test
    public void getBalance() {
        assertEquals(10, this.player.getBalance());
    }

    @Test
    public void getPosition() {
        assertTrue(this.player.getPosition() instanceof Tile);
    }

    @Test
    public void setPosition() {
    }

    @Test
    public void getOwnedTiles() {
        assertEquals(0, this.player.getOwnedTiles().size());
    }

    @Test
    public void setOwnedTiles() {

    }

    @Test
    public void getPiece() {
    }

    @Test
    public void setPiece() {
    }
}