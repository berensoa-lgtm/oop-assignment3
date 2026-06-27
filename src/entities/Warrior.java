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
    }
    @Override
    public ActionResult cast(List<Enemy> inRangeEnemies, EventManager em) {
        Random rnd = new Random();
        if(remainingCooldown > 0) {
            em.publish("can't cast special ability: cooldown isn't over");
            return new ActionResult();
        }
        else {
            int newHealth = Math.min(healthPool, healthAmount + (10 * defensePoints));
            em.publish(name+"used Avenger's Shield, healing for "+(newHealth - healthAmount));
            healthAmount = newHealth;
            ActionResult result = new ActionResult();
            if(inRangeEnemies.size() > 0){
                int index = rnd.nextInt(inRangeEnemies.size());
                ActionResult hit = InteractionUtils.specialAbilityAttack(this, inRangeEnemies.get(index),(int)(healthPool * 0.1), em);
                result.killedEnemies(hit.getEnemiesKilled());
            }
            remainingCooldown = abilityCooldown;
            return result;
        }
    }

    @Override
    public void gameTick(){
        remainingCooldown -= 1;
    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        remainingCooldown = 0;
        healthPool += (5 * playerLevel);
        attackPoints += (2 * playerLevel);
        defensePoints += playerLevel;
    }
}