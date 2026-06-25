import Service.LevelService;
import board.BoardFactory;
import board.GameBoard;
import entities.Unit;
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

            // Target the specific level file inside that directory!
            Path levelFilePath = Path.of(directoryPath, "level1.txt");
            System.out.println("Reading file: " + levelFilePath.toAbsolutePath());

            List<String> lines = Files.readAllLines(levelFilePath);
            List<Unit> units = new ArrayList<>();
            GameBoard board = new GameBoard(BoardFactory.createCells(lines, units, player));
            GameUnits un = new GameUnits(units, player);
            LevelService l = new LevelService(board, un);

        } catch(Exception e){
            System.out.println("EXCEPTION: " + e);
        }

    }
}
