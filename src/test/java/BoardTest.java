import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() throws Exception {

        JSONObject board = (JSONObject) JSONObject.parse("{\n" +
                "\t\"tile\":\n" +
                "\t[\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"FreeParking\",\n" +
                "\t\t\t\"position\": \"1\",\n" +
                "\t\t\t\"name\": \"FreeParking\",\n" +
                "\t\t\t\"ownable\": \"true\",\n" +
                "\t\t\t\"property_group\": \"green\",\n" +
                "\t\t\t\"action\": {\n" +
                "\t\t\t\t\"action\": \"receive\",\n" +
                "\t\t\t\t\"value\": \"200\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"cost\": \"200\",\n" +
                "\t\t\t\"rent\": \"20\",\n" +
                "\t\t\t\"houses\": [\"10\", \"30\", \"90\", \"120\", \"200\"]\n" +
                "\n" +
                "\t\t}\n" +
                "\t]\n" +
                "\n" +
                "}");
        this.board = new Board(board);
    }

    @After
    public void tearDown() throws Exception {
    }
/*
    @Test
    public void getTiles() {
    }

    @Test
    public void reorderCards() {
    }*/
}