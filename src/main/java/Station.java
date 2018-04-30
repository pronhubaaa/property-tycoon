public class Station extends VariablyTieredRentable {

    public Station(String name, int position, Group group) {
        super(name, position, group);
    }

    @Override
    public int calculateRent(Player player) {
        return this.rent.get(getGroup().getAmountOwned(getOwner()) - 1);
    }

}
