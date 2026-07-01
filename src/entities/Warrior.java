package entities;

import level.EventManager;

import java.util.List;
import java.util.Random;

public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;
    public Warrior(String name, int health, int attack, int defense, int abilityCooldown){
        super.initializePlayerProperties(health, attack, defense, name, 3);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
        this.abilityName = "Avenger's Shield";
    }
    @Override
    public ActionResult cast(List<Enemy> lst, EventManager em) {
        Random rnd = new Random();
        if(remainingCooldown > 0) {
            em.publish("can't cast special ability: cooldown isn't over");
            return new ActionResult();
        }
        else {
            int newHealth = Math.min(healthPool, healthAmount + (10 * defensePoints));
            em.publish(name + " used " + abilityName + ", healing for " + (newHealth - healthAmount));
            List<Enemy> inRange = inRangeEnemies(lst);
            healthAmount = newHealth;
            ActionResult result = new ActionResult();
            if(!inRange.isEmpty()){
                int index = rnd.nextInt(inRange.size());
                ActionResult hit = InteractionUtils.specialAbilityAttack(this, inRange.get(index),(int)(healthPool * 0.1), em);
                result.killedEnemies(hit.getEnemiesKilled());
            }
            remainingCooldown = abilityCooldown;
            gainEnemiesExperience(result.getEnemiesKilled(), em);
            return result;
        }
    }

    @Override
    public void gameTick(){
        remainingCooldown -= 1;
    }

    @Override
    public void levelUp(EventManager em) {
        int oldHealth = healthPool;
        int oldAttack = attackPoints;
        int oldDefense = defensePoints;

        super.levelUpPlayer();
        remainingCooldown = 0;
        healthPool += (5 * playerLevel);
        attackPoints += (2 * playerLevel);
        defensePoints += playerLevel;

        int health = (healthPool - oldHealth);
        int attack = (attackPoints - oldAttack);
        int defense = (defensePoints - oldDefense);
        em.publish(name + " reached level" + playerLevel + ": +" + health + " health, +" + attack + " attack, +" + defense + " defense");


    }
}