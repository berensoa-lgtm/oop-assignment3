package board;

import board.Cell;
import entities.ActionResult;
import entities.CellVisitor;
import entities.Occupant;
import level.EventManager;

public class Wall extends Cell {

    @Override
    ActionResult accept(CellVisitor v, EventManager em) {
        return v.visit(this);
    }

    @Override
    Occupant getOccupant() {
        return null;
    }

    @Override
    void setOccupant(Occupant o) {    }
}
