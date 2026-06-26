package entities;

import level.EventManager;

public abstract class Player extends Unit {
    protected int experience;
    protected int playerLevel;

    public abstract void cast();
    public abstract void levelUp();
    public abstract void gameTick();

    protected void initializeProperties(int health, int attack, int defense){
        super.initializeProperties(health, attack, defense);
        this.experience = 0;
        this.playerLevel = 1;
    }

    protected void levelUpPlayer(){
        this.experience = experience - (50 * playerLevel);
        this.playerLevel += 1;
        this.healthPool += 10 * playerLevel;
        this.healthAmount = healthPool;
        this.attackPoints += 4 * playerLevel;
        this.defensePoints += playerLevel;
    }
    public String initializeInteraction(Enemy e){
        return "nothing";
    }
    public String initializeInteraction(Player p){
        InteractionUtils.attack(this, p);
        return "";
    }
    public void loseHealth(int dmg){
        healthAmount =- dmg;
    }
    @Override
    String accept(OccupantVisitor occupantVisitor, EventManager em) {
        return null;
    }
    @Override
    public String toString(){
        String s = super.toString();
        s+="Level: "+playerLevel+"   ";
        s+= "Experience: "+experience+"   ";
        return s;
    }
}
