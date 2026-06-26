package entities;

import level.EventManager;

public class Occupant {
    private Unit unit;
    public Occupant(Unit u){
        this.unit = u;
    }
    public Unit getUnit(){
        return unit;
    }

    public ActionResult accept(OccupantVisitor occupantVisitor, EventManager em) {
        return this.unit.accept(occupantVisitor, em);
    }
}
