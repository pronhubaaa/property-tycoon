/*
  This class is used to create an artificial player.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
        if(tile instanceof Ownable){
            Ownable ownable = (Ownable) tile;
            if (!ownable.isOwned()) {
                // If a player owns 1 of two tiles
                if (this.getBoard().getPlayerOwned(ownable) > 0 && this.getBalance() > ownable.getPrice() && ownable.getGroup().getGroupOwners().size() == 2) {
                    ownable.setOwner(this);
                    setBalance(getBalance() - ownable.getPrice());
                    return true;
                }
                //If another player owns a tile in the same group
                else if (this.getBoard().getPlayerOwned(ownable) > 0 && this.getBalance() > ownable.getPrice()) {
                    double random = Math.random();
                    if(random > 0.25){
                        ownable.setOwner(this);
                        setBalance(getBalance() - ownable.getPrice());
                        return true;
                    }

                } else if (this.getBalance() >= ownable.getPrice() * 3) {
                    ownable.setOwner(this);
                    setBalance(getBalance() - ownable.getPrice());
                    return true;
                }
                //If no other tiles in the group are owned
                else {
                    double random = Math.random();
                    if(random > 0.5 && this.getBalance() > ownable.getPrice()){
                        ownable.setOwner(this);
                        setBalance(getBalance() - ownable.getPrice());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Boolean> buyHouses(){
        ArrayList<Boolean> purchases = new ArrayList<>();
        //Get array list of all streets that are owned
        if(this.getOwnedTiles().isEmpty()) {
            ArrayList<Ownable> temp = streetOwned(this.getOwnedTiles());
            ArrayList<Property> ownedStreets = new ArrayList<>();
            for (Ownable current : temp) {
                if (current instanceof Property) {
                    ownedStreets.add((Property) current);
                }
            }
            //When a street is owned
            if (!ownedStreets.isEmpty()) {
                // for each in the street

                for (Property current : ownedStreets) {
                    // if house price is less than half the players balance
                    if (current.getCostOfHouse() < (this.getBalance()) / 2) {
                        // Buy at a random rate of 0.5
                        double random = Math.random();
                        if (random > 0.5) {
                            current.addHouses();
                            this.setBalance(this.getBalance() - current.getCostOfHouse());
                            purchases.add(true);
                        } else {
                            purchases.add(false);
                        }
                    }
                }
            }
        }
        purchases.add(false);
        return purchases;
    }

    public boolean trader(ArrayList<Ownable> opponentTiles, ArrayList<Ownable> myTiles, Player player){
        int score = 0;

        if(opponentTiles.isEmpty() || myTiles.isEmpty()){
            return false;
        }

        // adding opponent tiles to AI tiles
        for (Ownable tiles: opponentTiles) {
            ArrayList<Ownable> currentTiles = this.getOwnedTiles();
            currentTiles.add(tiles);

            ArrayList<Player> owners = tiles.getGroup().getGroupOwners();


            if (streetOwned(currentTiles).size() > streetOwned(this.getOwnedTiles()).size()) {
                // Street gained
                score = score +10;
            } else if(Collections.frequency(owners, this) > 0){
                score = score +5;
                 // Extra part of set gained
            } else {
                // Nothing gained
            }
        }

        for (Ownable tile: myTiles) {
            ArrayList<Player> players = tile.getGroup().getGroupOwners();

            if (Collections.frequency(players, player) > 2){
                score = score -10;
            }else if (Collections.frequency(players, player) > 1){
                score = score - 5;
            }

        }

            if(score < -4){
                double random = Math.random();
                return random > 0.98;
            } else if(score < -2){
                double random = Math.random();
                return random > 0.85;
            } else if(score < 0){
                double random = Math.random();
                return random > 0.4;
            }  else if(score < 2){
                double random = Math.random();
                return random > 0.2;
            }  else if(score < 4){
                double random = Math.random();
                return random > 0.1;
            } else {
                double random = Math.random();
                return random > 0.99;
            }
    }

    public int bid(Tile buyable){

        if (buyable instanceof Ownable) {
            Ownable current = (Ownable) buyable;



            //If a player owns 1 of two tiles or If another player owns a tile in the same group
            if (this.getBoard().getPlayerOwned(current) > 0 && this.getBalance() > current.getPrice() && current.getGroup().getGroupOwners().size() == 2 || this.getBoard().getPlayerOwned(current) > 0 && this.getBalance() > current.getPrice()) {
                if(this.getBalance() > current.getPrice()*3){
                    double random = Math.random();
                    if (random > 0.3) {
                        return current.getPrice()*2;
                    }
                } else if(this.getBalance() > current.getPrice()*2){
                    double random = Math.random();
                    if (random > 0.4) {
                        return (int) Math.round(current.getPrice()*1.5);
                    }
                }   else if(this.getBalance() > current.getPrice()){
                    double random = Math.random();
                    if (random > 0.5) {
                        return current.getPrice() + 10;
                    }
                }
            }
            //If a player owns more than 1 in the set
            else if (this.getBoard().getPlayerOwned(current) > 0) {
                if(this.getBalance() > current.getPrice()*3){
                    return current.getPrice()*2;
                } else if(this.getBalance() > current.getPrice()*2){
                    double random = Math.random();
                    if (random > 0.2) {
                        return (int) Math.round(current.getPrice() * 1.5);
                    }
                }   else if(this.getBalance() > current.getPrice()){
                    double random = Math.random();
                    if (random > 0.3) {
                        return current.getPrice() + 10;
                    }
                }
            }
            //If no other tiles in the group are owned
            else {
                if(this.getBalance() > current.getPrice()*3){
                    double random = Math.random();
                    if (random > 0) {
                        return current.getPrice()*2;
                    }
                } else if(this.getBalance() > current.getPrice()*2){
                    double random = Math.random();
                    if (random > 0.5) {
                        return (int) Math.round(current.getPrice()*1.5);
                    }
                }   else if(this.getBalance() > current.getPrice()){
                    double random = Math.random();
                    if (random > 0.7) {
                        return current.getPrice() + 10;
                    }
                }
            }

        }
        return 0;

    }

    public boolean payBill(int bill){
        if(this.getBalance() >= bill){
            return true;
        }
        ArrayList<Ownable> myTiles = this.getOwnedTiles();
        ArrayList<Ownable> streetTiles = new ArrayList<>();
        myTiles.sort(Comparator.comparingInt(Ownable::getPrice));
        for(Ownable tile: myTiles){

            ArrayList<Ownable> currentTiles = this.getOwnedTiles();
            currentTiles.remove(tile);
            if (streetOwned(currentTiles).size() < streetOwned(this.getOwnedTiles()).size()) {
                streetTiles.add(tile);
            } else {

                this.mortgageTile(tile);
                if(this.getBalance() >= bill){
                    return true;
                } else {
                    this.sellTile(tile);
                    if(this.getBalance() >= bill){
                        return true;
                    }
                }
            }
        }

        for(Ownable tile: streetTiles) {
            if (tile instanceof Property) {
                int amountOfHouses = ((Property) tile).getAmountOfHouses();
                while (amountOfHouses > 0) {
                    ((Property) tile).removeHouses(1);
                    if(this.getBalance() >= bill){
                        return true;
                    }
                    amountOfHouses -= 1;
                }
            }
        }

        for(Ownable tile: streetTiles){

            ArrayList<Ownable> currentTiles = this.getOwnedTiles();
            currentTiles.remove(tile);
            if (streetOwned(currentTiles).size() < streetOwned(this.getOwnedTiles()).size()) {
                streetTiles.add(tile);
            } else {
                this.mortgageTile(tile);
                if(this.getBalance() > bill){
                    return true;
                } else {
                    this.sellTile(tile);
                    if(this.getBalance() >= bill){
                        return true;
                    }
                }
            }
        }

        return false;

    }


    private ArrayList<Ownable> streetOwned(ArrayList<Ownable> inputTiles) {

            //Get array list of all streets that are owned
            ArrayList<Ownable> ownedTiles = inputTiles;
            ArrayList<Ownable> ownedStreets = new ArrayList<>();
            if(!ownedTiles.isEmpty()) {
                for (Ownable current : ownedTiles) {
                    Group temp = current.getGroup();
                    if (groupOwned(temp)) {
                        ownedStreets.add(current);
                    }
                }
            }
            return ownedStreets;
    }

    private boolean groupOwned(Group group){
        ArrayList<Player> owners = group.getGroupOwners();
        return owners.stream().distinct().limit(2).count() <= 1;
    }



}




/*

 Turn:

 DONE BuyTile override:
 DONE If not, do i have any tiles in the same group
 DONE Do i have enough money
 DONE Does anyone else have a tile in this group if none yes, if 2 yes


 DONE buyHouses
 DONE Check if a group is owned by AI
 DONE If not don't buy
 DONE If do, and AI money is over certain amount buy houses accordingly.


 DONE Trade:
 DONE If exchange means the AI gets a street
 DONE If AI does not get a street, does it get two properties in the same street
 DONE Does the other player get a street?

 DONE Bid:
 DONE Does the AI have a property in that group?
 DONE Does the AI have money
 DONE Does someone else have property in that group

 DONE Decision pay bill
 DONE If have enough money, pay bill
 DONE Else
 DONE Does AI have any property that alone in a group + no other player has other properties
 DONE Does selling/mortgaging this rase the funds? If no, sell anyway
 DONE loop
 DONE sell houses on cheapest street
 DONE sell property from this group to raise funds

 */


