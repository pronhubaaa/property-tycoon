public class Utility extends Rentable {

    public Utility(String name, int position, Group group) {
        super(name, position, group);
    }

    @Override
    public int calculateRent(Player player) {
        if (getGroup().isGroupAllOwned(player)) {
            // TODO return 10x dice value
        } else {
            // TODO return 4x dice value
        }
        return 0;
    }
}
