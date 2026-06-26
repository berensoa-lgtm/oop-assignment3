package board;

import entities.ActionResult;
import entities.CellVisitor;
import entities.Occupant;
import entities.Unit;
import level.EventManager;

public abstract class Cell {
    protected char symbol;

    public void setSymbol(char c) {
        symbol = c;
    }
    public char getSymbol(char c){
        return symbol;
    }
    abstract ActionResult accept(CellVisitor v, EventManager em);
    abstract Occupant getOccupant();
    abstract void setOccupant(Occupant o);
}
