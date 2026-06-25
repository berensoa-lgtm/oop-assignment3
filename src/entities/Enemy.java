package entities;

public abstract class Enemy extends Unit {
    protected int experienceValue;
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
}
