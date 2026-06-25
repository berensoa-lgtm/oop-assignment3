package board;

import entities.*;

public class Floor implements Cell{
    private Occupant occupant;
    public Floor(Occupant o){
        this.occupant = o;
    }
    public String accept(CellVisitor v){
        return v.visit(this);
    }

    @Override
    public Occupant getOccupant() {
        return this.occupant;
    }

    @Override
    public void setOccupant(Occupant occupant) {
    }
}
