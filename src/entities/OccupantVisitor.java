package entities;

import level.EventManager;

public class OccupantVisitor {
    private Unit unit;
    public OccupantVisitor(Unit u){
        this.unit = u;
    }
    public ActionResult visit(Enemy e, EventManager em){
        return unit.initializeInteraction(e, em);
    }
    public ActionResult visit(Player p, EventManager em){
        return unit.initializeInteraction(p, em);
    }

}
