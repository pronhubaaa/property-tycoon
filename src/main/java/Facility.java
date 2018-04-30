public abstract class Facility extends Ownable {


    public Facility(String name, int position, Group group) {
        super(name, position, group);
    }

    public abstract void calculateRent();
}
