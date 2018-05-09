import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTileTest {

    private static final CardType TEST_INITIAL_CARDTYPE = CardType.PotLuck;
    private static final CardType TEST_SECOND_CARDTYPE = CardType.OpportunityKnocks;

    private CardTile cardTile;

    @Before
    public void setUp() throws Exception {
        cardTile = new CardTile("", 0, new CardStack(TEST_INITIAL_CARDTYPE));
    }

    @After
    public void tearDown() throws Exception {
        cardTile = null;
    }

    @Test
    public void getCardStack() {
        assertEquals(TEST_INITIAL_CARDTYPE, cardTile.getCardStack().getCardType());
    }

    @Test
    public void setCardStack() {
        cardTile.setCardStack(new CardStack(TEST_SECOND_CARDTYPE));
        assertEquals(TEST_SECOND_CARDTYPE, cardTile.getCardStack().getCardType());
    }
}