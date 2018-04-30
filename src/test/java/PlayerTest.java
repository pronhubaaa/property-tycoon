import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    private static final int TEST_PLAYER_INITIAL_BALANCE = 10;

    Player player;

    @Before
    public void setUp() throws Exception {
        this.player = new Player(TEST_PLAYER_INITIAL_BALANCE, "Peter", null);

    }

    @After
    public void tearDown() throws Exception {
        this.player = null;
    }

    @Test
    public void buyTile() {
        Tile tile = new Go("", 0, 0);
        assertFalse(this.player.buyTile(tile));
        assertEquals(this.player.getBalance(), TEST_PLAYER_INITIAL_BALANCE);

        tile = new Property("", 0, null);
        ((Property) tile).setPrice(100);
        assertFalse(this.player.buyTile(tile));
        assertEquals(this.player.getBalance(), TEST_PLAYER_INITIAL_BALANCE);

        this.player.setBalance(100);
        assertEquals(this.player.getBalance(), 100);
        assertTrue(this.player.buyTile(tile));
        assertTrue(((Property) tile).isOwned());
        assertEquals(this.player, ((Property) tile).getOwner());
        assertEquals(this.player.getBalance(), 0);

        assertFalse(this.player.buyTile(tile));
        assertEquals(this.player.getBalance(), 0);

    }

    @Test
    public void sellTile() {

        Tile tile = new Property("", 0, null);
        ((Property) tile).setPrice(100);
        ((Ownable) tile).setSellPrice(25);
        this.player.setBalance(100);
        assertEquals(100, this.player.getBalance());
        assertTrue(this.player.buyTile(tile));
        assertEquals(0, this.player.getBalance());

        this.player.sellTile(tile);
        assertEquals(25, this.player.getBalance());
        assertNull(((Property) tile).getOwner());
        assertFalse(((Property) tile).isOwned());


    }

    @Test
    public void isBankrupt() {
        this.player.setBalance(100);
        assertFalse(this.player.isBankrupt());
        this.player.setBalance(0);
        assertTrue(this.player.isBankrupt());

    }

    @Test
    public void mortgageTile() {
        Tile tile = new Property("", 0, null);
        ((Property) tile).setPrice(100);
        ((Ownable) tile).setSellPrice(25);
        ((Property) tile).setMortgagePrice(50);
        this.player.setBalance(100);
        assertEquals(100, this.player.getBalance());
        assertTrue(this.player.buyTile(tile));
        assertEquals(0, this.player.getBalance());
        assertFalse(((Property) tile).isMortgaged());


        assertTrue(this.player.mortgageTile(tile));
        assertTrue(((Property) tile).isMortgaged());
        assertEquals(50, this.player.getBalance());
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
        assertEquals(TEST_PLAYER_INITIAL_BALANCE, this.player.getBalance());
    }


    @Test
    public void setPosition() {

        Tile tile = new Tile("", 0);
        Tile tile2 = new Tile("", 1);


        this.player.setPosition(tile);
        assertEquals(tile, this.player.getPosition());

        this.player.setPosition(tile2);
        assertEquals(tile2, this.player.getPosition());

    }

    @Test
    public void getOwnedTiles() {
        assertEquals(0, this.player.getOwnedTiles().size());

    }

    @Test
    public void setOwnedTiles() {
        assertEquals(0, this.player.getOwnedTiles().size());
        Ownable ownable = new Utility("", 0, null);

        this.player.addOwnable(ownable);

        assertEquals(1, this.player.getOwnedTiles().size());

        ArrayList<Ownable> ownables = new ArrayList<>();
        ownables.add(ownable);
        assertEquals(ownables, this.player.getOwnedTiles());


    }


    @Test
    public void setPiece() {
        PlayerPiece piece = PlayerPiece.Car;
        this.player.setPiece(piece);
        assertEquals(piece, this.player.getPiece());
    }

    @Test
    public void attemptDebit() {
        // Failing payment
        assertFalse(player.attemptDebit(TEST_PLAYER_INITIAL_BALANCE + 1));
        assertEquals(TEST_PLAYER_INITIAL_BALANCE, player.getBalance());

        // Payment should succeed
        assertTrue(player.attemptDebit(TEST_PLAYER_INITIAL_BALANCE));
        assertEquals(0, player.getBalance());
    }

}