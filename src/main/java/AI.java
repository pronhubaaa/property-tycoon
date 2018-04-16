/**
 * This class is used to create an artificial player.
 */

import java.util.ArrayList;
import java.util.Collections;


public class AI extends Player {

    public AI(int balance, String name, Board board){
        super(balance, name, board);

    }

    /**
     * buyTile
     * @param tile Ownable for the players owned properties
     * @return boolean for if transaction is successful
     * This allows the AI to choose to buy a property
     */
    @Override
    public boolean buyTile(Tile tile) {
        if (tile instanceof Ownable) {
            Ownable current = (Ownable) tile;

            //If a player owns more than 1 in the set
            if (this.getBoard().getPlayerOwned(current) > 1 && this.getBalance() > current.getPrice()) {
                return true;
            }
            //If a player owns 1 of two tiles
            else if (this.getBoard().getPlayerOwned(current) > 0 && this.getBalance() > current.getPrice() && this.getBoard().groupSize(current) == 2) {
                return true;
            }
            //If another player owns a tile in the same group
            else if (this.getBoard().getPlayerOwned(current) > 0 && this.getBalance() > current.getPrice()) {
                double random = Math.random();
                if (random > 0.25) {
                    return true;
                } else return false;

            }
            //If this player owns a tile in the same group
            else if (otherOwned(current) > 0 && this.getBalance() > current.getPrice()) {
                return true;
            }
            //If no other tiles in the group are owned
            else {
                double random = Math.random();
                if (random > 0.5) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;
    }

    public void buyHouses(){

        //Get array list of all streets that are owned
        ArrayList<Property> ownedStreets = streetOwned(this.getOwnedTiles());

        //When a street is owned
        if (!ownedStreets.isEmpty()){
            // for each in the street
            for (Property current: ownedStreets) {
                // if house price is less than half the players balance
                if(current.getCostOfHouse() < (this.getBalance())/2){
                    // Buy at a random rate of 0.5
                    double random = Math.random();
                    if (random > 0.5) {
                        current.addHouses();
                        this.setBalance(this.getBalance() - current.getCostOfHouse());
                    }
                }
            }
        }
    }

    public boolean trader(ArrayList<Ownable> opponentTiles, ArrayList<Ownable> myTiles, Player player){


        for (Ownable tiles: opponentTiles) {
            ArrayList<Ownable> localTiles = this.getOwnedTiles();
            localTiles.add(tiles);

            if (streetOwned(this.getOwnedTiles()).size() < streetOwned(localTiles).size()) {
                int score = 0;
                    for (Ownable tile: myTiles) {
                        ArrayList<Player> players = this.getBoard().getOwners(tile);
                        if (Collections.frequency(players, player) > 2{
                            score = score +2;
                        }else if (Collections.frequency(players, player) > 1){
                            score ++;
                        }

                    }
                if(score < 2){
                    double random = Math.random();
                    if (random > 0.2) {
                        return true;
                    }
                } else if(score < 4){
                    double random = Math.random();
                    if (random > 0.45) {
                        return true;
                    }
                } else if(score < 6){
                    double random = Math.random();
                    if (random > 0.7) {
                        return true;
                    }
                }  else {
                    double random = Math.random();
                    if (random > 0.95) {
                        return true;
                    }
                }

            } else if(otherOwned(tiles) > 0){
                int score = 0;
                for (Ownable tile: myTiles) {
                    ArrayList<Player> players = this.getBoard().getOwners(tile);
                    if (Collections.frequency(players, player) > 2{
                        score = score +2;
                    }else if (Collections.frequency(players, player) > 1){
                        score ++;
                    }

                }
                if(score < 2){
                    double random = Math.random();
                    if (random > 0.25) {
                        return true;
                    }
                } else if(score < 3){
                    double random = Math.random();
                    if (random > 0.7) {
                        return true;
                    }
                }else if(score < 4){
                    double random = Math.random();
                    if (random > 0.9) {
                        return true;
                    }
                } else {
                    double random = Math.random();
                    if (random > 0.95) {
                        return true;
                    }
                }


            } else {

            int score = 0;
            for (Ownable tile: myTiles) {
                ArrayList<Player> players = this.getBoard().getOwners(tile);
                if (Collections.frequency(players, player) > 2{
                    score = score +2;
                }else if (Collections.frequency(players, player) > 1){
                    score ++;
                }

            }
            if(score < 2){
                double random = Math.random();
                if (random > 0.25) {
                    return true;
                }
            } else if(score < 3){
                double random = Math.random();
                if (random > 0.7) {
                    return true;
                }else if(score < 4){
                    double random = Math.random();
                    if (random > 0.9) {
                        return true;
                    }
                } else {
                    double random = Math.random();
                    if (random > 0.95) {
                        return true;
                    }
                }
            }
        }




        return false;
    }

    public int bid(Tile tile){
    int bidAmount = 100;

    return bidAmount;

    }

    public int payBill(int bill){
        int amount = 0;
        return amount;
    }

    private int findOwned(Ownable tile){
        return 1;
    }

    private ArrayList<Property> streetOwned(ArrayList<Ownable> owned) {

        ArrayList<Property> streets = new ArrayList<Property>;

        for (Ownable current: owned) {
            if(current instanceof Property){
                Property property = (Property) current;
                if(getBoard().isStreetOwned(property)){
                    streets.add(property);
                }

            }
        }
    return streets;
    }

    private int otherOwned(Ownable tile){
        return this.getBoard().getPlayerOwned(tile);

}









/**


 Trade:
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


 Turn:



 DONE BuyTile override:
 DONE If not, do i have any tiles in the same group
 DONE Do i have enough money
 DONE Does anyone else have a tile in this group if none yes, if 2 yes


 DONE buyHouses
 DONE Check if a group is owned by AI
 DONE If not don't buy
 DONE If do, and AI money is over certain amount buy houses accordingly.

 **/


