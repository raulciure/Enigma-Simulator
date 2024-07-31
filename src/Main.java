import javax.lang.model.type.NullType;
import java.util.*;

public class Main {
    private static Plugboard configurePlugboard(List<String> plugboardStringMap) {
        int wireCount = plugboardStringMap.size();
        Map<Character, Character> wireMap = new HashMap<>();

        for(String element : plugboardStringMap) {
            wireMap.put(element.charAt(0), element.charAt(1));
        }

        return new Plugboard(wireCount, wireMap);
    }

    private static Rotor configureRotor(String rotorID, Character position) {
        // Define rotors wiring
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String rotor_I = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        final String rotor_II = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        final String rotor_III = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        final String rotor_IV = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
        final String rotor_V = "VZBRGITYUPSDNHLXAWMJQOFECK";
        final String rotor_VI = "JPGVOUMFYQBENHZRDKASXLICTW";
        final String rotor_VII = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
        final String rotor_VIII = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
        final String extraRotor_beta = "LEYJVCNIXWPBQMDRTAKZGFUHOS";
        final String extraRotor_gamma = "FSOKANUERHMBTIYCWLQPZXVGJD";
        final String reflector_b = "ENKQAUYWJICOPBLMDXZVFTHRGS";
        final String reflector_c = "RDOBJNTKVEHMLFCWZAXGYIPSUQ";

        // Define rotors notches
        final String rotor_I_notches = "Q";
        final String rotor_II_notches = "E";
        final String rotor_III_notches = "V";
        final String rotor_IV_notches = "J";
        final String rotor_V_notches = "Z";
        final String rotor_VI_notches = "ZM";
        final String rotor_VII_notches = "ZM";
        final String rotor_VIII_notches = "ZM";

        Map<Character, Character> wireMap;
        List<Character> notches;

        switch (rotorID) {
            case "I":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_I);
                notches = Utilitaries.createArrayList(rotor_I_notches);
                return new Rotor(wireMap, notches, position);

            case "II":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_II);
                notches = Utilitaries.createArrayList(rotor_II_notches);
                return new Rotor(wireMap, notches, position);

            case "III":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_III);
                notches = Utilitaries.createArrayList(rotor_III_notches);
                return new Rotor(wireMap, notches, position);

            case "IV":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_IV);
                notches = Utilitaries.createArrayList(rotor_IV_notches);
                return new Rotor(wireMap, notches, position);

            case "V":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_V);
                notches = Utilitaries.createArrayList(rotor_V_notches);
                return new Rotor(wireMap, notches, position);

            case "VI":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VI);
                notches = Utilitaries.createArrayList(rotor_VI_notches);
                return new Rotor(wireMap, notches, position);

            case "VII":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VII);
                notches = Utilitaries.createArrayList(rotor_VII_notches);
                return new Rotor(wireMap, notches, position);

            case "VIII":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VIII);
                notches = Utilitaries.createArrayList(rotor_VIII_notches);
                return new Rotor(wireMap, notches, position);
        }
        return null;
    }

    // Load the user selected options & returns a Machine object with chosen configuration
    private static Machine loadData() {
        List<String> plugboardStringMap = new ArrayList<>();
        StringBuilder rotor1Type = new StringBuilder();
        StringBuilder rotor2Type = new StringBuilder();
        StringBuilder rotor3Type = new StringBuilder();
        StringBuilder extraRotorType = new StringBuilder();
        StringBuilder reflectorType = new StringBuilder();
        List<Character> rotorsPositions = new ArrayList<>();

        UserInteraction.displayMenu(plugboardStringMap, rotor1Type, rotor2Type, rotor3Type, extraRotorType, reflectorType, rotorsPositions);

        Plugboard plugboard = configurePlugboard(plugboardStringMap);
        Rotor rotor1 = configureRotor(rotor1Type.toString(), rotorsPositions.get(0)); // rotorNumber - 1
        Rotor rotor2 = configureRotor(rotor2Type.toString(), rotorsPositions.get(1));
        Rotor rotor3 = configureRotor(rotor3Type.toString(), rotorsPositions.get(2));
        Rotor extraRotor = configureRotor(extraRotorType.toString(), rotorsPositions.get(3));
        Rotor reflector = configureRotor(reflectorType.toString(), null);

        return new Machine(plugboard, rotor1, rotor2, rotor3, extraRotor, reflector);
    }

    public static void main(String[] args) {
        Machine enigmaMachine = loadData();

        System.out.println("\nEnigma machine:" + enigmaMachine.toString());

    }
}