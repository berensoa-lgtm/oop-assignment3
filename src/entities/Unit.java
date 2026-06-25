package entities;

public abstract class Unit {
    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;
    abstract String initializeInteraction(Enemy e);
    abstract String initializeInteraction(Player p);
    abstract void loseHealth(int damage);

    abstract String accept(OccupantVisitor occupantVisitor);
}
