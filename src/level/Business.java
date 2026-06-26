package level;

import board.GameBoard;
import game.GameUnits;

public class Business {
    private GameBoard board;
    private GameUnits units;
    public Business(GameBoard board, GameUnits units){
        this.board = board;
        this.units = units;
    }
    public String stringBoard(){
        return BoardUtils.BoardToString(board);
    }
    public String stringPlayer(){
        return UnitUtils.PlayerToString(units.getPlayer());
    }
    public void enemiesTurn(){
        units.
    }
}
