public class Machine {
    private Plugboard plugboard;
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Rotor extraRotor;
    private Rotor reflector;

    public Machine(Plugboard plugboard, Rotor rotor1, Rotor rotor2,
                   Rotor rotor3, Rotor extraRotor, Rotor reflector) {
        this.plugboard = plugboard;
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.extraRotor = extraRotor;
        this.reflector = reflector;
    }

    public void setPlugboard(Plugboard plugboard) {
        this.plugboard = plugboard;
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
        // First pass through plugboard
        char afterPlugboard = plugboard.encode(character);

        // First pass through first rotor
        char afterRotor1 = rotor1.encode(afterPlugboard);
        rotor1.step();
        if(rotor1.isAtNotch()) {
            rotor2.step();
            if(rotor2.isAtNotch())
                rotor3.step();
        }

        // First pass through second rotor
        char afterRotor2 = rotor2.encode(afterRotor1);
        rotor2.step();
        if(rotor2.isAtNotch())
            rotor3.step();

        // First pass through third rotor
        char afterRotor3 = rotor3.encode(afterRotor2);

        // First pass through extra rotor
        char afterExtraRotor = extraRotor.encode(afterRotor3);

        // Pass through reflector (UKW)
        char afterReflector = reflector.encode(afterExtraRotor);

        // Reverse pass through extra rotor
        char afterExtraRotorReverse = extraRotor.encodeReverse(afterReflector);

        // Reverse pass through third rotor
        char afterRotor3Reverse = rotor3.encodeReverse(afterExtraRotorReverse);

        // Reverse pass through second rotor
        char afterRotor2Reverse = rotor2.encodeReverse(afterRotor3Reverse);

        // Reverse pass through first rotor
        char afterRotor1Reverse = rotor1.encodeReverse(afterRotor2Reverse);

        // Reverse pass through plugboard
        char afterPlugboardReverse = plugboard.encodeReverse(afterRotor1Reverse);

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
