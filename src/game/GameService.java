package game;

import board.BoardFactory;
import board.GameBoard;
import entities.Player;
import entities.PlayerFactory;
import entities.Unit;
import level.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameService {
    private Service level;
    private Scanner scanner;
    private List<List<String>> levels;
    private final String selectPlayer = """
            Select player:
            1. Jon Snow             Health: 300/300         Attack: 30              Defense: 4              Level: 1                Experience: 0/50                Cooldown: 0/3
            2. The Hound            Health: 400/400         Attack: 20              Defense: 6              Level: 1                Experience: 0/50                Cooldown: 0/5
            3. Melisandre           Health: 100/100         Attack: 5               Defense: 1              Level: 1                Experience: 0/50                Mana: 75/300            Spell Power: 15
            4. Thoros of Myr                Health: 250/250         Attack: 25              Defense: 4              Level: 1                Experience: 0/50                Mana: 37/150            Spell Power: 20
            5. Arya Stark           Health: 150/150         Attack: 40              Defense: 2              Level: 1                Experience: 0/50                Energy: 100/100
            6. Bronn                Health: 250/250         Attack: 35              Defense: 3              Level: 1    \s
            """;
    public GameService(List<List<String>> levels){
        this.levels = levels;
        this.scanner = new Scanner(System.in);
        Player player = initializePlayer();
        Service l = new Service(levels.get(0), player);
        this.level = l;
    }
    public Player initializePlayer(){
        System.out.println(selectPlayer);
        String userInput = scanner.next();
        char c = userInput.charAt(0);
        return PlayerFactory.createPlayer(c);
    }
    public void startGame(){
        level.level(scanner);
    }
}
