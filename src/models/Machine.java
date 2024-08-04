package models;

public class Machine {
    private Plugboard plugboard;
    private Rotor entryRotor;
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Rotor extraRotor;
    private Rotor reflector;

    public Machine(Plugboard plugboard, Rotor entryRotor, Rotor rotor1, Rotor rotor2,
                   Rotor rotor3, Rotor extraRotor, Rotor reflector) {
        this.plugboard = plugboard;
        this.entryRotor = entryRotor;
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.extraRotor = extraRotor;
        this.reflector = reflector;
    }

    public void setPlugboard(Plugboard plugboard) {
        this.plugboard = plugboard;
    }

    public void setEntryRotor(Rotor entryRotor) {
        this.entryRotor = entryRotor;
    }

    public void setRotor1(Rotor rotor1) {
        this.rotor1 = rotor1;
    }

    public void setRotor2(Rotor rotor2) {
        this.rotor2 = rotor2;
    }

    public void setRotor3(Rotor rotor3) {
        this.rotor3 = rotor3;
    }

    public void setExtraRotor(Rotor extraRotor) {
        this.extraRotor = extraRotor;
    }

    public void setReflector(Rotor reflector) {
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

        // First pass through plugboard
        char afterPlugboard = plugboard.encode(character);

        // First pass through entry wheel (EKW)
        char afterEntryRotor = entryRotor.encode(afterPlugboard, entryRotor.getPosition());

        // First pass through first rotor
        char afterRotor1 = rotor1.encode(afterEntryRotor, entryRotor.getPosition());

        // First pass through second rotor
        char afterRotor2 = rotor2.encode(afterRotor1, rotor1.getPosition());

        // First pass through third rotor
        char afterRotor3 = rotor3.encode(afterRotor2, rotor2.getPosition());

        // First pass through extra rotor
        char afterExtraRotor = extraRotor.encode(afterRotor3, rotor3.getPosition());

        // Pass through reflector (UKW)
        char afterReflector = reflector.encode(afterExtraRotor, extraRotor.getPosition());

        // Reverse pass through extra rotor
        char afterExtraRotorReverse = extraRotor.encodeReverse(afterReflector, reflector.getPosition());

        // Reverse pass through third rotor
        char afterRotor3Reverse = rotor3.encodeReverse(afterExtraRotorReverse, extraRotor.getPosition());

        // Reverse pass through second rotor
        char afterRotor2Reverse = rotor2.encodeReverse(afterRotor3Reverse, rotor3.getPosition());

        // Reverse pass through first rotor
        char afterRotor1Reverse = rotor1.encodeReverse(afterRotor2Reverse, rotor2.getPosition());

        // Reverse pass through entry wheel (EKW)
        char afterEntryRotorReverse = entryRotor.encodeReverse(afterRotor1Reverse, rotor1.getPosition());

        // Reverse pass through plugboard
        char afterPlugboardReverse = plugboard.encode(afterEntryRotorReverse);

        return afterPlugboardReverse;
    }

    public String encode(String input) {
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            output.append(encode(input.charAt(i)));
        }

        return output.toString();
    }
}
