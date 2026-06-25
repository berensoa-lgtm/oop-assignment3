package entities;

public class OccupantVisitor {
    private Unit unit;
    public OccupantVisitor(Unit u){
        this.unit = u;
    }
    public String visit(Enemy e){
        return unit.initializeInteraction(e);
    }
    public String visit(Player p){
        return unit.initializeInteraction(p);
    }

}
