import java.util.HashMap;
import java.util.Map;

public class Main {
    private static void setup() {
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
    }

    private static void display(Map<Character, Character> plugboardMap, int rotor1Type,
                                int rotor2Type, int rotor3Type, int extraRotorType, int reflectorType) {

    }

    // Load the user selected data in the maps
    private static void loadData(Map<Character, Character> plugboard, Map<Character, Character> rotor1,
                                 Map<Character, Character> rotor2, Map<Character, Character> rotor3,
                                 Map<Character, Character> extraRotor, Map<Character, Character> reflector) {
        Map<Character, Character> plugboardMap = new HashMap<>();
        int rotor1Type, rotor2Type, rotor3Type, extraRotorType, reflectorType;
        rotor1Type = rotor2Type = rotor3Type = extraRotorType = reflectorType = 0;

        display(plugboardMap, rotor1Type, rotor2Type, rotor3Type, extraRotorType, reflectorType);


        // To be completed!
    }

    public static void main(String[] args) {
        Map<Character, Character> plugboard = new HashMap<Character, Character>();
        Map<Character, Character> rotor1 = new HashMap<Character, Character>();
        Map<Character, Character> rotor2 = new HashMap<Character, Character>();
        Map<Character, Character> rotor3 = new HashMap<Character, Character>();
        Map<Character, Character> extraRotor = new HashMap<Character, Character>();
        Map<Character, Character> reflector = new HashMap<Character, Character>();


    }
}