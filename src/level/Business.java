package level;

import board.*;
import entities.ActionResult;
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
        this.eventManager = new EventManager();
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
        Position userPosition = units.getPlayer().getPos();
        Position toPosition = null;
        if (c == 'w')
            toPosition = userPosition.up();
        else if (c == 'a')
            toPosition = userPosition.left();
        else if (c == 's')
            toPosition = userPosition.down();
        else if (c == 'd')
            toPosition = userPosition.right();
        ActionResult result = (board.visitCell(toPosition, units.getPlayer(), eventManager));
    }

    public GameBoard getBoard() {
        return board;
    }
}
