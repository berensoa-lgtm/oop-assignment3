package board;

import entities.CellVisitor;
import entities.Occupant;
import entities.Unit;

public interface Cell {
    String accept(CellVisitor v);
    default Occupant getOccupant(){
        return null;
    }
    default void setOccupant(Occupant o){};
}
