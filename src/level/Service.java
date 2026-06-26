package level;

import board.BoardFactory;
import board.GameBoard;
import entities.Player;
import entities.Unit;
import game.GameUnits;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service{
    private Business b;
    private CLI cli;
    private List<String> lines;

    public Service (List<String> lines, Player player){
        List<Unit> units = new ArrayList<>();
        GameBoard board = new GameBoard(BoardFactory.createCells(lines, units, player));
        GameUnits gameUnits = new GameUnits(units, player);
        this.b = new Business(board, gameUnits);
        this.cli = new CLI();
        b.addListener(cli);
        this.lines = lines;
    }
    public void level(Scanner s){
        boolean playerAlive = true;
        boolean enemiesAlive = true;
        while(playerAlive && enemiesAlive){
            cli.printBoard(lines);
            cli.printPlayer(b.getPlayer().toString());
            userTurn(s);
            enemiesTurn();
            gameTick();
        }

    }
    public String userTurn(Scanner s){
        String input = s.next();
        //validate ?
        char c = input.charAt(0);
        b.userTurn(c);
        return input;
    }

    public void enemiesTurn(){
        b.enemiesTurn();
    }

    public void gameTick(){
        //b.gameTick();
    }
}
