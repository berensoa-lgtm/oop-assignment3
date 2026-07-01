package entities;

import game.EventManager;

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
        this.abilityName = "Blizzard";
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
            em.publish(name + " cast " + abilityName + ".");
            List<Enemy> inRange = inRangeEnemies(lst);
            currentMana -= manaCost;
            int hits = 0;
            ActionResult result = new ActionResult();
            result.usedAbility();
            while(hits < hitsCount && !inRange.isEmpty())
            {
                int index = rnd.nextInt(inRange.size());
                ActionResult hit = InteractionUtils.specialAbilityAttack(this, inRange.get(index),spellPower, em);
                result.killedEnemies(hit.getEnemiesKilled());
                gainEnemiesExperience(result.getEnemiesKilled(), em);
                for(Enemy e: hit.getEnemiesKilled())
                    inRange.remove(e);
                hits += 1;
            }
            return result;
        }
    }

    @Override
    public void levelUp(EventManager em) {
        int oldHealth = healthPool;
        int oldAttack = attackPoints;
        int oldDefense = defensePoints;
        int oldSpell = spellPower;
        int oldMana = spellPower;

        super.levelUpPlayer();
        manaPool += (25 * playerLevel);
        currentMana = Math.min(manaPool, currentMana + (manaPool / 4));
        spellPower += (10 * playerLevel);

        int health = (healthPool - oldHealth);
        int attack = (attackPoints - oldAttack);
        int defense = (defensePoints - oldDefense);
        em.publish(name + " reached level" + playerLevel + ": +" + health + " health, +" + attack + " attack, +" + defense + " defense, +" + oldMana + " maximum mana, +" + oldSpell +" spell power");
    }

    @Override
    public String toString(){
        String s = super.toString();
        s += "   mana: " + currentMana + "   Spell Power: " + spellPower;
        return s;
    }
}