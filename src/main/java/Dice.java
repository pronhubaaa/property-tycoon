import java.util.Random;

/**
 * The dice class is for when dice are rolled and counting doubles
 */
public class Dice {

    /**
     * doubleCount: Int
     * This integer value counts the amount of doubles a player rolls in a row.
     */
    private int doubleCount;

    /**
     * roll
     * @return An array of integers
     * This method returns the two values between 1 and 6 shown on the two dice. The function will also add to doubleCount where appropriate.
     */
    public int[] roll(){
        Random rand = new Random();
        int[] values = new int[2];
        values[0] = rand.nextInt(6) + 1;
        values[1] = rand.nextInt(6) + 1;
        if (values[0] == values[1]){
            this.doubleCount++;
        }
        return values;

    }

    /**
     * getDoubleCount
     * @return Number of times a double has rolled
     * This method returns the number of times a double has been rolled.
     */
    public int getDoubleCount() {
        return this.doubleCount;
    }

}
