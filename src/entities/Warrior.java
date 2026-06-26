package entities;

public class Warrior extends Player{

    private int abilityCooldown;
    private int remainingCooldown;
    public Warrior(String name, int health, int attack, int defense, int abilityCooldown){
        super.initializeProperties(health, attack, defense);
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
        this.name = name;
    }
    @Override
    public void cast() {
        if(remainingCooldown > 0) {
            //write a message telling him he can't cast his ability yet?
        }
        else {
            //cast ability: randomly hit an enemy within range < 3 for an amount equals to 10% of the warrior’s health pool
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