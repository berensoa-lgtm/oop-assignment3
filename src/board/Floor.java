package board;

import entities.*;
import level.EventManager;

import javax.swing.*;

public class Floor extends Cell{
    private Occupant occupant;
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
        if (occupant == null)
            symbol = '.';
    }
    @Override
    public void setSymbol(char c){
        if (occupant != null)
            occupant.setSymbol(c);
        else
            super.setSymbol(c);
    }
    @Override
    public char getSymbol(){
        if (occupant != null)
            return occupant.getSymbol();
        else
            return super.getSymbol();
    }
}
