package entities;

import board.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Unit {
    protected int experience;
    protected int playerLevel;

    public abstract void cast(List<Unit> inRangeEnemies);
    public abstract void levelUp();
    public abstract void gameTick();

    protected List<Unit> inRangeEnemies(int abilityRange){
        List<Unit> list = new ArrayList<>();
        //find the right way to get the list of all units
        List<Unit> allUnits = new ArrayList<>();  //for now allUnits is a placeHolder
        for (Unit enemy: allUnits){
            double range = Range(this,enemy);
            if(range < abilityRange && range != 0)
                list.add(enemy);
        }
        return list;
    }



    protected void initializeProperties(int health, int attack, int defense, String name){
        super.initializeProperties(health, attack, defense);
        this.experience = 0;
        this.playerLevel = 1;
        this.name = name;
    }

    protected void levelUpPlayer(){
        this.experience = experience - (50 * playerLevel);
        this.playerLevel += 1;
        this.healthPool += 10 * playerLevel;
        this.healthAmount = healthPool;
        this.attackPoints += 4 * playerLevel;
        this.defensePoints += playerLevel;
    }
    public String initializeInteraction(Enemy e){
        return "nothing";
    }

    public String initializeInteraction(Player p){
        InteractionUtils.attack(this, p);
        return "";
    }
    public void loseHealth(int dmg){
        healthAmount -= dmg;
    }
    @Override
    String accept(OccupantVisitor occupantVisitor, EventManager em) {
        return null;
    }
    @Override
    public String toString(){
        String s = super.toString();
        s+="Level: "+playerLevel+"   ";
        s+= "Experience: "+experience+"   ";
        return s;
    }
}
