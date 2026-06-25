package board;

import board.Cell;
import entities.Occupant;
import entities.Unit;

public class GameBoard {
    private Cell[][] array;
    public GameBoard(Cell[][] a){
        array = a;
    }
    public Cell getCell(Position p){
        return array[p.getY()][p.getX()];
    }
    public Occupant getOccupant(Position p){
        Cell cell = getCell(p);
        return cell.getOccupant();
    }
    public void setOccupant(Position p, Occupant o){
        Cell cell = getCell(p);
        cell.setOccupant(o);
    }
}
