package entities;

import board.Position;
import level.EventManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit {
    protected int experience;
    protected int playerLevel;
    protected int abilityRange;

    public abstract ActionResult cast(List<Enemy> inRangeEnemies, EventManager em);
    public abstract void levelUp();


    protected void initializePlayerProperties(int health, int attack, int defense, String name, int range){
        super.initializeProperties(health, attack, defense, name);
        this.experience = 0;
        this.playerLevel = 1;
        this.abilityRange = range;
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
        return InteractionUtils.attack(this, e, em);
    }
    protected List<Enemy> inRangeEnemies (List<Enemy> enemyList){
        List<Enemy> lst = new ArrayList<>();
        for(Enemy e: enemyList){
            if(InteractionUtils.range(this,e) < abilityRange)
                lst.add(e);
        }
        return lst;
    }

    @Override
    public ActionResult initializeInteraction(Player p, EventManager em){
        return new ActionResult();
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
    public ActionResult loseHealth(int dmg, EventManager em){
        healthAmount -= dmg;
        ActionResult result = new ActionResult();
        if (healthAmount <= 0){
            result.setPlayerDied(this);
            em.publish("You lost.");
        }
        return result;
    }
}
