package level;

import board.GameBoard;
import board.BoardUtils;
import game.GameUnits;

public class Business {
    private GameBoard board;
    private GameUnits units;
    public Business(GameBoard board, GameUnits units){
        this.board = board;
        this.units = units;
    }
    public String stringBoard(){
        return BoardUtils.boardToString(board);
    }
    public String stringPlayer(){
        return units.getPlayer().toString();
    }
    public void enemiesTurn(){

    }
}
