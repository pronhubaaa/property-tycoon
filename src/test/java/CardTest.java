import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardTest {

    private static final String TEST_INITIAL_CARD_ACTION_DESC = "initial";
    private static final String TEST_SECOND_CARD_ACTION_DESC = "second";
    private static final CardType TEST_INITIAL_CARD_TYPE = CardType.PotLuck;
    private static final CardType TEST_SECOND_CARD_TYPE = CardType.OpportunityKnocks;

    private CardStack secondCardStack;
    private Card card;
    private CardAction initialAction;
    private CardAction secondAction;

    @Before
    public void setUp() throws Exception {
        CardStack initialCardStack = new CardStack(TEST_INITIAL_CARD_TYPE);
        secondCardStack = new CardStack(TEST_SECOND_CARD_TYPE);
        card = new Card();
        initialAction = new CardAction(CardActionType.DRAW, card, TEST_INITIAL_CARD_ACTION_DESC);
        secondAction = new CardAction(CardActionType.DRAW, card, TEST_SECOND_CARD_ACTION_DESC);
    }

    @After
    public void tearDown() throws Exception {
        card = null;
    }

    @Test
    public void getActions() {
        card.addAction(initialAction);
        assertEquals(TEST_INITIAL_CARD_ACTION_DESC, card.getActions().get(0).toString());
    }

    @Test
    public void setActions() {
        ArrayList<CardAction> actions = new ArrayList<>();
        actions.add(initialAction);
        actions.add(secondAction);
        card.setActions(actions);
        assertEquals(2, card.getActions().size());
        assertEquals(TEST_SECOND_CARD_ACTION_DESC, card.getActions().get(1).toString());
    }

    @Test
    public void addAction() {
        card.addAction(secondAction);
        assertEquals(TEST_SECOND_CARD_ACTION_DESC, card.getActions().get(0).toString());
    }
}