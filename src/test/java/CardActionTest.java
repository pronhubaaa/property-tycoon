import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardActionTest {

    private static final CardActionType TEST_INITIAL_CARDACTIONTYPE = CardActionType.TRANSACTION;
    private static final CardActionType TEST_SECOND_CARDACTIONTYPE = CardActionType.DRAW;
    private final static Object TEST_ACTION_MEMBER_OBJECT = new Object();
    private final static Payable TEST_ACTION_MEMBER_PAYABLE = amount -> {};
    private Player TEST_ACTION_MEMBER_PLAYER;
    private final static String TEST_CARD_ACTION_DESC = "test";

    private final static ArrayList<Payable> TEST_ACTION_MEMBER_ARRAYLIST = new ArrayList<Payable>() {{
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
        board = new Board(new JSONObject());
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
            add(new CardAction(CardActionType.GET_OUT_OF_JAIL_FREE, card, TEST_CARD_ACTION_DESC));
        }};
        card.setActions(actions);
        card.getActions().get(0).performAction(player);
        assertEquals(TEST_CARD_ACTION_DESC, player.getCards().get(0).getActions().get(0).getDescription());

        // ActionType.MOVE:
        // direct move

    }
}