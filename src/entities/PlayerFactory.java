package entities;

import board.Cell;
import board.Floor;
import board.Wall;

import java.util.Map;
import java.util.function.Supplier;

public class PlayerFactory {
    private static final Map<Character, Supplier<Player>> players =
            Map.ofEntries(
                    Map.entry('1', () -> new Warrior("Jon Snow", 300, 30, 4, 3)),
                    Map.entry('2', () -> new Warrior("The Hound", 400, 20, 6, 5)),
                    Map.entry('3', () -> new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6)),
                    Map.entry('4', () -> new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4)),
                    Map.entry('5', () -> new Rogue("Arya Stark", 150, 40, 2, 20)),
                    Map.entry('6', () -> new Rogue("Bronn", 250, 35, 3, 50))
            );
    public static Player createPlayer(char c){
        Supplier<Player> supplier = players.get(c);
        return supplier.get();
    }
}
