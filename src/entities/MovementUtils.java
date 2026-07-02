package entities;

import board.Position;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class MovementUtils {

    public static final List<Character> MOVEMENT_LIST = List.of('w','a','s','d','q');
    private static final Map<Character, Function<Position, Position>> MOVEMENT_MAP = Map.of(
            'w', Position::up,
            'a', Position::left,
            's', Position::down,
            'd', Position::right,
            'q', pos -> pos);

    public static Position randomEnemyMovement(Enemy enemy){
        Random rnd = new Random();
        int n = rnd.nextInt(5);
        char move = MOVEMENT_LIST.get(n);
        return MOVEMENT_MAP.get(move).apply(enemy.getPos());
    }

    public static Position chasePlayer(Player player,Enemy enemy){
        int disX = enemy.getPos().getX() - player.getPos().getX();
        int disY = enemy.getPos().getY() - player.getPos().getY();
        if(Math.abs(disX) > Math.abs(disY)){
            return disX > 0 ? enemy.getPos().left() : enemy.getPos().right();
        }
        else {
            return disY < 0 ? enemy.getPos().down() : enemy.getPos().up();
        }
    }

    public static Position playerMove(char c, Position pos){
        return MOVEMENT_MAP.get(c).apply(pos);
    }
}

