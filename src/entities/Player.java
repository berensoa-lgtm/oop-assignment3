package entities;

public abstract class Player extends Unit {
    private int experience;
    protected int playerLevel;
    public abstract void cast();
    public abstract void levelUp();
    protected void levelUpPlayer(){

    }
    public String attack(Player p){
        return "nothing";
    }
    public String attack(Enemy e){
        return "fight";
    }
    public String accept(OccupantVisitor occupantVisitor){
        return occupantVisitor.visit(this);
    }
}
