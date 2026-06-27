package level;

import board.*;
import entities.ActionResult;
import entities.Enemy;
import entities.Occupant;
import entities.Player;
import entities.Unit;
import game.GameUnits;

import java.util.ArrayList;
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
    public void gameTick(){
        units.gameTick();
    }

    public boolean userTurn(char c) {
        Player player = units.getPlayer();
        Position userPosition = player.getPos();
        Position toPosition = null;
        ActionResult result = null;
        if (c == 'e'){
            result = player.cast(units.getEnemies());
        } else{
            if (c == 'w')
                toPosition = userPosition.up();
            else if (c == 'a')
                toPosition = userPosition.left();
            else if (c == 's')
                toPosition = userPosition.down();
            else if (c == 'd')
                toPosition = userPosition.right();
            result = board.visitCell(toPosition, player, eventManager);
        }

        if (result.getMoved()){
            moveUnit(player, userPosition, toPosition);
        }
        else if (!result.getEnemiesKilled().isEmpty()){
            units.kill(result.getEnemiesKilled());
            removeUnits(result.getEnemiesKilled());
        }
    }
    public boolean enemiesTurn(){
        for (Enemy enemy : units.getEnemies()){
            Position oldPos = enemy.getPos();
            ActionResult result = enemy.turn(units.getPlayer(), eventManager);
            if (result.getMoved()){
                moveUnit(enemy, oldPos, enemy.getPos());
            } else if (result.getPlayerDied() != null){
                removeUnits(List.of(result.getPlayerDied()));
                return true;
            }
        }
        return false;
    }
    private void moveUnit(Unit u, Position oldPos, Position newPos){
        board.setOccupant(newPos, new Occupant(u));
        board.setOccupant(oldPos, null);
        char temp = board.getCell(newPos).getSymbol();
        board.getCell(newPos).setSymbol(board.getCell(oldPos).getSymbol());
        board.getCell(oldPos).setSymbol(temp);
        u.setPos(newPos);
    }
    private void removeUnits(List<Unit> toRemove){
        for (Unit u : toRemove){
            board.setOccupant(u.getPos(), null);
        }
    }

    public GameBoard getBoard() {
        return board;
    }
}
