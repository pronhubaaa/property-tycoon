import java.util.ArrayList;

public abstract class VariablyTieredRentable extends Rentable {

    ArrayList<Integer> rent;

    public VariablyTieredRentable(String name, int position, Group group) {
        super(name, position, group);
        rent = new ArrayList<>();
    }

    public ArrayList<Integer> getRent() {
        return rent;
    }

    public void setRent(ArrayList<Integer> rent) {
        this.rent = rent;
    }
}
