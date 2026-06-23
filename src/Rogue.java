public class Rogue extends Player{
    private int cost;
    private int currentEnergy;
    @Override
    public void cast() {

    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
    }
}
