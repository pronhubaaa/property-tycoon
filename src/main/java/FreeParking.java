public class FreeParking extends Tile {

    /**
     * freeMoney: Int
     * The amount of money on the free parking tile.
     */
    private int freeMoney;

    public FreeParking(String name, int position) {
        super(name, position);
        this.freeMoney = 0;
    }

    /**
     * getFreeMoney(): Int
     *
     * @return Amount of money on the free parking tile
     */
    public int getFreeMoney() {
        return freeMoney;
    }

    /**
     * addFreeMoney(Int): Void
     * Adds a given amount to the free parking tile.
     *
     * @param freeMoney Amount to add to free pakring tile
     */
    public void addFreeMoney(int freeMoney) {
        this.freeMoney += freeMoney;
    }

    /**
     * collect(): Void
     * Allows a player to collect the money on the tile for landing on it.
     */
    public void collect(Player player) {
        player.addBalance(freeMoney);
    }
}
