package entities;

import board.Position;
import level.EventManager;

import java.util.Random;

public class InteractionUtils {
    private static Random rand;
    public InteractionUtils(){
        rand = new Random();
    }
    public static ActionResult attack(Unit attacker, Unit defender, EventManager em){
        em.publish(attacker.name+"engaged in combat with "+defender.name);
        em.publish(attacker.toString());
        em.publish(defender.toString());
        int attackVal = rand.nextInt(0, attacker.attackPoints);
        int defendVal = rand.nextInt(0, defender.defensePoints);
        em.publish(attacker.name+" rolled "+attackVal+" attack points.");
        em.publish(defender.name+" rolled "+defendVal+" attack points.");
        if (attackVal > defendVal) {
            int dmg = attackVal - defendVal;
            em.publish(attacker.name+" dealt "+dmg+" damage to "+defender.name);
            return defender.loseHealth(dmg);
        }
        return new ActionResult();
    }

    public static void specialAbilityAttack(Unit defender, int damage){
        int defense = rand.nextInt(0, defender.defensePoints);
        if(damage > defense)
            defender.loseHealth(damage - defense);
    }

    public static double range(Position a, Position b){
        return 0;
    }
}
