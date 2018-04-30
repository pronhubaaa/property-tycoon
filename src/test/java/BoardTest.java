import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {


        URL url = getClass().getResource("./resources/board.json");
        File file = new File(url.getPath());

        String myJson = new Scanner(file).useDelimiter("\\Z").next();


        JSONObject board = (JSONObject) JSONObject.parse(myJson);
        this.board = new Board(board);
    }

    @After
    public void tearDown() throws Exception {
        this.board = null;
    }

    @Test
    public void getTiles() throws Exception {
        this.board = new Board(new JSONObject());
        Tile tile = new Tile("", 0);
        this.board.addTile(tile);

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        assertEquals(tiles, this.board.getTiles());
    }

    @Test
    public void addTiles() throws Exception {
        this.board = new Board(new JSONObject());
        Tile tile = new Tile("", 0);
        Tile tile2 = new Tile("", 1);

        this.board.addTile(tile);
        this.board.addTile(tile2);

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile);
        tiles.add(tile2);
        assertEquals(tiles, this.board.getTiles());
    }

    @Test
    public void constructor() {
        assertEquals(40, this.board.getTiles().size());
    }

}