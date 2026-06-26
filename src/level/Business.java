package level;

import board.*;
import entities.Occupant;
import entities.Player;
import game.GameUnits;

import java.util.List;

public class Business{
    private EventManager eventManager;
    private GameBoard board;
    private GameUnits units;
    public Business(GameBoard board, GameUnits units){
        this.board = board;
        this.units = units;
    }
    public void addListener(EventListener listener) {
        eventManager.addListener(listener);
    }

    public String stringBoard(){
        return BoardUtils.boardToString(board);
    }
    public Player getPlayer(){
        return units.getPlayer();
    }
    public void enemiesTurn(){

    }
    public void gameTick(){
        units.gameTick();
    }

    public void userTurn(char c) {
        Position userPosition = units.getPlayer().getPosition();
        Position toPosition = null;
        if (c == 'w')
            toPosition = userPosition.up();
        else if (c == 'a')
            toPosition = userPosition.left();
        else if (c == 's')
            toPosition = userPosition.down();
        else if (c == 'd')
            toPosition = userPosition.right();
        board.visitCell(toPosition, units.getPlayer(), eventManager);
    }

}
