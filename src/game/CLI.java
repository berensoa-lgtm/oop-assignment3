package game;

public class CLI implements EventListener {
    @Override
    public void onEvent(String message) {
        System.out.println(message);
    }
    public void print(String s){
        System.out.println(s);
    }
    public void printWin(){System.out.println("You won!");}
    public void printLose(){System.out.println("Game Over");}
}