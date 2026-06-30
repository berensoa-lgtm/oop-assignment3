package entities;
import board.*;
import game.EventManager;

public class CellVisitor {
    private Unit unit;
    private OccupantVisitor occupantVisitor;
    public CellVisitor(Unit u){
        this.unit = u;
        this.occupantVisitor = new OccupantVisitor(u);
    }

    public ActionResult visit(Floor floor, EventManager em) {
        Occupant floorOcc = floor.getOccupant();
        if (floorOcc == null) {
            floor.setOccupant(new Occupant(unit));
            ActionResult result = new ActionResult();
            result.moved();
            return result;
        }
        else{
            return floorOcc.accept(occupantVisitor, em);
        }
    }
    public ActionResult visit(Wall wall) {
        return new ActionResult();
    }
}
