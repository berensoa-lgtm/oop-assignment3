package entities;

import level.EventManager;

public abstract class Enemy extends Unit {
    protected int experienceValue;

    @Override
    public ActionResult initializeInteraction(Enemy e, EventManager em){
        return new ActionResult();
    }
    @Override
    public ActionResult initializeInteraction(Player p, EventManager em){
        return InteractionUtils.attack(this, p, em);
    }
    public ActionResult loseHealth(int dmg){
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

    public abstract ActionResult turn(Player player);
}
