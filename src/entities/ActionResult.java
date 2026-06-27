package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionResult {
    private boolean moved;
    private Player playerDied;
    private List<Enemy> killedEnemies;

    public ActionResult(){
        this.moved = false;
        this.playerDied = null;
        this.killedEnemies = new ArrayList<>();
    }
    public void setMoved(boolean b){
        moved = b;
    }
    public void setPlayerDied(Player p){
        playerDied = p;
    }
    public void killedEnemy(Enemy e){
        killedEnemies.add(e);
    }

    public void moved() {
        moved = true;
    }

    public boolean getMoved(){
        return moved;
    }

    public List<Enemy> getEnemiesKilled() {
        return killedEnemies;
    }
    public Player getPlayerDied(){return playerDied;}

    public void killedEnemies(List<Enemy> enemiesKilled) {
        for (Enemy e : enemiesKilled){
            killedEnemies.add(e);
        }
    }
}