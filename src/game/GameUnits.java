package game;
import entities.*;

import java.util.List;

public class GameUnits {
    private Player player;
    private List<Enemy> enemies;
    public GameUnits(List<Enemy> e, Player p){
        enemies = e;
        player = p;
    }
    public void gameTick(){
        for (Enemy e : enemies){
            e.gameTick();
        }
        player.gameTick();
    }
    public Player getPlayer(){
        return player;
    }

    public void kill(List<Enemy> enemiesKilled) {
        for (Enemy killedE : enemiesKilled){
            this.enemies.remove(killedE);
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}