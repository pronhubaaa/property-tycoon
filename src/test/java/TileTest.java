import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    private final static String TEST_TILE_NAME = "test";
    private final static String TEST_TILE_SETNAME_VALUE = "setName";
    private final static int TEST_TILE_POSITION = 5;
    private final static int TEST_TILE_SETPOSITION_VALUE = 6;
    private Tile tile;

    @Before
    public void setUp() throws Exception {
        tile = new Tile(TEST_TILE_NAME, 5);
    }

    @Test
    public void getName() {
        assertEquals(TEST_TILE_NAME, tile.getName());
    }

    @Test
    public void setName() {
        tile.setName(TEST_TILE_SETNAME_VALUE);
        assertEquals(TEST_TILE_SETNAME_VALUE, tile.getName());
    }

    @Test
    public void getPosition() {
        assertEquals(TEST_TILE_POSITION, tile.getPosition());
    }

    @Test
    public void setPosition() {
        tile.setPosition(TEST_TILE_SETPOSITION_VALUE);
        assertEquals(TEST_TILE_SETPOSITION_VALUE, tile.getPosition());
    }

    @Test
    public void equality() {
        Tile equalityTestTile = new Tile(TEST_TILE_SETNAME_VALUE, TEST_TILE_SETPOSITION_VALUE);
        assertNotEquals(equalityTestTile, tile);
        equalityTestTile.setName(TEST_TILE_NAME);
        assertEquals(equalityTestTile, tile);
    }

}
