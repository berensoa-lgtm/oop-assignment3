package entities;

public abstract class Unit {
    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;
    abstract String attack(Unit u);
    abstract String defend(Unit u);
    abstract String initializeInteraction(Enemy e);
    abstract String initializeInteraction(Player p);

    public void visit(Unit u) {

    }

    abstract String accept(OccupantVisitor occupantVisitor);
}
