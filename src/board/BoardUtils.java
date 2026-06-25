package board;

import entities.Player;
import entities.Unit;

import java.util.List;

public class BoardUtils {
    public static Cell[][] toCells(List<String> lines){
        Cell[][] cells = new Cell[lines.size()][lines.get(0).length()];
        for (int row = 0; row < lines.size(); row++){

            String l = lines.get(row);
            for (int i = 0; i < l.length(); i++){

                char c = l.charAt(i);
                if (c == '#')
                    initializeWall(cells, i, row);
                else{
                    Floor f = initializeFloor(cells, i , row);
                    if (c == 's')
                        initializeOccupant(f, new Monster());
                }
            }
        }
    }

    public static void initializeWall(Cell[][] cells, int x, int y){
        cells[y][x] = new Wall();
    }
    public static Floor initializeFloor(Cell[][] cells, int x, int y){
        Floor f = new Floor();
        cells[y][x] = f;
        return f;
    }
    public static void initializeOccupant(Floor f, Unit u){

    }
}
