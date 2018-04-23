import java.util.ArrayList;
import java.util.HashMap;

public class Trade {

    /**
     * player1: Player
     */
    private Player player1;

    /**
     * player2: Player
     */
    private Player player2;

    /**
     * player: HashMap<Player, ArrayList<Ownable>>
     */
    private HashMap<Player, ArrayList<Ownable>> players;

    /**
     * Constructor
     * @param player1
     * @param player2
     */
    public Trade(Player player1, Player player2){
        this.players = new HashMap<>();
        this.player1 = player1;
        this.player2 = player2;
        this.players.put(player1, new ArrayList<Ownable>());
        this.players.put(player2, new ArrayList<Ownable>());

    }

    /**
     * addOwnable
     * @param player
     * @param ownable
     */
    public void addOwnable(Player player, Ownable ownable) {
        this.players.get(player).add(ownable);
    }

    public ArrayList<Ownable> getOwnable(Player player){

        return this.players.get(player);
    }

    /**
     * acceptTrade
     * @param boolean1
     * @param boolean2
     * @return boolean
     */
    public boolean acceptTrade(boolean boolean1, boolean boolean2){
        if(boolean1 && boolean2){
            this.tradeOwnable();
            return true;
        }
        return false;
    }

    /**
     * tradeOwnable
     */
    private void tradeOwnable(){
        for(Ownable ownable: this.players.get(player1)){
            ownable.setOwner(player2);
            player1.removeOwnable(ownable);
        }

        for(Ownable ownable: this.players.get(player2)){
            ownable.setOwner(player1);
            player2.removeOwnable(ownable);
        }



    }
}
