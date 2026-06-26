package board;

import board.Cell;
import entities.CellVisitor;
import entities.Occupant;
import entities.Unit;
import level.EventManager;

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
    public void visitCell(Position p, Unit u, EventManager em){
        Cell cell = getCell(p);
        cell.accept(new CellVisitor(u), em);
    }
}
