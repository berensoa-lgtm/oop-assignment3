package game;

import board.GameBoard;
import entities.InputHandler;

import java.util.Scanner;

public class LevelService {
    private GameController b;
    private CLI cli;


    public LevelService(GameBoard gameBoard, GameUnits gameUnits, CLI cli){
        this.b = new GameController(gameBoard, gameUnits);
        this.cli = new CLI();
        b.addListener(cli);
    }
    public boolean startLevel(Scanner s){
        boolean playerDead = false;
        boolean enemiesDead = false;
        while(!playerDead && !enemiesDead){
            cli.print(b.getBoard().toString());
            cli.print(b.getPlayer().toString());
            enemiesDead = userTurn(s);
            playerDead = enemiesTurn();
            gameTick();
        }
        return enemiesDead;
    }
    public boolean userTurn(Scanner s){
        String input = s.nextLine();
        while(input.length() != 1 || !InputHandler.isValidTurnInput(input.charAt(0))) {
            cli.print("invalid instructions for next move");
            input = s.nextLine();
        }
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