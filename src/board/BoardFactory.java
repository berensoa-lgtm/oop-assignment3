package board;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BoardFactory {
    private final Map<Character, Supplier<Cell>> BASE_CREATORS =
            Map.ofEntries(
                    Map.entry('#', Wall::new),
                    Map.entry('.', Floor::new),
                    Map.entry('s', () -> {
                        return handleEnemy(new Monster("Golden Cloak", 80, 8, 3, 3, 25));
                    }),
                    Map.entry('k', () -> {
                        return handleEnemy(new Monster("Knight", 200, 14, 8, 4, 50));
                    }),
                    Map.entry('q', () -> {
                        return handleEnemy(new Monster("Queen's Guard", 400, 20, 15, 5, 100));
                    }),
                    Map.entry('z', () -> {
                        return handleEnemy(new Monster("Wright", 600, 30, 15, 3, 100));
                    }),
                    Map.entry('b', () -> {
                        return handleEnemy(new Monster("Bear", 1000, 75, 30, 4, 250));
                    }),
                    Map.entry('g', () -> {
                        return handleEnemy(new Monster("Giant", 1500, 100, 40, 5, 500));
                    }),
                    Map.entry('w', () -> {
                        return handleEnemy(new Monster("White Walker", 2000, 150, 50, 6, 1000));
                    }),
                    Map.entry('M', () -> {
                        return handleEnemy(new Monster("The Mountain", 1000, 60, 25, 6, 500));
                    }),
                    Map.entry('C', () -> {
                        return handleEnemy(new Monster("Queen Cersei", 100, 10, 10, 1, 1000));
                    }),
                    Map.entry('K', () -> {
                        return handleEnemy(new Monster("Night's King", 5000, 300, 150, 8, 5000));
                    }),

                    Map.entry('B', () -> {
                        return handleEnemy(new Trap("Bonus", 1, 1, 1, 250, 1, 5));
                    }),
                    Map.entry('Q', () -> {
                        return handleEnemy(new Trap("Queen's Trap", 250, 50, 10, 100, 3, 7));
                    }),
                    Map.entry('D', () -> {
                        return handleEnemy(new Trap("Death Trap", 500, 100, 20, 250, 1, 10));
                    })
            );
    private final List<Enemy> enemies = new ArrayList<>();
    public GameBoard createCells(List<String> lines, List<Enemy> enemiesPopulate, Player player){
        Cell[][] cells = new Cell[lines.size()][lines.get(0).length()];
        Map<Character, Supplier<Cell>> creators = new HashMap<>(BASE_CREATORS);
        creators.put('@', () -> new Floor(player));


        for (int row = 0; row < lines.size(); row++){

            String l = lines.get(row);
            for (int i = 0; i < l.length(); i++){

                char c = l.charAt(i);
                Supplier<Cell> supplier = creators.get(c);
                if (supplier == null) {
                    supplier = Floor::new;
                }
                Cell cell = supplier.get();
                cell.setSymbol(c);
                cells[row][i] = cell;
                Occupant occupant = cell.getOccupant();
                if (occupant != null) {
                    Unit unit = occupant.getUnit();
                    unit.setPos(new Position(i, row));
                }
            }
        }
        enemiesPopulate.addAll(enemies);
        return new GameBoard(cells);
    }
    private Floor handleEnemy(Enemy e) {
        enemies.add(e);
        return new Floor(e);
    }

}
