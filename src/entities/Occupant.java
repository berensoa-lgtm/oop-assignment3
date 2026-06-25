package entities;

public class Occupant {
    private Unit unit;
    public Occupant(Unit u){
        this.unit = u;
    }
    public Unit getUnit(){
        return unit;
    }

    public String accept(OccupantVisitor occupantVisitor) {
        return this.unit.accept(occupantVisitor);
    }
}
