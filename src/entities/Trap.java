package entities;

public class Trap extends Enemy{
    private int visTime;
    private int invisTime;
    private int tickCount;
    private boolean visible;

    public Trap(int visibilityTime, int invisibilityTime){
        this.visTime = visibilityTime;
        this.invisTime = invisibilityTime;
        this.tickCount = 0;
        this.visible = true;
    }
    @Override
    String accept(OccupantVisitor occupantVisitor) {
        return null;
    }
}
