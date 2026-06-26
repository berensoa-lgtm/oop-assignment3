package game;
import entities.*;

import java.util.List;

public class GameUnits {
    private Player player;
    private List<Unit> units;
    public GameUnits(List<Unit> u, Player p){
        units = u;
        player = p;
    }
    public void gameTick(){

        for (Unit u : units){
           // u.gameTick();
        }
    }
    public Player getPlayer(){
        return player;
    }

}
