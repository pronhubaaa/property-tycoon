/**
 * This class is used to create an artificial player.
 */

import java.util.ArrayList;



public class AI extends Player {

    public AI(int balance, String name, Board board){
        super(balance, name, board);

    }

    @Override
    public boolean buyTile(Ownable tile, int cost){


        //If a player owns more than 1 in the set
        if (this.getBoard().getPlayerOwned(tile) > 1 && this.getBalance() > cost) {
            return true;
        }
        //If a player owns 1 of two tiles
        else if (this.getBoard().getPlayerOwned(tile) > 0 && && this.getBalance() > cost && this.getBoard().groupSize(tile)  == 2){
            return true;
        }
        //If another player owns a tile in the same group
        else if (this.getBoard().getPlayerOwned(tile) > 0 && this.getBalance() > cost) {
            int random = Math.random();
            if (random > 0.25) {
                return true;
            } else return false;

        }
        //If this player owns a tile in the same group
        else if (findOwned() == true && this.getBalance() > cost){
            return true;
        }
        //If no other tiles in the group are owned
        else {
            int random = Math.random();
            if (random > 0.5) {
                return true;
            } else {
                return false;
            }
        }

    }

    public void buyHouses(void){

        //Get array list of all streets that are owned
        ArrayList<Property> ownedStreets = new ArrayList<Property>();
        ownedStreets = streetOwned();

        //When a street is owned
        if (!ownedStreets.isEmpty()){
            // for each in the street
            for (Property current: ownedStreets) {
                // if house price is less than half the players balance
                if(current.getCostOfHouse() < (this.getBalance())/2){
                    // Buy at a random rate of 0.5
                    int random = Math.random();
                    if (random > 0.5) {
                        current.addHouses();
                        this.setBalance(this.balance() - current.getCostOfHouse());
                    }
                }
            }
        }
    }

    public boolean trader(int, [Ownable]){


        return true;
    }

    public int bid(Tile){
    int bidAmount = 100;

    return bidAmount;

    }

    public int payBill(int){
        int bill = 0;
        return bill;
    }

    private int findOwned(Ownable tile){
        return 1;
    }

    private ArrayList streetOwned(Void) {

        ArrayList<Property> Streets = new ArrayList<Property>();

        for (Tile current: Ownable) {
            if(this.getBoard().isStreetOwned(Tile) == true){
                if(current instanceof Property){
                    Property property = (Property) current;
                    Streets.add(property);
                }

            }
        }

    }

}









/**

 Turn:



 DONE BuyTile override:
 DONE If not, do i have any tiles in the same group
 DONE Do i have enough money
 DONE Does anyone else have a tile in this group if none yes, if 2 yes


 DONE buyHouses
 DONE Check if a group is owned by AI
 DONE If not don't buy
 DONE If do, and AI money is over certain amount buy houses accordingly.

 Trade:
 Accept a trade if in AI benefit
 If exchange means the AI gets a street
 If AI does not get a street, does it get two properties in the same street
 Does the other player get a street?

 Bid:
 Does the AI have a property in that group?
 Does the AI have money
 Does someone else have property in that group


 Decision pay bill
 If have enough money, pay bill
 Else
 Does AI have any property that alone in a group + no other player has other properties
 Does selling/mortgaging this rase the funds? If no, sell anyway

 loop
 sell houses on cheapest street
 sell property from this group to raise funds

 thid.board.


 **/


