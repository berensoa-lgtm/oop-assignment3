package entities;

public class Monster extends Enemy{
    private int visionRange;
    public Monster(String name, int healthPool, int healthAmount, int attack, int defend, int exp, int vision){
        this.name = name;
        this.healthAmount = healthAmount;
        this.healthPool = healthPool;
        this.attackPoints = attack;
        this.defensePoints = defend;
        this.visionRange = vision;
        this.experienceValue = exp;
    }

    @Override
    String accept(OccupantVisitor occupantVisitor) {
        return null;
    }
}
