package board;

import entities.*;

public class Floor implements Cell{
    private Occupant occupant;
    public Floor(){
        this.occupant = null;
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
        this.occupant = occupant;
    }
}
