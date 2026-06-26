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

    protected void initializeProperties(int health, int attack, int defense) {
        this.attackPoints = attack;
        this.healthPool = health;
        this.healthAmount = health;
        this.defensePoints = defense;
    }
    public String toString(){
        String s = "";
        s += name + "   ";
        s += "Health: "+healthAmount+"/"+healthPool+"   ";
        s+= "Attack: "+attackPoints+"   ";
        s+= "Defense: "+defensePoints+"   ";
        return s;
    }
}
