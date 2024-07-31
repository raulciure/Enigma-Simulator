public class Rotor {
    private RotorType rotorType;
    private char position;

    public Rotor(RotorType rotorType, char position) {
        this.rotorType = rotorType;
        this.position = position;
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
        for (Character notch : rotorType.getNotches()) {
            if (notch == position) {
                return true;
            }
        }
        return false;
    }

    public char encode(char character) {
        return rotorType.getWiring().get(character);
    }

    public char encodeReverse(char character) {
        for(char key = 'A'; key <= 'Z'; key++) {
            if(rotorType.getWiring().get(key) == character) {
                return key;
            }
        }
        return character; // Should never return this in normal operation
    }
}
