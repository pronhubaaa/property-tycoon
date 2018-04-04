public class Jail extends Tile {

    /**
     * The price it costs to get out of jail.
     */
    private int fee;

    public Jail(String name, int position){
        super(name, position);
    }

    /**
     * getFee(): Int
     * @return Returns the fee to get out of jail.
     */
    public int getFee() {
        return fee;
    }

    /**
     * setFee(Int): Void
     * Set the amount of money it costs to get out of jail.
     * @param fee Assign the amount of money it costs to get out of jail
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * freeFromJail(Player): Void
     * Allows a player to move out of jail.
     * @param player The player you want to move to "Just visiting"
     */
    public void freeFromJail(Player player) {
        player.setInJail(false);
    }
}
