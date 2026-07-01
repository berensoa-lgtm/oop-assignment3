package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionResult {
    private boolean moved;
    private Player playerDied;
    private List<Enemy> killedEnemies;
    private boolean usedAbility; //for testing purposes only

    public ActionResult(){
        this.moved = false;
        this.playerDied = null;
        this.killedEnemies = new ArrayList<>();
        this.usedAbility = false;
    }

    public void setPlayerDied(Player p){
        playerDied = p;
    }
    public void killedEnemy(Enemy e){
        killedEnemies.add(e);
    }
    public boolean getUsedAbility(){
        return usedAbility;
    }

    public void usedAbility(){
        this.usedAbility = true;
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
        killedEnemies.addAll(enemiesKilled);
    }
}