package game;

import board.*;
import entities.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GameController {
    private EventManager eventManager;
    private GameBoard board;
    private GameUnits units;


    public GameController(GameBoard board, GameUnits units){
        this.board = board;
        this.units = units;
        this.eventManager = new EventManager();
    }
    public void addListener(EventListener listener) {
        eventManager.addListener(listener);
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
        ActionResult result;
        if (c == 'e'){
            result = player.cast(units.getEnemies(), eventManager);
        } else{
            toPosition = MovementUtils.playerMove(c,userPosition);
            result = board.visitCell(toPosition, player, eventManager);
        }

        if (result.getMoved()){
            moveUnit(player, userPosition, toPosition);
        }
        else if (!result.getEnemiesKilled().isEmpty()){
            units.kill(result.getEnemiesKilled());
            removeEnemies(result.getEnemiesKilled());
        }

        return units.getEnemies().isEmpty();
    }
    public boolean enemiesTurn(){
        for (Enemy enemy : units.getEnemies()){
            Position oldPos = enemy.getPos();
            Position newPos = enemy.turn(units.getPlayer(), eventManager);
            ActionResult result = board.visitCell(newPos, enemy, eventManager);
            if (result.getMoved()){
                moveUnit(enemy, oldPos, newPos);
            } else if (result.getPlayerDied() != null) {
                removePlayer(result.getPlayerDied());
                return true;
            }
        }
        return false;
    }
    private void moveUnit(Unit u, Position oldPos, Position newPos){
        board.setOccupant(newPos, new Occupant(u));
        board.setOccupant(oldPos, null);
        u.setPos(newPos);
    }
    private void removeEnemies(List<Enemy> toRemove){
        for (Unit u : toRemove){
            board.setOccupant(u.getPos(), null);
        }
    }
    private void removePlayer(Player p){
        board.setOccupant(p.getPos(), null);
    }

    public GameBoard getBoard() {
        return board;
    }
}