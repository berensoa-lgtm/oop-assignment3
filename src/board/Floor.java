package board;

import entities.*;
import game.EventManager;

public class Floor extends Cell{
    private Occupant occupant;
    private final char FLOOR_SYMBOL= '.';
    public Floor(){
        this.occupant = null;
    }
    public Floor(Occupant o){
        this.occupant = o;
    }
    public Floor(Unit u){
        this.occupant = new Occupant(u);
    }
    public ActionResult accept(CellVisitor v, EventManager em){
        return v.visit(this, em);
    }

    @Override
    public Occupant getOccupant() {
        return this.occupant;
    }

    @Override
    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
        if (occupant != null)
            this.setSymbol(occupant.getSymbol());
        else
            symbol = FLOOR_SYMBOL;
    }
    @Override
    public char getSymbol(){
        if (this.occupant != null)
            return occupant.getSymbol();
        else
            return FLOOR_SYMBOL;
    }
    @Override
    public void setSymbol(char c){
        if (occupant != null)
            occupant.setSymbol(c);
        else
            symbol = c;
    }
}