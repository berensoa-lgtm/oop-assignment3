package entities;

import board.Position;
import game.EventManager;

import static entities.InteractionUtils.attack;

public class Trap extends Enemy{
    private int visTime;
    private int invisTime;
    private int tickCount;
    private boolean visible;

    public Trap(String name, int health, int attack, int defense, int exp, int visibilityTime, int invisibilityTime){
        super.initializeEnemyProperties(health, attack, defense, name, exp);
        this.visTime = visibilityTime;
        this.invisTime = invisibilityTime;
        this.tickCount = 0;
        this.visible = true;

    }

    @Override
    public void gameTick() {
        tickCount += 1;
        if(tickCount == visTime && visible || tickCount == invisTime && !visible){
            visible = !visible;
            tickCount = 0;
        }
    }

    @Override
    public Position turn(Player player, EventManager em) {
        if (InteractionUtils.range(this,player) < 2)
            attack(this, player, em);
        return pos;
    }

    @Override
    public char getSymbol(){
        if (!visible)
            return '.';
        else
            return symbol;
    }
}