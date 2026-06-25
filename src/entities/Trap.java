package entities;

public class Trap extends Enemy{
    private int visTime;
    private int invisTime;
    private int tickCount;
    private boolean visible;

    public Trap(String name, int health, int attack, int defense, int exp, int visibilityTime, int invisibilityTime){
        this.visTime = visibilityTime;
        this.invisTime = invisibilityTime;
        this.tickCount = 0;
        this.visible = true;
        this.name = name;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.experienceValue = exp;
        this.healthAmount = health;
        this.healthPool = health;
    }
    @Override
    String accept(OccupantVisitor occupantVisitor) {
        return null;
    }
}
