/**
 * This class is used to create an artificial player.
 */





public class AI extends Player {

    public AI(int balance, String name, Board board){
        super(balance, name, board);

    }

    @Override
    public boolean buyTile(Ownable tile, int cost){



        if (this.board.getPlayerOwned(tile) > 1 && this.balance > cost) {
            return true;
        } else if (this.board.getPlayerOwned(tile) > 0 && && this.balance > cost && this.board.groupSize(tile)  == 2){
            return true;
        } else if (this.board.getPlayerOwned(tile) < 1 && this.balance > cost) {
            return true;
        }

        

        return true;
    }

    public boolean buyHouses(){

        return true;
    }

    public boolean trader(){


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

}









/**

 Turn:



 BuyTile override:
 If not, do i have any tiles in the same group
 Do i have enough money
 Does anyone else have a tile in this group if none yes, if 2 yes


 buyHouses
 Check if a group is owned by AI
 If not don't buy
 If do, and AI money is over certain amount buy houses accordingly.

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


