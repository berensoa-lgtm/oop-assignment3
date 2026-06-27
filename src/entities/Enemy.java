package entities;

import board.Position;
import level.EventManager;

public abstract class Enemy extends Unit {
    protected int experienceValue;

    public void initializeEnemyProperties(int health, int attack, int defense, String name, int experience){
        super.initializeProperties(health, attack, defense, name);
        this.experienceValue = experience;
    }

    @Override
    public ActionResult initializeInteraction(Enemy e, EventManager em){
        return new ActionResult();
    }
    @Override
    public ActionResult initializeInteraction(Player p, EventManager em){
        return InteractionUtils.attack(this, p, em);
    }
    public ActionResult loseHealth(int dmg, EventManager em){
        healthAmount -= dmg;
        ActionResult result = new ActionResult();
        if (healthAmount <= 0){
            result.killedEnemy(this);
        }
        return result;
    }
    @Override
    public ActionResult accept(OccupantVisitor occupantVisitor, EventManager em){
        return occupantVisitor.visit(this, em);
    }

    public abstract Position turn(Player player, EventManager em);
}
