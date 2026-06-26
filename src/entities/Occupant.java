package entities;

import level.EventManager;

public class Occupant {
    private char symbol;
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

    public void setSymbol(char c) {
        symbol = c;
    }
    public char getSymbol(){
        return symbol;
    }
}
