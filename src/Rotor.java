import java.util.List;
import java.util.Map;

public class Rotor {
    private Map<Character, Character> wiring;
    private List<Character> notches;
    private Character position;

    public Rotor(Map<Character, Character> wiring, List<Character> notches, char position) {
        this.wiring = wiring;
        this.notches = notches;
        this.position = position;
    }

    public Rotor(Map<Character, Character> wiring, List<Character> notches) {
        this.wiring = wiring;
        this.notches = notches;
        this.position = null;
    }

    public Map<Character, Character> getWiring() {
        return this.wiring;
    }

    public List<Character> getNotches() {
        return this.notches;
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public void step() {
        if(position == 'Z') {
            position = 'A';
        }
        else {
            position++;
        }
    }

    public boolean isAtNotch() {
        for (Character notch : this.notches) {
            if (notch == position) {
                return true;
            }
        }
        return false;
    }

    public char encode(char character) {
        return this.wiring.get(character);
    }

    public char encodeReverse(char character) {
        for(char key = 'A'; key <= 'Z'; key++) {
            if(this.wiring.get(key) == character) {
                return key;
            }
        }
        return character; // Should never return this in normal operation
    }
}
