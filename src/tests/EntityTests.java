/*
package tests;

import board.BoardFactory;
import board.GameBoard;
import board.Position;
import entities.Enemy;
import entities.Player;
import entities.Warrior;
import game.EventManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class EntityTests {

    private final List<String> MOVEMENT_STRING = List.of(
            "#####",
            "#...#",
            "#.@.#",
            "#...#",
            "#####"
    );

    private final List<String> FIGHT_STRING = List.of(
            "####",
            "#@s#",
            "####"
    );

    private Player createPlayer() {
        return new Warrior("Test", 50, 50, 50, 2);
    }

    GameBoard createBoard(List<String> l, Player p) {
        BoardFactory f = new BoardFactory();
        List<Enemy> enemies = new ArrayList<>();
        return f.createCells(l, enemies, p);
    }
    GameBoard createBoard(List<String> l, List<Enemy> enemies, Player p) {
        BoardFactory f = new BoardFactory();
        return f.createCells(l, enemies, p);
    }

    // =========================
    // MOVEMENT TESTS
    // =========================

    @Test
    void testMoveRight() {
        Player player = createPlayer();
        GameBoard board = createBoard(MOVEMENT_STRING, player);

        Position oldPos = player.getPos();
        Position newPos = oldPos.right();

        board.visitCell(newPos, player, new EventManager());

        assertSame(player, board.getOccupant(newPos).getUnit());
        assertNull(board.getOccupant(oldPos));
    }

    @Test
    void testMoveLeft() {
        Player player = createPlayer();
        GameBoard board = createBoard(MOVEMENT_STRING, player);

        Position oldPos = player.getPos();
        Position newPos = oldPos.left();

        board.visitCell(newPos, player, new EventManager());

        assertSame(player, board.getOccupant(newPos).getUnit());
        assertNull(board.getOccupant(oldPos));
    }

    @Test
    void testMoveIntoWallDoesNothing() {
        List<String> map = List.of(
                "#####",
                "#@..#",
                "#####"
        );

        Player player = createPlayer();
        GameBoard board = createBoard(map, player);

        Position oldPos = player.getPos();
        Position wallPos = oldPos.up(); // wall

        board.visitCell(wallPos, player, new EventManager());

        assertSame(player, board.getOccupant(oldPos).getUnit());
        assertNull(board.getOccupant(wallPos));
    }

    // =========================
    // COMBAT TESTS
    // =========================

    @Test
    void testFightEnemyDoesNotRemovePlayer() {
        Player player = createPlayer();
        GameBoard board = createBoard(FIGHT_STRING, player);

        Position enemyPos = player.getPos().right();

        board.visitCell(enemyPos, player, new EventManager());

        assertNotNull(player);
        //assertTrue(player.isAlive());
    }

    @Test
    void testEnemyExistsOnBoard() {
        Player player = createPlayer();
        List<Enemy> enemies = new ArrayList<>();

        GameBoard board = createBoard(FIGHT_STRING, enemies, player);

        assertFalse(enemies.isEmpty());
    }

    @Test
    void testPlayerPositionUpdatesAfterMove() {
        Player player = createPlayer();
        GameBoard board = createBoard(MOVEMENT_STRING, player);

        Position newPos = player.getPos().right();

        board.visitCell(newPos, player, new EventManager());

        assertEquals(newPos, player.getPos());
    }
}*/
