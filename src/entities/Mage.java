package entities;

public class Mage extends Player{
    private int manaPool;
    private int manaCost;
    private int currentMana;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super.initializeProperties(health, attack, defense);
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
        this.name = name;
    }
    @Override
    public void gameTick(){

    }

    @Override
    public void cast() {
        if(currentMana < manaCost){
            //write a message telling him he can't cast his ability?
        }
        else {
            currentMana -= manaCost;
            int hits = 0;
            while(hits < hitsCount && livingEnemyInRange())
            {
            }

        }
    }

    private boolean livingEnemyInRange(){ //the functions checks if there's still a living enemy in range for the special ability to hit
        return false;
    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(manaPool, currentMana + (manaPool / 4));
        spellPower += (10 * playerLevel);
    }
}