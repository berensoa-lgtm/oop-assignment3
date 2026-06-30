package entities;

import board.Position;
import game.EventManager;

import java.util.Random;

public class Monster extends Enemy{
    private int visionRange;

    public Monster(String name, int healthPool, int attack, int defend, int vision, int exp){
        super.initializeEnemyProperties(healthPool,attack,defend,name,exp);
        this.visionRange = vision;

    }

    @Override
    public void gameTick() {

    }

    @Override
    public Position turn(Player player, EventManager em) {
        if(InteractionUtils.range(this, player) < visionRange){
            int disX = pos.getX() - player.getPos().getX();
            int disY = pos.getY() - player.getPos().getY();
            if(Math.abs(disX) > Math.abs(disY)){
                if(disX > 0){
                    return pos.left();
                }
                else{
                    return pos.right();
                }
            }
            else {
                if(disY < 0){
                    return pos.down();
                }
                else {
                    return pos.up();
                }
            }
        }
        else {
            Random rnd = new Random();
            int n = rnd.nextInt(5);
            if(n == 0)
                return pos.up();
            if(n == 1)
                return pos.down();
            if(n==2)
                return pos.left();
            if(n==3)
                return pos.right();
            return pos;
        }
    }

}
