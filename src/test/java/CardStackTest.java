import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardStackTest {

    private static final CardType TEST_INITIAL_CARD_TYPE = CardType.PotLuck;
    private static final CardType TEST_SECOND_CARD_TYPE = CardType.OpportunityKnocks;
    private static final int TEST_AMOUNT_CARDS = 10;
    private static final int TEST_SHUFFLE_ITERATIONS = 10;

    private CardStack cardStack;

    @Before
    public void setUp() throws Exception {
        cardStack = new CardStack(TEST_INITIAL_CARD_TYPE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCardType() {
        assertEquals(TEST_INITIAL_CARD_TYPE, cardStack.getCardType());
    }

    @Test
    public void setCardType() {
        cardStack.setCardType(TEST_SECOND_CARD_TYPE);
        assertEquals(TEST_SECOND_CARD_TYPE, cardStack.getCardType());
    }

    @Test
    public void shuffle() {
        for (int i = 0; i < TEST_AMOUNT_CARDS; i++) {
            Card card = new Card();
            CardAction action = new CardAction(CardActionType.Draw, card, Integer.toString(i));
            card.add(action);
            cardStack.add(card);
        }
        int i = 0;
        assert cardStack.peek() != null;
        while (cardStack.peek().get(0).toString().equals("0") && i < TEST_SHUFFLE_ITERATIONS) {
            cardStack.shuffle();
            i++;
        }
        assertNotEquals(TEST_SHUFFLE_ITERATIONS, i);
    }
}