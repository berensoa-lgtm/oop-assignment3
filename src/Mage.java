public class Mage extends Player{
    private int manaPool;
    private int manaCost;
    private int currentMana;
    private int spellPower;
    private int hitsCount;

    public Mage(){

    }

    @Override
    public void cast() {

    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(manaPool, currentMana + (manaPool / 4));
        spellPower += (10 * playerLevel);
    }
}
