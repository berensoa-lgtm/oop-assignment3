package entities;

import board.Position;
import level.EventManager;

public abstract class Unit {
    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;
    protected Position pos;

    abstract ActionResult initializeInteraction(Enemy e, EventManager em);
    abstract ActionResult initializeInteraction(Player p, EventManager em);
    public abstract void gameTick();

    abstract ActionResult loseHealth(int damage);

    abstract ActionResult accept(OccupantVisitor occupantVisitor, EventManager em);

    protected void initializeProperties(int health, int attack, int defense, String name) {
        this.attackPoints = attack;
        this.healthPool = health;
        this.healthAmount = health;
        this.defensePoints = defense;
        this.name = name;
    }
    public Position getPos(){
        return pos;
    }
    public void setPos(Position p){
        this.pos = p;
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
