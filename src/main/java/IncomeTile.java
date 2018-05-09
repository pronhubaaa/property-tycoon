public abstract class IncomeTile extends Tile {

    /**
     * value: Int
     * The value of money given to a player for passing go.
     */
    private int value;

    /**
     * IncomeTiles provide a set amount to a Player when their collect() method is called.
     *
     * @param name
     * @param position
     * @param value
     */
    public IncomeTile(String name, int position, int value) {
        super(name, position);
        this.value = value;
    }

    /**
     * getValue(): Int
     *
     * @return The value of money given to a player for activating the tile
     */
    public int getValue() {
        return value;
    }

    /**
     * setValue(Int): Void
     *
     * @param value Value given for activating the tile
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * addValue(Int): Void
     *
     * @param value Amount to be added to the tile's value
     */
    public void addValue(int value) {
        setValue(getValue() + value);
    }

    /**
     * collect(): Void
     * This method gives a player their money for passing this tile.
     */
    public void collect(Player player) {
        player.addBalance(value);
    }
}
