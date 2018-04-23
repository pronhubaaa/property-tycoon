import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TradeTest {

    Trade trade;
    Player player1;
    Player player2;


    @Before
    public void setUp() throws Exception {
        this.player1 = new Player(10, "Peter", null);
        this.player2 = new Player(10, "Peter", null);
        this.trade = new Trade(player1, player2);
    }

    @After
    public void tearDown() throws Exception {
        this.player1 = null;
        this.player2 = null;
        this.trade = null;
    }

    @Test
    public void addOwnable() {

        Ownable tile = new Ownable("", 0, null);


        ArrayList<Ownable> ownables = new ArrayList<>();

        assertEquals(ownables, trade.getOwnable(player1));

        ownables.add(tile);
        trade.addOwnable(player1, tile);

        assertEquals(ownables, trade.getOwnable(player1));

    }

    @Test
    public void acceptTrade() {
        assertTrue(this.trade.acceptTrade(true, true));
        assertFalse(this.trade.acceptTrade(false, true));
        assertFalse(this.trade.acceptTrade(false, false));
        assertFalse(this.trade.acceptTrade(true, false));
    }
}