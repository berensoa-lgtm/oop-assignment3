package entities;

import level.EventManager;

public class Monster extends Enemy{
    private int visionRange;
    public Monster(String name, int healthPool, int attack, int defend, int vision, int exp){
        this.name = name;
        this.healthAmount = healthPool;
        this.healthPool = healthPool;
        this.attackPoints = attack;
        this.defensePoints = defend;
        this.visionRange = vision;
        this.experienceValue = exp;
    }

    @Override
    public ActionResult turn(Player player) {
        // up to enemy implementation
        return null;
    }
}
