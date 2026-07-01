package board;

import entities.ActionResult;
import entities.CellVisitor;
import entities.Occupant;
import entities.Unit;
import game.EventManager;

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
    public ActionResult visitCell(Position p, Unit u, EventManager em){
        Cell cell = getCell(p);
        return cell.accept(new CellVisitor(u), em);
    }
    public String toString(){
        String s = "";
        for (int a = 0; a < array.length; a++){
            String row = "";
            for (int b = 0; b < array[a].length; b++){
                row += array[a][b].getSymbol();
            }
            s += row + "\n";
        }
        return s;
    }
}