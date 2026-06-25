package board;

import board.Cell;
import entities.Unit;

public class GameBoard {
    private Cell[][] array;
    public Cell getCell(Position p){
        return array[p.getY()][p.getX()];
    }
    public Unit getOccupant(Position p){

    }
    public void setOccupant(Position p, Unit o){

    }

}
