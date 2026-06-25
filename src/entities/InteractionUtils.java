package entities;

import java.util.Random;

public class InteractionUtils {
    private static Random rand;
    public InteractionUtils(){
        rand = new Random();
    }
    public static void attack(Unit attacker, Unit defender){
        int attackVal = rand.nextInt(0, attacker.attackPoints);
        int defendVal = rand.nextInt(0, defender.defensePoints);
        if (attackVal > defendVal) {
            defender.loseHealth(attackVal);
        }
    }
}
