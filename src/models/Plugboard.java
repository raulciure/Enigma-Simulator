package models;

import java.util.Map;

public class Plugboard {
    private int wireCount;
    private Map<Character, Character> wiring;

    public Plugboard() {
        wireCount = 0;
        wiring = null;
    }

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
        try { // Search for forward mapping
            return this.getWiring().get(character);
        }
        catch (NullPointerException e) { // Search for backwards mapping
            if(this.getWiring() != null) {
                for (char key = 'A'; key <= 'Z'; key++) {
                    Character value = this.getWiring().get(key);
                    if (value != null && value == character) {
                        return key;
                    }
                }
            }
            // character is not in map => not plugboard scrambling for it used - return same character
            return character;
        }
    }
}
