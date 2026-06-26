package entities;

import java.util.ArrayList;
import java.util.List;

public class ActionResult {
    private boolean moved;
    private boolean playerDied;
    private List<Enemy> killedEnemies;

    public ActionResult(){
        this.moved = false;
        this.playerDied = false;
        this.killedEnemies = new ArrayList<>();
    }
    public void setMoved(boolean b){
        moved = b;
    }
    public void setPlayerDied(boolean b){
        playerDied = b;
    }
    public void killedEnemy(Enemy e){
        killedEnemies.add(e);
    }

    public void moved() {
        moved = true;
    }

    public void playerKilled() {
        playerDied = true;
    }
}