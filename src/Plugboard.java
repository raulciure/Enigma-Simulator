import java.util.Map;

public class Plugboard {
    private int wireCount;
    private Map<Character, Character> wiring;

    public Plugboard(int wireCount, Map<Character, Character> wiring) {
        this.wireCount = wireCount;
        this.wiring = wiring;
    }

    public int getWireCount() {
        return wireCount;
    }

    public Map<Character, Character> getWiring() {
        return wiring;
    }

    public void setWireCount(int wireCount) {
        this.wireCount = wireCount;
    }

    public void setWiring(Map<Character, Character> wiring) {
        this.wiring = wiring;
    }

    public char encode(char character) {
        try {
            char result = this.getWiring().get(character);

            return this.getWiring().get(character);
        }
        catch (NullPointerException e) {
            // character is not in map => not plugboard scrambling for it used - return same character
            return character;
        }
    }

    public char encodeReverse(char character) {
        for(char key = 'A'; key <= 'Z'; key++) {
            if(this.getWiring().get(key) == character) {
                return key;
            }
        }
        return character; // If returned => no wires used for that character
    }
}
