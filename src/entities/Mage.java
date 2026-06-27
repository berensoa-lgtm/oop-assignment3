package entities;

import level.EventManager;

import java.util.List;
import java.util.Random;

public class Mage extends Player{
    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitsCount, int abilityRange){
        super.initializePlayerProperties(health, attack, defense, name, abilityRange);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount;
    }
    @Override
    public void gameTick(){
        currentMana = Math.min(currentMana + playerLevel, manaPool);
    }

    @Override
    public ActionResult cast(List<Enemy> lst, EventManager em) {
        Random rnd = new Random();
        if(currentMana < manaCost){
            em.publish("can't cast special ability: you don't have enough mana");
            return new ActionResult();
        }
        else {
            List<Enemy> inRange = inRangeEnemies(lst);
            currentMana -= manaCost;
            int hits = 0;
            ActionResult result = new ActionResult();
            while(hits < hitsCount && !inRange.isEmpty())
            {
                int index = rnd.nextInt(inRange.size());
                ActionResult hit = InteractionUtils.specialAbilityAttack(this, inRange.get(index),spellPower, em);
                result.killedEnemies(hit.getEnemiesKilled());
            }
            return result;
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