public class Tax extends Tile{

    /**
     * fee: Int
     * The value of money the player needs to pay.
     */
    private int fee;

    /**
     * Tax
     * @param tileName
     * @param tilePosition
     * @param tileValue
     */
    public Tax(String tileName, int tilePosition, int tileValue) {
        super(tileName, tilePosition);
        this.fee = tileValue;
    }
    
}
