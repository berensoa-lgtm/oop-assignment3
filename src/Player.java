public abstract class Player extends Occupant {
    protected int experience;
    protected int playerLevel;

    public abstract void cast();
    public abstract void levelUp();
    public abstract void gameTick();

    protected void levelUpPlayer(){
        this.experience = experience - (50 * playerLevel);
        this.playerLevel += 1;
        this.healthPool += 10 * playerLevel;
        this.currentHealth = healthPool;
        this.attackPoints += 4 * playerLevel;
        this.defensePoints += playerLevel;
    }
}
