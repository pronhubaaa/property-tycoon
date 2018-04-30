public class Utility extends Ownable {

    public Utility(String name, int position, Group group) {
        super(name, position, group);
    }

    @Override
    public int calculateRent(Player player, int diceValue) {
        if (getGroup().isGroupAllOwned(player)) {
            return diceValue * 10;
        } else {
            return diceValue * 4;
        }
    }
}
