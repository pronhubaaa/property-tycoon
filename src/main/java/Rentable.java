public abstract class Rentable extends Ownable {

    public Rentable(String name, int position, Group group) {
        super(name, position, group);
    }

    public boolean applyRentPayment(Player player) {
        return player.attemptDebit(calculateRent(player));
    }

    public abstract int calculateRent(Player player);
}
