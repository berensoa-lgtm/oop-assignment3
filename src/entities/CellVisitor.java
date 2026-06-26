package entities;
import board.*;
import level.EventManager;

public class CellVisitor {
    private Unit unit;
    private OccupantVisitor occupantVisitor;
    public CellVisitor(Unit u){
        this.unit = u;
        this.occupantVisitor = new OccupantVisitor(u);
    }

    public String visit(Floor floor, EventManager em) {
        Occupant floorOcc = floor.getOccupant();
        if (floorOcc == null) {
            floor.setOccupant(new Occupant(unit));
            em.publish("MOVED");
        }
        else{
            return floorOcc.accept(occupantVisitor, em);
        }
    }
    public String visit(Wall wall) {
        return "Hit a wall";
    }
}
