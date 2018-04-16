import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AITest {

    AI ai;

    @Before
    public void setUp() throws Exception {
       this.ai = new AI(1500, "Liam", new Board(null));

    }

    @After
    public void tearDown() throws Exception {
        this.ai = null;
    }






    @Test
    public void buyTile(){

    }

    @Test
    public void buyHouses(){

    }

    @Test
    public void trader(){

    }

    @Test
    public void bid(){

    }

    @Test
    public void payBill(){

    }

    @Test
    public void findOwned(){

    }


}