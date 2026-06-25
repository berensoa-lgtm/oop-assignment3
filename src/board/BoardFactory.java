package board;

import entities.Enemy;
import entities.Occupant;
import entities.Player;
import entities.Unit;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BoardFactory {
    private static final Map<Character, Supplier<Cell>> creators =
    private static final Map<Character, Supplier<Cell>> creators =
            Map.ofEntries(
                    Map.entry('#', Wall::new),
                    Map.entry('.', Floor::new),

                    // --- Monsters ---
                    Map.entry('s', () -> new Floor(new Monster("Golden Cloak", 80, 8, 3, 3, 25))),
                    Map.entry('k', () -> new Floor(new Monster("Knight", 200, 14, 8, 4, 50))),
                    Map.entry('q', () -> new Floor(new Monster("Queen's Guard", 400, 20, 15, 5, 100))),
                    Map.entry('z', () -> new Floor(new Monster("Wright", 600, 30, 15, 3, 100))),
                    Map.entry('b', () -> new Floor(new Monster("Bear", 1000, 75, 30, 4, 250))),
                    Map.entry('g', () -> new Floor(new Monster("Giant", 1500, 100, 40, 5, 500))),
                    Map.entry('w', () -> new Floor(new Monster("White Walker", 2000, 150, 50, 6, 1000))),
                    Map.entry('M', () -> new Floor(new Monster("The Mountain", 1000, 60, 25, 6, 500))),
                    Map.entry('C', () -> new Floor(new Monster("Queen Cersei", 100, 10, 10, 1, 1000))),
                    Map.entry('K', () -> new Floor(new Monster("Night's King", 5000, 300, 150, 8, 5000))),

                    // --- Traps ---
                    // Traps utilize: Name, Health, Attack, and Experience values
                    Map.entry('B', () -> new Floor(new Trap("Bear Trap", 250, 1, 100))),
                    Map.entry('P', () -> new Floor(new Trap("Spike Pit", 1, 100, 250))),
                    Map.entry('D', () -> new Floor(new Trap("Death Trap", 500, 100, 500)))
            );
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
                    if ()
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
