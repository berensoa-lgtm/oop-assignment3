public class Mage extends Player{
    private int manaPool;
    private int manaCost;
    private int currentMana;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super.initializeProperties();
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
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
                //נשאר לממש
            }

        }
    }

    private boolean livingEnemyInRange(){ //the functions checks if there's still a living enemy in range for the special ability to hit

    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(manaPool, currentMana + (manaPool / 4));
        spellPower += (10 * playerLevel);
    }
}
