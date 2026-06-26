package entities;

import java.util.List;
import java.util.Random;

public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;
    public Warrior(String name, int health, int attack, int defense, int abilityCooldown){
        super.initializeProperties(health, attack, defense, name);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }
    @Override
    public void cast(List<Unit> inRangeEnemies) {
        Random rnd = new Random();
        if(remainingCooldown > 0) {
            System.out.println("can't cast special ability: cooldown isn't over");
        }
        else {
            if(inRangeEnemies.size() > 0){
                int index = rnd.nextInt(inRangeEnemies.size());
                InteractionUtils.specialAbilityAttack(inRangeEnemies.get(index),(int)(healthPool * 0.1));
            }
            this.healthAmount = Math.min(healthPool, healthAmount + (10 * defensePoints));
            remainingCooldown = abilityCooldown;
        }
    }

    @Override
    public void gameTick(){

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