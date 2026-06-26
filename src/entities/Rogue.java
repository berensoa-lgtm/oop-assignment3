package entities;

public class Rogue extends Player{
    private int cost;
    private int currentEnergy;

    public Rogue(String name, int health, int attack, int defense, int cost){
        super.initializeProperties(health, attack, defense);
        this.cost = cost;
        this.currentEnergy = 100;
        this.name = name;
    }

    @Override
    public void cast() {
        if(currentEnergy < cost){
            //can't cast ability
        }
        else {
            currentEnergy -= cost;
            //cast ability

        }
    }

    @Override
    public void gameTick(){

    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        currentEnergy = 100;
        attackPoints += (3 * playerLevel);
    }
}