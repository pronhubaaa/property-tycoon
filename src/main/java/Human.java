/**
 * This class is empty as it inherits all classes and attributes of the Player class, and requires no further information.
 */
public class Human extends Player {

    public Human(int balance, String name){
        super(balance, name,  new Board(null));
    }
}
