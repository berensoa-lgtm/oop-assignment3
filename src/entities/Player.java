package entities;

import game.EventManager;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit {
    protected int experience;
    protected int playerLevel;
    protected int abilityRange;
    protected String abilityName;

    public abstract ActionResult cast(List<Enemy> inRangeEnemies, EventManager em);

    public abstract void levelUp(EventManager em);


    protected void initializePlayerProperties(int health, int attack, int defense, String name, int range){
        super.initializeProperties(health, attack, defense, name);
        this.experience = 0;
        this.playerLevel = 1;
        this.abilityRange = range;
    }

    public void gainEnemiesExperience(List<Enemy> killedEnemies, EventManager em){
        for(Enemy e: killedEnemies)
        {
            experience += e.getExperienceValue();
            em.publish(name + " gained " + e.getExperienceValue() + "experience" );
            if(experience >= (50 * playerLevel)){
                levelUp(em);
            }
        }
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
        ActionResult result = new ActionResult();
        ActionResult hit = InteractionUtils.attack(this, e, em);
        result.killedEnemies(hit.getEnemiesKilled());
        gainEnemiesExperience(result.getEnemiesKilled(), em);
        return result;
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

    public int getExperience(){
        return experience; //for testing purposes only
    }
}
