package entities;

import board.Cell;
import board.Floor;
import board.Wall;

import java.util.Map;
import java.util.function.Supplier;

public class PlayerFactory {
    private static final Map<Character, Supplier<Cell>> players =
            Map.ofEntries(
                    Map.entry('1', Wall::new),
                    Map.entry('2', Floor::new),
                    Map.entry('3', () -> new Floor(new Monster("Golden Cloak", 80, 8, 3, 3, 25))),
                    Map.entry('k', () -> new Floor(new Monster("Knight", 200, 14, 8, 4, 50))),
                    Map.entry('q', () -> new Floor(new Monster("Queen's Guard", 400, 20, 15, 5, 100))),
                    Map.entry('z', () -> new Floor(new Monster("Wright", 600, 30, 15, 3, 100))),
                    Map.entry('b', () -> new Floor(new Monster("Bear", 1000, 75, 30, 4, 250))),
                    Map.entry('g', () -> new Floor(new Monster("Giant", 1500, 100, 40, 5, 500))),
                    Map.entry('w', () -> new Floor(new Monster("White Walker", 2000, 150, 50, 6, 1000))),
                    Map.entry('M', () -> new Floor(new Monster("The Mountain", 1000, 60, 25, 6, 500))),
                    Map.entry('C', () -> new Floor(new Monster("Queen Cersei", 100, 10, 10, 1, 1000))),
                    Map.entry('K', () -> new Floor(new Monster("Night's King", 5000, 300, 150, 8, 5000))),

                    Map.entry('B', () -> new Floor(new Trap("Bonus", 1, 1, 1, 250, 1, 5))),
                    Map.entry('Q', () -> new Floor(new Trap("Queen's Trap", 250, 50, 10, 100, 3, 7))),
                    Map.entry('D', () -> new Floor(new Trap("Death Trap", 500, 100, 20, 250, 1, 10)))
            );
}
