package models;

import java.util.List;
import java.util.Map;
import statics.Utilitaries;

public class RotorType {
    private Map<Character, Character> wiring;
    private List<Character> notches;

    public RotorType() {}

    public RotorType(Map<Character, Character> wiring, List<Character> notches) {
        this.wiring = wiring;
        this.notches = notches;
    }

    public RotorType(Map<Character, Character> wiring) {
        this.wiring = wiring;
        this.notches = null;
    }

    public RotorType setRotorTypeByID(String rotorID) {
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
            case "EKW":
                wireMap = Utilitaries.createHashMap(alphabet, alphabet);
                return new RotorType(wireMap);

            case "I":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_I);
                notches = Utilitaries.createArrayList(rotor_I_notches);
                return new RotorType(wireMap, notches);

            case "II":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_II);
                notches = Utilitaries.createArrayList(rotor_II_notches);
                return new RotorType(wireMap, notches);

            case "III":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_III);
                notches = Utilitaries.createArrayList(rotor_III_notches);
                return new RotorType(wireMap, notches);

            case "IV":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_IV);
                notches = Utilitaries.createArrayList(rotor_IV_notches);
                return new RotorType(wireMap, notches);

            case "V":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_V);
                notches = Utilitaries.createArrayList(rotor_V_notches);
                return new RotorType(wireMap, notches);

            case "VI":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VI);
                notches = Utilitaries.createArrayList(rotor_VI_notches);
                return new RotorType(wireMap, notches);

            case "VII":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VII);
                notches = Utilitaries.createArrayList(rotor_VII_notches);
                return new RotorType(wireMap, notches);

            case "VIII":
                wireMap = Utilitaries.createHashMap(alphabet, rotor_VIII);
                notches = Utilitaries.createArrayList(rotor_VIII_notches);
                return new RotorType(wireMap, notches);

            case "beta":
                wireMap = Utilitaries.createHashMap(alphabet, extraRotor_beta);
                return new RotorType(wireMap);

            case "gamma":
                wireMap = Utilitaries.createHashMap(alphabet, extraRotor_gamma);
                return new RotorType(wireMap);

            case "b":
                wireMap = Utilitaries.createHashMap(alphabet, reflector_b);
                return new RotorType(wireMap);

            case "c":
                wireMap = Utilitaries.createHashMap(alphabet, reflector_c);
                return new RotorType(wireMap);
        }
        return null;
    }

    public Map<Character, Character> getWiring() {
        return wiring;
    }

    public List<Character> getNotches() {
        return notches;
    }
}
