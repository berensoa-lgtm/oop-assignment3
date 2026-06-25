package board;

import entities.*;

public class Floor {
    private Occupant occupant;
    public Floor(Occupant o){
        this.occupant = o;
    }
    public String accept(CellVisitor v){
        return v.visit(this);
    }

    public Occupant getOccupant() {
        return this.occupant;
    }

    public void setOccupant(Occupant occupant) {
    }
}
