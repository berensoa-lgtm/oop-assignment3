public class GameBoard {
    private Cell[][] array;
    public Cell getCell(Position p){
        return array[p.getY()][p.getX()];
    }
    public Occupant getOccupant(Position p){

    }
    public void setOccupant(Position p, Occupant o){

    }
}
