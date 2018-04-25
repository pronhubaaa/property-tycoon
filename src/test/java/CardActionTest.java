import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CardActionTest {

    private static final CardActionType TEST_INITIAL_CARDACTIONTYPE = CardActionType.Transaction;
    private static final CardActionType TEST_SECOND_CARDACTIONTYPE = CardActionType.Draw;
    private static final Object TEST_ACTION_MEMBER_OBJECT = new Object();
    private static final Payable TEST_ACTION_MEMBER_PAYABLE = amount -> {};
    private Player TEST_ACTION_MEMBER_PLAYER;
    private static final String TEST_CARD_ACTION_DESC = "test";
    private static final int TEST_JSON_GO_SALARY = 200;

    private static final ArrayList<Payable> TEST_ACTION_MEMBER_ARRAYLIST = new ArrayList<Payable>() {{
        add(amount -> {});
        add(amount -> {});
        add(amount -> {});
    }};

    private Card card;
    private CardAction cardAction;
    private Board board;
    private Player player;

    @Before
    public void setUp() throws Exception {
        card = new Card();
        cardAction = new CardAction(TEST_INITIAL_CARDACTIONTYPE, card, "", TEST_ACTION_MEMBER_PAYABLE, TEST_ACTION_MEMBER_PAYABLE, 0);
        URL url = getClass().getResource("./resources/board.json");
        File file = new File(url.getPath());
        String myJson = new Scanner(file).useDelimiter("\\Z").next();
        JSONObject boardJson = (JSONObject) JSONObject.parse(myJson);
        board = new Board(boardJson);
        TEST_ACTION_MEMBER_PLAYER = new Player(0, "", board);
        player = new Player(0, "", board);
    }

    @After
    public void tearDown() throws Exception {
        cardAction = null;
    }

    @Test
    public void getCardActionType() {
        assertEquals(TEST_INITIAL_CARDACTIONTYPE, cardAction.getCardActionType());
    }

    @Test
    public void setCardActionType() {
        cardAction.setCardActionType(TEST_SECOND_CARDACTIONTYPE);
        assertEquals(TEST_SECOND_CARDACTIONTYPE, cardAction.getCardActionType());
    }

    @Test
    public void getOrigin() {
        assertTrue(cardAction.getOrigin() instanceof Payable);
    }

    @Test
    public void setOrigin() {
        cardAction.setOrigin(TEST_ACTION_MEMBER_PLAYER);
        assertTrue(cardAction.getOrigin() instanceof Player);
    }

    @Test
    public void getIntent() {
        assertTrue(cardAction.getIntent() instanceof Payable);
    }

    @Test
    public void setIntent() {
        cardAction.setIntent(TEST_ACTION_MEMBER_PLAYER);
        assertTrue(cardAction.getIntent() instanceof Player);
    }

    @Test
    public void getValue() {
    }

    @Test
    public void setValue() {
    }

    @Test
    public void getAmountPerHouse() {
    }

    @Test
    public void setAmountPerHouse() {
    }

    @Test
    public void getAmountPerHotel() {
    }

    @Test
    public void setAmountPerHotel() {
    }

    @Test
    public void isCollectSalaryAtGo() {
    }

    @Test
    public void setCollectSalaryAtGo() {
    }

    @Test
    public void getCard() {
    }

    @Test
    public void setCard() {
    }

    @Test
    public void performAction() throws MalformedCardActionException, BoardTileException {
        // ActionType.DRAW:

        // ActionType.GET_OUT_OF_JAIL_FREE:
        ArrayList<CardAction> actions = new ArrayList<CardAction>() {{
            add(new CardAction(CardActionType.GetOutOfJailFree, card, TEST_CARD_ACTION_DESC));
        }};
        card.setActions(actions);
        card.getActions().get(0).performAction(player);
        assertEquals(TEST_CARD_ACTION_DESC, player.getCards().get(0).getActions().get(0).getDescription());

        // ActionType.MOVE:
        ArrayList<Tile> tiles = board.getTiles();
        CardAction action = new CardAction(CardActionType.Move, card, TEST_CARD_ACTION_DESC, null, tiles.get(1), 1);
        action.setCollectSalaryAtGo(true);
        // move to tile 1, collect salary
        testOverGo(tiles, player, action, TEST_JSON_GO_SALARY);
        // move 2 tiles forward, collect salary
        action.setIntent(2);
        testOverGo(tiles, player, action, TEST_JSON_GO_SALARY);
        // move 2 tiles forward, no salary
        action.setCollectSalaryAtGo(false);
        testOverGo(tiles, player, action, 0);
        // move to tile 3, no salary
        action.setIntent(tiles.get(3));
        testOverGo(tiles, player, action, 0);
        // move 2 tiles backward
        action.setIntent(-2);
        player.setPosition(tiles.get(1));
        action.performAction(player);
        assertEquals(tiles.size() - 1, player.getPosition().getPosition());

        // ActionType.TRANSACTION:
    }

    private static void testOverGo(ArrayList<Tile> tiles, Player player, CardAction action, int goSalary) throws MalformedCardActionException {
        player.setPosition(tiles.get(tiles.size() - 1));
        int preTestBalance = player.getBalance();
        action.performAction(player);
        if (action.getIntent() instanceof Tile) {
            //noinspection SuspiciousMethodCalls
            assertEquals(tiles.indexOf(action.getIntent()), tiles.indexOf(player.getPosition()));
        } else {
            assertEquals(((int) action.getIntent()) - 1, tiles.indexOf(player.getPosition()));
        }
        assertEquals(preTestBalance + goSalary, player.getBalance());
    }
}