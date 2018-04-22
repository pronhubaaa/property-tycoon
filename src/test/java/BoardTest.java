import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() throws Exception {

        JSONObject board = (JSONObject) JSONObject.parse("{\n" +
                "\t\"tile\":\n" +
                "\t[\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Go\",\n" +
                "\t\t\t\"position\": \"1\",\n" +
                "\t\t\t\"name\": \"Go\",\n" +
                "\t\t\t\"ownable\": \"false\",\n" +
                "\t\t\t\"action\": {\n" +
                "\t\t\t\t\"action\": \"collect\",\n" +
                "\t\t\t\t\"value\": \"200\"\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"2\",\n" +
                "\t\t\t\"name\": \"Crapper Street\",\n" +
                "\t\t\t\"group\": \"Brown\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"60\",\n" +
                "\t\t\t\"rent\": \"2\",\n" +
                "\t\t\t\"houses\": [\"10\", \"30\", \"90\", \"160\", \"250\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"3\",\n" +
                "\t\t\t\"name\": \"Plot Luck\",\n" +
                "\t\t\t\"cardType\": \"PlotLuck\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"4\",\n" +
                "\t\t\t\"name\": \"Gangsters Paradise\",\n" +
                "\t\t\t\"group\": \"Brown\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"60\",\n" +
                "\t\t\t\"rent\": \"4\",\n" +
                "\t\t\t\"houses\": [\"20\", \"60\", \"180\", \"320\", \"450\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Tax\",\n" +
                "\t\t\t\"position\": \"5\",\n" +
                "\t\t\t\"name\": \"Income Tax\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Station\",\n" +
                "\t\t\t\"position\": \"6\",\n" +
                "\t\t\t\"name\": \"Brighton Station\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": [\"25\",\"50\",\"100\",\"200\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"7\",\n" +
                "\t\t\t\"name\": \"Weeping Angel\",\n" +
                "\t\t\t\"group\": \"Blue\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"100\",\n" +
                "\t\t\t\"rent\": \"6\",\n" +
                "\t\t\t\"houses\": [\"30\", \"90\", \"270\", \"400\", \"550\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"8\",\n" +
                "\t\t\t\"name\": \"Opportunity Knocks\",\n" +
                "\t\t\t\"cardType\": \"OpportunityKnocks\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"9\",\n" +
                "\t\t\t\"name\": \"Potts Avenue\",\n" +
                "\t\t\t\"group\": \"Blue\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"100\",\n" +
                "\t\t\t\"rent\": \"6\",\n" +
                "\t\t\t\"houses\": [\"30\", \"90\", \"270\", \"400\", \"550\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"10\",\n" +
                "\t\t\t\"name\": \"Nardole Drive\",\n" +
                "\t\t\t\"group\": \"Blue\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"120\",\n" +
                "\t\t\t\"rent\": \"8\",\n" +
                "\t\t\t\"houses\": [\"40\", \"100\", \"300\", \"450\", \"600\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Jail\",\n" +
                "\t\t\t\"position\": \"11\",\n" +
                "\t\t\t\"name\": \"Jail / Just visiting\",\n" +
                "\t\t\t\"ownable\": \"false\",\n" +
                "\t\t\t\"fee\": \"120\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"12\",\n" +
                "\t\t\t\"name\": \"Skywalker Drive\",\n" +
                "\t\t\t\"group\": \"Purple\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"140\",\n" +
                "\t\t\t\"rent\": \"10\",\n" +
                "\t\t\t\"houses\": [\"50\", \"150\", \"450\", \"625\", \"750\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Utility\",\n" +
                "\t\t\t\"position\": \"13\",\n" +
                "\t\t\t\"name\": \"Tesla Power Co\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"150\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"14\",\n" +
                "\t\t\t\"name\": \"Wookie Hole\",\n" +
                "\t\t\t\"group\": \"Purple\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"140\",\n" +
                "\t\t\t\"rent\": \"10\",\n" +
                "\t\t\t\"houses\": [\"50\", \"150\", \"450\", \"625\", \"750\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"15\",\n" +
                "\t\t\t\"name\": \"Rey Lane\",\n" +
                "\t\t\t\"group\": \"Purple\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"160\",\n" +
                "\t\t\t\"rent\": \"12\",\n" +
                "\t\t\t\"houses\": [\"60\", \"180\", \"500\", \"700\", \"900\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Station\",\n" +
                "\t\t\t\"position\": \"16\",\n" +
                "\t\t\t\"name\": \"Hove Station\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": [\"25\",\"50\",\"100\",\"200\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"17\",\n" +
                "\t\t\t\"name\": \"Cooper Drive\",\n" +
                "\t\t\t\"group\": \"Orange\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"180\",\n" +
                "\t\t\t\"rent\": \"14\",\n" +
                "\t\t\t\"houses\": [\"70\", \"200\", \"550\", \"750\", \"950\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"18\",\n" +
                "\t\t\t\"name\": \"Plot Luck\",\n" +
                "\t\t\t\"cardType\": \"PlotLuck\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"19\",\n" +
                "\t\t\t\"name\": \"Wolowitz Street\",\n" +
                "\t\t\t\"group\": \"Orange\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"180\",\n" +
                "\t\t\t\"rent\": \"14\",\n" +
                "\t\t\t\"houses\": [\"70\", \"200\", \"550\", \"750\", \"950\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"20\",\n" +
                "\t\t\t\"name\": \"Penny Lane\",\n" +
                "\t\t\t\"group\": \"Orange\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": \"16\",\n" +
                "\t\t\t\"houses\": [\"80\", \"220\", \"600\", \"800\", \"1000\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"FreeParking\",\n" +
                "\t\t\t\"position\": \"21\",\n" +
                "\t\t\t\"name\": \"Free Parking\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"22\",\n" +
                "\t\t\t\"name\": \"Yue Fei Square\",\n" +
                "\t\t\t\"group\": \"Red\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"220\",\n" +
                "\t\t\t\"rent\": \"18\",\n" +
                "\t\t\t\"houses\": [\"90\", \"250\", \"700\", \"875\", \"1050\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"23\",\n" +
                "\t\t\t\"name\": \"Opportunity Knocks\",\n" +
                "\t\t\t\"cardType\": \"OpportunityKnocks\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"24\",\n" +
                "\t\t\t\"name\": \"Mulan Rouge\",\n" +
                "\t\t\t\"group\": \"Red\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"220\",\n" +
                "\t\t\t\"rent\": \"18\",\n" +
                "\t\t\t\"houses\": [\"90\", \"250\", \"700\", \"875\", \"1050\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"25\",\n" +
                "\t\t\t\"name\": \"Han Xin Gardens\",\n" +
                "\t\t\t\"group\": \"Red\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"240\",\n" +
                "\t\t\t\"rent\": \"20\",\n" +
                "\t\t\t\"houses\": [\"100\", \"300\", \"750\", \"925\", \"1100\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Station\",\n" +
                "\t\t\t\"position\": \"26\",\n" +
                "\t\t\t\"name\": \"Falmer Station\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": [\"25\",\"50\",\"100\",\"200\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"27\",\n" +
                "\t\t\t\"name\": \"Kirk Close\",\n" +
                "\t\t\t\"group\": \"Yellow\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"260\",\n" +
                "\t\t\t\"rent\": \"22\",\n" +
                "\t\t\t\"houses\": [\"110\", \"330\", \"800\", \"975\", \"1150\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"28\",\n" +
                "\t\t\t\"name\": \"Picard Avenue\",\n" +
                "\t\t\t\"group\": \"Yellow\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"260\",\n" +
                "\t\t\t\"rent\": \"22\",\n" +
                "\t\t\t\"houses\": [\"110\", \"330\", \"800\", \"975\", \"1150\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Utility\",\n" +
                "\t\t\t\"position\": \"29\",\n" +
                "\t\t\t\"name\": \"Edison Water\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"150\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"30\",\n" +
                "\t\t\t\"name\": \"Crusher Creek\",\n" +
                "\t\t\t\"group\": \"Yellow\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"280\",\n" +
                "\t\t\t\"rent\": \"22\",\n" +
                "\t\t\t\"houses\": [\"120\", \"360\", \"850\", \"1025\", \"1200\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"GoToJail\",\n" +
                "\t\t\t\"position\": \"31\",\n" +
                "\t\t\t\"name\": \"Go to Jail\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"32\",\n" +
                "\t\t\t\"name\": \"Sirat Mews\",\n" +
                "\t\t\t\"group\": \"Green\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"300\",\n" +
                "\t\t\t\"rent\": \"26\",\n" +
                "\t\t\t\"houses\": [\"130\", \"390\", \"900\", \"1100\", \"1275\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"33\",\n" +
                "\t\t\t\"name\": \"Ghengis Crescent\",\n" +
                "\t\t\t\"group\": \"Green\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"300\",\n" +
                "\t\t\t\"rent\": \"26\",\n" +
                "\t\t\t\"houses\": [\"130\", \"390\", \"900\", \"1100\", \"1275\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"34\",\n" +
                "\t\t\t\"name\": \"Plot Luck\",\n" +
                "\t\t\t\"cardType\": \"PlotLuck\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"35\",\n" +
                "\t\t\t\"name\": \"Ibis Close\",\n" +
                "\t\t\t\"group\": \"Green\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"320\",\n" +
                "\t\t\t\"rent\": \"28\",\n" +
                "\t\t\t\"houses\": [\"150\", \"450\", \"1000\", \"1200\", \"1400\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Station\",\n" +
                "\t\t\t\"position\": \"36\",\n" +
                "\t\t\t\"name\": \"Lewes Station\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": [\"25\",\"50\",\"100\",\"200\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Card\",\n" +
                "\t\t\t\"position\" : \"37\",\n" +
                "\t\t\t\"name\": \"Opportunity Knocks\",\n" +
                "\t\t\t\"cardType\": \"OpportunityKnocks\",\n" +
                "\t\t\t\"ownable\": \"false\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"38\",\n" +
                "\t\t\t\"name\": \"Hawking Way\",\n" +
                "\t\t\t\"group\": \"Deep Blue\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"350\",\n" +
                "\t\t\t\"rent\": \"35\",\n" +
                "\t\t\t\"houses\": [\"175\", \"500\", \"1100\", \"1300\", \"1500\"]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Tax\",\n" +
                "\t\t\t\"position\" : \"39\",\n" +
                "\t\t\t\"name\": \"Super Tax\",\n" +
                "\t\t\t\"ownable\": \"false\",\n" +
                "\t\t\t\"action\": {\n" +
                "\t\t\t\t\"action\": \"pay\",\n" +
                "\t\t\t\t\"value\": \"100\"\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"Property\",\n" +
                "\t\t\t\"position\": \"40\",\n" +
                "\t\t\t\"name\": \"Turning Heights\",\n" +
                "\t\t\t\"group\": \"Deep Blue\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"cost\": \"400\",\n" +
                "\t\t\t\"rent\": \"50\",\n" +
                "\t\t\t\"houses\": [\"200\", \"600\", \"1400\", \"1700\", \"2000\"]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}");
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
        System.out.println(this.board.getTiles());
        assertEquals(40, this.board.getTiles().size());
    }

    @Test
    public void getPropertyGroups() throws Exception{

        this.board = new Board(new JSONObject());
        HashMap<String, PropertyGroup> propertyGroups = new HashMap<>();

        assertEquals(propertyGroups, this.board.getPropertyGroups());

    }

    @Test
    public void setPropertyGroups() throws Exception {
        this.board = new Board(new JSONObject());
        HashMap<String, PropertyGroup> propertyGroups = new HashMap<>();
        propertyGroups.put("Blue", new PropertyGroup());

        this.board.setPropertyGroups(propertyGroups);

        assertEquals(propertyGroups, this.board.getPropertyGroups());
    }

    @Test
    public void getStationGroups() throws Exception {
        this.board = new Board(new JSONObject());
        HashMap<String, StationGroup> stationGroups = new HashMap<>();

        assertEquals(stationGroups, this.board.getStationGroups());
    }

    @Test
    public void setStationGroups() throws Exception {
        this.board = new Board(new JSONObject());
        HashMap<String, StationGroup> stationGroups = new HashMap<>();
        stationGroups.put("Blue", new StationGroup());

        this.board.setStationGroups(stationGroups);

        assertEquals(stationGroups, this.board.getStationGroups());
    }

    @Test
    public void getUtilityGroups() throws Exception {
        this.board = new Board(new JSONObject());
        HashMap<String, UtilityGroup> utilityGroups = new HashMap<>();

        assertEquals(utilityGroups, this.board.getUtilityGroups());
    }

    @Test
    public void setUtilityGroups() throws Exception {
        this.board = new Board(new JSONObject());
        HashMap<String, UtilityGroup> utilityGroups = new HashMap<>();
        utilityGroups.put("Blue", new UtilityGroup());

        this.board.setUtilityGroups(utilityGroups);

        assertEquals(utilityGroups, this.board.getUtilityGroups());
    }


}