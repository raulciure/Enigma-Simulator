package models;

public class Machine {
    private final Plugboard plugboard;
    private final Rotor entryWheel;
    private final Rotor rotor1;
    private final Rotor rotor2;
    private final Rotor rotor3;
    private final Rotor extraRotor;
    private final Rotor reflector;

    public Machine(Plugboard plugboard, Rotor entryWheel, Rotor rotor1, Rotor rotor2,
                   Rotor rotor3, Rotor extraRotor, Rotor reflector) {
        this.plugboard = plugboard;
        this.entryWheel = entryWheel;
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.extraRotor = extraRotor;
        this.reflector = reflector;
    }

    public char encode(char character) {
        // Step rotors on key press
        rotor1.step();
        if(rotor1.wasAtNotch()) {
            rotor2.step();
            if(rotor2.wasAtNotch())
                rotor3.step();
        }

        char signal;

        // First pass through plugboard
        signal = plugboard.encode(character);

        // First pass through entry wheel (EKW)
        signal = entryWheel.encode(signal, entryWheel.getPosition(), entryWheel.getRingSetting());

        // First pass through first rotor
        signal = rotor1.encode(signal, entryWheel.getPosition(), entryWheel.getRingSetting());

        // First pass through second rotor
        signal = rotor2.encode(signal, rotor1.getPosition(), rotor1.getRingSetting());

        // First pass through third rotor
        signal = rotor3.encode(signal, rotor2.getPosition(), rotor2.getRingSetting());

        // First pass through extra rotor
        signal = extraRotor.encode(signal, rotor3.getPosition(), rotor3.getRingSetting());

        // Pass through reflector (UKW)
        signal = reflector.encode(signal, extraRotor.getPosition(), extraRotor.getRingSetting());

        // Reverse pass through extra rotor
        signal = extraRotor.encodeReverse(signal, reflector.getPosition(), reflector.getRingSetting());

        // Reverse pass through third rotor
        signal = rotor3.encodeReverse(signal, extraRotor.getPosition(), extraRotor.getRingSetting());

        // Reverse pass through second rotor
        signal = rotor2.encodeReverse(signal, rotor3.getPosition(), rotor3.getRingSetting());

        // Reverse pass through first rotor
        signal = rotor1.encodeReverse(signal, rotor2.getPosition(), rotor2.getRingSetting());

        // Reverse pass through entry wheel (EKW)
        signal = entryWheel.encodeReverse(signal, rotor1.getPosition(), rotor1.getRingSetting());

        // Reverse pass through plugboard
        signal = plugboard.encode(signal);

        return signal;
    }

    public String encode(String input) {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            output.append(encode(input.charAt(i)));
        }

        return output.toString();
    }
}
