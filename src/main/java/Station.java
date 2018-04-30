public class Station extends VariablyTieredRentable {

    public Station(String name, int position, Group group) {
        super(name, position, group);
    }

    @Override
    public int calculateRent(Player player, int diceValue) {
        return this.rent.get(getGroup().getAmountOwned(getOwner()) - 1);
    }

}
