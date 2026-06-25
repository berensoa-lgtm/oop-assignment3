package board;

import board.Cell;
import entities.CellVisitor;

public class Wall implements Cell {
    public String accept(CellVisitor v){
        return v.visit(this);
    }
}
