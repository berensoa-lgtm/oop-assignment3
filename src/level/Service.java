package level;

import board.BoardFactory;
import board.GameBoard;
import entities.Enemy;
import entities.Player;
import entities.Unit;
import game.GameUnits;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service{
    private Business b;
    private CLI cli;

    public Service (GameBoard gameBoard, GameUnits gameUnits){
        this.b = new Business(gameBoard, gameUnits);
        this.cli = new CLI();
        b.addListener(cli);
    }
    public void level(Scanner s){
        boolean playerAlive = true;
        boolean enemiesAlive = true;
        while(playerAlive && enemiesAlive){
            cli.print(b.getBoard().toString());
            cli.print(b.getPlayer().toString());
            enemiesAlive = userTurn(s);
            playerAlive = enemiesTurn();
            gameTick();
        }

    }
    public boolean userTurn(Scanner s){
        String input = s.next();
        //validate ?
        char c = input.charAt(0);
        boolean enemiesDead = b.userTurn(c);
        if (enemiesDead){
            cli.printWin();
        }
        return enemiesDead;
    }

    public boolean enemiesTurn(){
        boolean playerDied = b.enemiesTurn();
        if (playerDied){
            cli.print(b.getBoard().toString());
            cli.print(b.getPlayer().toString());
            cli.printLose();
        }
        return playerDied;
    }

    public void gameTick(){
        b.gameTick();
    }
}
