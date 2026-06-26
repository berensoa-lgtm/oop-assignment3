package level;

import board.BoardFactory;
import board.GameBoard;
import entities.Player;
import entities.Unit;
import game.GameUnits;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private Business b;
    private List<String> lines;

    public Service (List<String> lines, Player player){
        List<Unit> units = new ArrayList<>();
        GameBoard board = new GameBoard(BoardFactory.createCells(lines, units, player));
        GameUnits gameUnits = new GameUnits(units, player);
        this.b = new Business(board, gameUnits);
        this.lines = lines;
    }
    public void level(Scanner s){
        boolean playerAlive = true;
        boolean enemiesAlive = true;
        while(playerAlive && enemiesAlive){
            printBoard();
            printPlayer();
            userTurn(s);
            enemiesTurn();
            gameTick();
        }

    }
    public void printBoard(){
        for (String s : lines){
            System.out.println(s);
        }
    }

    public void printPlayer(){
        System.out.println(b.stringPlayer());
    }

    public String userTurn(Scanner s){
        String input = s.next();
        //validate ?
        return input;
    }

    public void enemiesTurn(){
        b.enemiesTurn();
    }

    public void gameTick(){
        //b.gameTick();
    }
}
