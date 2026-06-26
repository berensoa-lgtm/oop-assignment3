package level;

import java.util.Scanner;

public class Service {
    private Business b;

    public Service (Business b){
        this.b = b;
    }
    public void level(){
        Scanner s = new Scanner();
        printChoosePlayer();
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
    public String printChoosePlayer(){

    }
    public String printBoard(){
        b.stringBoard();
    }
    public String printPlayer(){
        Player p = b.getPlayer();
    }
    public String userTurn(Scanner s){
        String s = s.next();
    }
    public void enemiesTurn(){
        b.enemiesTurn();
    }
    public void gameTick(){
        b.gameTick();
    }
}
