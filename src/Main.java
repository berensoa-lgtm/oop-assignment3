import board.BoardFactory;
import board.GameBoard;
import entities.Unit;
import game.GameService;
import game.GameUnits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("no args");
        }
        try{
            String directoryPath = args[0];
            System.out.println("Loading from directory: " + directoryPath);
            ArrayList<List<String>> levels = new ArrayList<>();

            int level = 1;
            Path path = Path.of(directoryPath, "level" + level + ".txt");

            while (Files.exists(path)) {
                levels.add(Files.readAllLines(path));

                level++;
                path = Path.of(directoryPath, "level" + level + ".txt");
            }
            GameService GAME = new GameService(levels);

            GAME.startGame();

        } catch(Exception e){
            System.out.println("EXCEPTION: " + e);
        }

    }
}
