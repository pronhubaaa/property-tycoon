public class Utility extends Ownable {

    private static final int RENT_SOME_UTILITIES_OWNED_FACTOR = 4;
    private static final int RENT_ALL_UTILITIES_OWNED_FACTOR = 10;

    public Utility(String name, int position, Group group) {
        super(name, position, group);
    }

    @Override
    public int calculateRent(Player player, int diceValue) {
        if (getGroup().isGroupAllOwned(player)) {
            return diceValue * RENT_ALL_UTILITIES_OWNED_FACTOR;
        } else {
            return diceValue * RENT_SOME_UTILITIES_OWNED_FACTOR;
        }
    }

    public int getSomeOwned() {
        return RENT_SOME_UTILITIES_OWNED_FACTOR;
    }

    public int getAllOwned() {
        return RENT_ALL_UTILITIES_OWNED_FACTOR;
    }
}
