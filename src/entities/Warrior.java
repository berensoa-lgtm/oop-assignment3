package entities;

public class Warrior extends Player {

    private int abilityCooldown;
    private int remainingCooldown;
    public Warrior(int abilityCooldown){
        this.abilityCooldown = abilityCooldown;
        this.remainingCooldown = 0;
    }
    @Override
    public void cast() {

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
