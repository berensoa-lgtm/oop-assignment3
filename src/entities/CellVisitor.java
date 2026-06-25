package entities;
import board.*;
public class CellVisitor {
    private Unit unit;
    private OccupantVisitor occupantVisitor;
    public CellVisitor(Unit u){
        this.unit = u;
        this.occupantVisitor = new OccupantVisitor(u);
    }

    public String visit(Floor floor) {
        Occupant floorOcc = floor.getOccupant();
        if (floorOcc == null) {
            floor.setOccupant(new Occupant(unit));
            return "Move here";
        }
        else{
            return floorOcc.accept(occupantVisitor);
        }
    }
    public String visit(Wall wall) {
        return "Hit a wall";
    }
}
