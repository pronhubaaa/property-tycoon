public class GoToJail extends Tile {

    public GoToJail(String name, int position) {
        super(name, position);
    }

    /**
     * sendToJail(Player): Void
     * This method allows a player to be moved to jail.
     *
     * @param player The player you want to move to jail
     */
    public void sendToJail(Player player) {
        player.setInJail(true);
    }
}
