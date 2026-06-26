package board;

import entities.CellVisitor;
import entities.Occupant;
import entities.Unit;
import level.EventManager;

public interface Cell {
    String accept(CellVisitor v, EventManager em);
    default Occupant getOccupant(){
        return null;
    }
    default void setOccupant(Occupant o){};
}
