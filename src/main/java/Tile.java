public class Tile {

    private String name;
    private int position;


    public Tile(String name, int position){

    }

    /**
     * getName(): String
     * @return The name of the tile
     */
    public String getName() {
        return name;
    }

    /**
     * setName(String): Void
     * @param name String name of the tile
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getPosition(): Int
     * An integer showing where this tile is located on the board.
     * @return The numerical position on the board this tile is in
     */
    public int getPosition() {
        return position;
    }

    /**
     * setPosition(Int): Void
     * This allows the tile to be allocated a place on the board.
     * @param position Integer position of the tile on the board
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
