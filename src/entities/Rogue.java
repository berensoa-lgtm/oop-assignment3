package entities;

import game.EventManager;

import java.util.List;

public class Rogue extends Player{
    private int cost;
    private int currentEnergy;
    private int energyPool;

    public Rogue(String name, int health, int attack, int defense, int cost){
        super.initializePlayerProperties(health, attack, defense, name, 2);
        this.cost = cost;
        this.currentEnergy = 100;
        this.energyPool = 100;
        this.abilityName = "Fan of Knives";
    }

    @Override
    public ActionResult cast(List<Enemy> lst, EventManager em) {
        if(currentEnergy < cost){
            em.publish("can't cast special ability: you don't have enough energy");
            return new ActionResult();
        }
        else {
            em.publish(name + " cast " + abilityName + ".");
            List<Enemy> inRange = inRangeEnemies(lst);
            ActionResult result = new ActionResult();
            currentEnergy -= cost;
            for(Unit enemy: inRange){
                ActionResult hit = InteractionUtils.specialAbilityAttack(this, enemy, attackPoints, em);
                result.killedEnemies(hit.getEnemiesKilled());
                gainEnemiesExperience(result.getEnemiesKilled(), em);
            }
            return result;
        }
    }


    @Override
    public void gameTick(){
        currentEnergy = Math.min(100, currentEnergy + 10);
    }

    @Override
    public void levelUp(EventManager em) {
        int oldHealth = healthPool;
        int oldAttack = attackPoints;
        int oldDefense = defensePoints;
        super.levelUpPlayer();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
        int health = (healthPool - oldHealth);
        int attack = (attackPoints - oldAttack);
        int defense = (defensePoints - oldDefense);
        em.publish(name + " reached level" + playerLevel + ": +" + health + " health, +" + attack + " attack, +" + defense + " defense");
    }
    @Override
    public String toString(){
        String s = super.toString();
        s+="Energy: "+currentEnergy+"/"+energyPool+"   ";
        return s;
    }
}