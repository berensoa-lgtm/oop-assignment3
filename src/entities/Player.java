package entities;

public abstract class Player extends Unit {
    private int experience;
    protected int playerLevel;
    public abstract void cast();
    public abstract void levelUp();
    protected void levelUpPlayer(){

    }
    public String accept(OccupantVisitor occupantVisitor){
        return occupantVisitor.visit(this);
    }
    public String initializeInteraction(Enemy e){
        InteractionUtils.attack(this, e);
        return "";
    }
    public String initializeInteraction(Player p){
        return "nothing";
    }
    public void loseHealth(int dmg){
        healthAmount =- dmg;
    }
}
