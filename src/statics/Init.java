package statics;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Init {
    public static Plugboard configurePlugboard(List<String> plugboardStringMap) {
        int wireCount = plugboardStringMap.size();
        Map<Character, Character> wireMap = new HashMap<>();

        for(String element : plugboardStringMap) {
            wireMap.put(element.charAt(0), element.charAt(1));
        }

        return new Plugboard(wireCount, wireMap);
    }

    public static Rotor configureRotor(String rotorID, Character position, Character ringSetting) {
        if(position != null)
            return new Rotor(new RotorType().setRotorTypeByID(rotorID), position, ringSetting);
        return new Rotor(new RotorType().setRotorTypeByID(rotorID));
    }

    // Load the user selected options & returns a models.Machine object with chosen configuration
    public static Machine loadData() {
        List<String> plugboardStringMap = new ArrayList<>();
        StringBuilder rotor1Type = new StringBuilder();
        StringBuilder rotor2Type = new StringBuilder();
        StringBuilder rotor3Type = new StringBuilder();
        StringBuilder extraRotorType = new StringBuilder();
        StringBuilder reflectorType = new StringBuilder();
        List<Character> rotorsPositions = new ArrayList<>();
        List<Character> ringsPositions = new ArrayList<>();

        UserInteraction.displayMenu(plugboardStringMap, rotor1Type, rotor2Type, rotor3Type, extraRotorType, reflectorType, rotorsPositions, ringsPositions);

        Plugboard plugboard = configurePlugboard(plugboardStringMap);
        Rotor entryWheel = configureRotor("EKW", null, null);
        Rotor rotor1 = configureRotor(rotor1Type.toString(), rotorsPositions.get(0), ringsPositions.get(0)); // rotorNumber - 1
        Rotor rotor2 = configureRotor(rotor2Type.toString(), rotorsPositions.get(1), ringsPositions.get(1));
        Rotor rotor3 = configureRotor(rotor3Type.toString(), rotorsPositions.get(2), ringsPositions.get(2));
        Rotor extraRotor = configureRotor(extraRotorType.toString(), rotorsPositions.get(3), ringsPositions.get(3));
        Rotor reflector = configureRotor(reflectorType.toString(), null, null);

        return new Machine(plugboard, entryWheel, rotor1, rotor2, rotor3, extraRotor, reflector);
    }
}
