package Service;

import board.GameBoard;
import game.GameUnits;

public class LevelService {
    private GameBoard board;
    private GameUnits units;
    public LevelService(GameBoard board, GameUnits units){
        this.board = board;
        this.units = units;
    }
    public void startLevel(){
        boolean playerAlive = true;
        boolean enemyAlive = true;
        while(playerAlive && enemyAlive){
            // print board
            // show player stats
            //
        }
    }
}
