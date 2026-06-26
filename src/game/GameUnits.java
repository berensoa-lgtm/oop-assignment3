package game;
import entities.*;

import java.util.List;

public class GameUnits {
    private Player player;
    private List<Unit> enemies;
    public GameUnits(List<Unit> e, Player p){
        enemies = e;
        player = p;
    }
    public void gameTick(){

        for (Unit u : enemies){
           // u.gameTick();
        }
    }
    public Player getPlayer(){
        return player;
    }

}
