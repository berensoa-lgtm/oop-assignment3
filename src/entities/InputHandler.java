package entities;

import java.util.HashSet;
import java.util.Set;

public class InputHandler {

    private static final Set<Character> VALID_TURN_INPUTS;
    private static final Set<Character> VALID_PLAYER_INPUTS;


    static {
        VALID_TURN_INPUTS = new java.util.HashSet<>(MovementUtils.MOVEMENT_LIST);
        VALID_TURN_INPUTS.add('e');
        VALID_PLAYER_INPUTS = new java.util.HashSet<>(PlayerFactory.PLAYER_INDEXES);
    }

    public static boolean isValidTurnInput(char c) {
        return VALID_TURN_INPUTS.contains(c);
    }

    public static boolean isValidCharacter(char c) {
        return VALID_PLAYER_INPUTS.contains(c);
    }
}

