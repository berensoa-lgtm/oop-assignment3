package entities;

import game.EventManager;

import java.util.Random;

public class InteractionUtils {
    private static final Random rand = new Random();

    public static ActionResult attack(Unit attacker, Unit defender, EventManager em){
        em.publish(attacker.name+"engaged in combat with "+defender.name);
        em.publish(attacker.toString());
        em.publish(defender.toString());
        int attackVal = rand.nextInt(0, attacker.attackPoints);
        int defendVal = rand.nextInt(0, defender.defensePoints);
        em.publish(attacker.name+" rolled "+attackVal+" attack points.");
        em.publish(defender.name+" rolled "+defendVal+" defense points.");
        if (attackVal > defendVal) {
            int dmg = attackVal - defendVal;
            em.publish(attacker.name+" dealt "+ dmg +" damage to "+defender.name);
            return defender.loseHealth(dmg, em);
        }
        return new ActionResult();
    }

    public static ActionResult specialAbilityAttack(Unit attacker, Unit defender, int damage, EventManager em){
        int defense = rand.nextInt(0, defender.defensePoints);
        em.publish(defender.name+" rolled "+defense+" defense points.");
        if(damage > defense){
            em.publish(attacker.name+" dealt "+ (damage - defense) +" damage to "+defender.name);
            return defender.loseHealth(damage - defense, em);
        }
        return new ActionResult();
    }

    public static double range(Unit a, Unit b){
        int disX = (int)(Math.pow((a.getPos().getX() - b.getPos().getX()),2));
        int disY = (int)(Math.pow((a.getPos().getY() - b.getPos().getY()),2));
        return Math.sqrt(disX + disY);
    }
}
