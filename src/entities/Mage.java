package entities;

import java.util.List;
import java.util.Random;

public class Mage extends Player{
    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super.initializeProperties(health, attack, defense, name);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRange;
    }
    @Override
    public void gameTick(){

    }

    @Override
    public void cast(List<Unit> inRangeEnemies) {
        Random rnd = new Random();
        boolean enemiesExist = true;
        if(currentMana < manaCost){
            System.out.println("can't cast special ability: you don't have enough mana");
        }
        else {
            currentMana -= manaCost;
            int hits = 0;
            while(hits < hitsCount && !inRangeEnemies.isEmpty())
            {
                int index = rnd.nextInt(inRangeEnemies.size());
                InteractionUtils.specialAbilityAttack(inRangeEnemies.get(index),spellPower);
            }
        }
    }

    @Override
    public void levelUp() {
        super.levelUpPlayer();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(manaPool, currentMana + (manaPool / 4));
        spellPower += (10 * playerLevel);
    }

}