package level;

import java.util.List;

public class CLI implements EventListener {
    @Override
    public void onEvent(String message) {
        System.out.println(message);
    }
    public void printBoard(List<String> lines){
        for (String s : lines){
            System.out.println(s);
        }
    }
    public void printPlayer(String s){
        System.out.println(s);
    }
}
