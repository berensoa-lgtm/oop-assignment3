package tests;

import board.BoardFactory;
import board.GameBoard;
import board.Position;
import entities.*;
import game.EventManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
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

    private final List<String> CHASE_STRING = List.of(
            "#####",
            "#@.s#",
            "#####"
    );

    Player warrior;
    Player mage;
    Player rogue;
    Enemy monster;
    Trap trap;



    @BeforeEach
    void setUp(){
        trap = new Trap("test",5,20,1,30,1,1);
        warrior = new Warrior("Test", 50, 50, 50, 2);
        mage = new Mage("test",20,20,30,140,15,30, 3,3);
        rogue = new Rogue("test",30,20,15,60);
        monster = new Monster("Knight", 5, 10, 5, 3,25);
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
        GameBoard board = createBoard(MOVEMENT_STRING, warrior);

        Position oldPos = warrior.getPos();
        Position newPos = oldPos.right();

        board.visitCell(newPos, warrior, new EventManager());

        assertSame(warrior, board.getOccupant(newPos).getUnit());
        assertNull(board.getOccupant(oldPos));
    }

    @Test
    void testMoveLeft() {
        GameBoard board = createBoard(MOVEMENT_STRING, mage);
        Position oldPos = mage.getPos();
        Position newPos = oldPos.left();

        board.visitCell(newPos, mage, new EventManager());

        assertSame(mage, board.getOccupant(newPos).getUnit());
        assertNull(board.getOccupant(oldPos));
    }

    @Test
    void testMoveIntoWallDoesNothing() {
        GameBoard board = createBoard(CHASE_STRING, warrior);
        Position oldPos = warrior.getPos();
        Position wallPos = oldPos.up(); // wall
        board.visitCell(wallPos, warrior, new EventManager());

        assertSame(warrior, board.getOccupant(oldPos).getUnit());
        assertNull(board.getOccupant(wallPos));
    }

    @Test
    void enemyChasesPlayer(){
        List<Enemy> enemies = new ArrayList<>();
        GameBoard board = createBoard(CHASE_STRING, enemies, rogue);
        Enemy e = enemies.get(0);
        double oldR = InteractionUtils.range(e,rogue);
        EventManager em = new EventManager();
        board.visitCell(e.turn(rogue,em),e,em);

        assertTrue(InteractionUtils.range(rogue,e)< oldR);
    }

    @Test
    void testTrapVisibility(){
        boolean visible1 = trap.isVisible();
        trap.gameTick();
        assertNotEquals(visible1,trap.isVisible());
        trap.gameTick();
        assertEquals(visible1,trap.isVisible());
    }


    // =========================
    // COMBAT TESTS
    // =========================

    @Test
    void testFightEnemyDoesNotRemovePlayer() {
        GameBoard board = createBoard(FIGHT_STRING, warrior);
        Position enemyPos = warrior.getPos().right();
        board.visitCell(enemyPos, warrior, new EventManager());

        assertNotNull(warrior);
    }

    @Test
    void testCastWarrior(){
        List<Enemy> enemies = new ArrayList<>();
        EventManager em = new EventManager();
        ActionResult res = warrior.cast(enemies,em);
        assertTrue(res.getUsedAbility());
        res = warrior.cast(enemies,em);
        assertFalse(res.getUsedAbility()); //cooldown isn't over yet
        for(int i = 0; i < 2; i++){
            warrior.gameTick();
        }
        res = warrior.cast(enemies,em);
        assertTrue(res.getUsedAbility()); //cooldown over

    }

    @Test
    void testCastMage(){
        List<Enemy> enemies = new ArrayList<>();
        EventManager em = new EventManager();
        ActionResult res = mage.cast(enemies,em);
        assertTrue(res.getUsedAbility());
        res = mage.cast(enemies,em);
        assertTrue(res.getUsedAbility());
        res = mage.cast(enemies,em);
        assertFalse(res.getUsedAbility()); //not enough mana to cast ability
    }

    @Test
    void testCastRogue(){
        List<Enemy> enemies = new ArrayList<>();
        EventManager em = new EventManager();
        ActionResult res = rogue.cast(enemies,em);
        assertTrue(res.getUsedAbility());
        res = rogue.cast(enemies,em);
        assertFalse(res.getUsedAbility()); //not enough energy to cast ability
    }

    @Test
    void testEnemyExistsOnBoard() {
        List<Enemy> enemies = new ArrayList<>();
        createBoard(FIGHT_STRING, enemies, rogue);

        assertFalse(enemies.isEmpty());
    }

    @Test
    void testPlayerPositionUpdatesAfterMove() {
        GameBoard board = createBoard(MOVEMENT_STRING, mage);
        Position newPos = mage.getPos().right();
        board.visitCell(newPos, mage, new EventManager());

        assertSame(newPos, mage.getPos());
    }


    @Test
    void testEnemyDied(){
        EventManager em = new EventManager();
        int exp = monster.getExperienceValue();
        ActionResult res = InteractionUtils.specialAbilityAttack(warrior,monster,15,em);
        assertFalse(res.getEnemiesKilled().isEmpty());
        //gainEnemiesExperience(res.getEnemiesKilled(),em);
        assertEquals(exp,warrior.getExperience());
    }

    @Test
    void testRegularAttack(){

    }

    @Test
    void testLevelUp(){

    }

    @Test
    void testEnemyDefend(){

    }

    @Test
    void testEnemyAttack(){

    }
    @Test
    void testPlayerDefend(){

    }
}