public class Go extends Tile {

    /**
     * value: Int
     * The value of money given to a player for passing go.
     */
    private int value;

    public Go(String name, int position, int value){
        super(name, position);
        this.value = value;
    }

    /**
     * getValue(): Int
     * @return The value of money given to a player for passing go
     */
    public int getValue() {
        return value;
    }

    /**
     * setValue(Int): Void
     * @param value Value given for passing go
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * collect(): Void
     * This method gives a player their money for passing this tile.
     */
    public void collect() {
        // TODO
    }
}
