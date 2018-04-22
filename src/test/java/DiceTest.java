import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    Dice dice;

    @Before
    public void setUp() throws Exception {
        this.dice = new Dice();
    }

    @After
    public void tearDown() throws Exception {
        this.dice = null;
    }

    @Test
    public void roll() {
        assertEquals(2, dice.roll().length);
        assertTrue(dice.roll() != null);
    }

    @Test
    public void getDoubleCount() {
        assertEquals(0, this.dice.getDoubleCount());
        int doubleRollCount = 0;
        for(int i = 0; i< 50; i++){
            int[] diceRoll = this.dice.roll();
            if(diceRoll[0] == diceRoll[1]){
                doubleRollCount++;
            }
        }
        assertEquals(doubleRollCount, this.dice.getDoubleCount());

        Dice dice2 = new Dice();
        assertEquals(0, dice2.getDoubleCount());

        int[] diceRoll2;
        do {
          diceRoll2 = dice2.roll();
        } while(diceRoll2[0] != diceRoll2[1]);

        assertEquals(1, dice2.getDoubleCount());

    }
}