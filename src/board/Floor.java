package board;

import entities.*;
import level.EventManager;

public class Floor implements Cell{
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
    public String accept(CellVisitor v, EventManager em){
        return v.visit(this, em);
    }

    @Override
    public Occupant getOccupant() {
        return this.occupant;
    }

    @Override
    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }
}
