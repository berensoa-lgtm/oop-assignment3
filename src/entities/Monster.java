package entities;

import board.Position;
import game.EventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class Monster extends Enemy{
    private int visionRange;



    public Monster(String name, int healthPool, int attack, int defend, int vision, int exp){
        super.initializeEnemyProperties(healthPool,attack,defend,name,exp);
        this.visionRange = vision;
    }

    @Override
    public void gameTick() { }


    @Override
    public Position turn(Player player, EventManager em) {
        if(InteractionUtils.range(this, player) < visionRange){
            return MovementUtils.chasePlayer(player,this);
        }
        else {
            return MovementUtils.randomEnemyMovement(this);
        }
    }

}
