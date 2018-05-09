public class FreeParking extends IncomeTile implements Payable {

    private final static int FREE_PARKING_RESET_VALUE = 0;

    public FreeParking(String name, int position) {
        super(name, position, FREE_PARKING_RESET_VALUE);
    }

    @Override
    public void collect(Player player) {
        player.addBalance(getValue());
        setValue(FREE_PARKING_RESET_VALUE);
    }

    @Override
    public void addBalance(int amount) {
        addValue(amount);
    }
}
