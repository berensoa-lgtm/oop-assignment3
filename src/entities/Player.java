package entities;

import board.Position;
import level.EventManager;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit {
    protected int experience;
    protected int playerLevel;

    public abstract void cast(List<Unit> inRangeEnemies);
    public abstract void levelUp();
    public abstract void gameTick();


    protected void initializeProperties(int health, int attack, int defense, String name){
        super.initializeProperties(health, attack, defense);
        this.experience = 0;
        this.playerLevel = 1;
        this.name = name;
    }

    protected void levelUpPlayer(){
        this.experience = experience - (50 * playerLevel);
        this.playerLevel += 1;
        this.healthPool += 10 * playerLevel;
        this.healthAmount = healthPool;
        this.attackPoints += 4 * playerLevel;
        this.defensePoints += playerLevel;
    }
    @Override
    public ActionResult initializeInteraction(Enemy e, EventManager em){
        //not yet implemented;
    }

    @Override
    public ActionResult initializeInteraction(Player p, EventManager em){
        return InteractionUtils.attack(this, p, em);
    }
    @Override
    public ActionResult accept(OccupantVisitor occupantVisitor, EventManager em){
        return occupantVisitor.visit(this, em);
    }
    @Override
    public String toString(){
        String s = super.toString();
        s+="Level: "+playerLevel+"   ";
        s+= "Experience: "+experience+"   ";
        return s;
    }
    @Override
    public ActionResult loseHealth(int dmg){
        healthAmount -= dmg;
        ActionResult result = new ActionResult();
        if (healthAmount <= 0){
            result.playerKilled();
        }
        return result;
    }
}
