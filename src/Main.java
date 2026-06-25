import board.BoardUtils;
import board.GameBoard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("no args");
        }

        String path = args[0];
        List<String> lines = Files.readAllLines(Path.of(path));
        GameBoard = new GameBoard(BoardUtils.toCells(lines));
    }
}
