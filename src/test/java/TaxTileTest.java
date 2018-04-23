import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxTileTest {

    private static final int TEST_INITIAL_TAX_AMOUNT = 100;
    private static final int TEST_SECOND_TAX_AMOUNT = 200;

    private TaxTile taxTile;
    private Player player;

    @Before
    public void setUp() throws Exception {
        taxTile = new TaxTile("", 0, TEST_INITIAL_TAX_AMOUNT);
        Board board = new Board(new JSONObject());
        player = new Player(TEST_SECOND_TAX_AMOUNT, "", board);
    }

    @Test
    public void getAmount() {
        assertEquals(TEST_INITIAL_TAX_AMOUNT, taxTile.getAmount());
    }

    @Test
    public void setAmount() {
        taxTile.setAmount(TEST_SECOND_TAX_AMOUNT);
        assertEquals(TEST_SECOND_TAX_AMOUNT, taxTile.getAmount());
    }

    @Test
    public void payTax() {
        int preTestBalance = player.getBalance();
        taxTile.payTax(player);
        assertEquals(preTestBalance - taxTile.getAmount(), player.getBalance());
    }
}