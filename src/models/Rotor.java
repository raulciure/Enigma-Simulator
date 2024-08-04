package models;

import java.util.List;
import java.util.Map;

public class Rotor {
    private RotorType rotorType;
    private char position;

    public Rotor(RotorType rotorType, Character position) {
        this.rotorType = rotorType;
        if(position == null) this.position = 'A';
        else this.position = position;
    }

    public Rotor(RotorType rotorType) {
        this.rotorType = rotorType;
        this.position = 'A';
    }

    public Rotor(Map<Character, Character> wiring, List<Character> notches, Character position) {
        this.rotorType = new RotorType(wiring, notches);
        if(position == null) this.position = 'A';
        else this.position = position;
    }

    public Rotor(Map<Character, Character> wiring, Character position) {
        this.rotorType = new RotorType(wiring);
        if(position == null) this.position = 'A';
        else this.position = position;
    }

    public Rotor(Map<Character, Character> wiring) {
        this.rotorType = new RotorType(wiring);
        this.position = 'A';
    }

    public Map<Character, Character> getWiring() {
        return this.rotorType.getWiring();
    }

    public List<Character> getNotches() {
        return this.rotorType.getNotches();
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

    public boolean wasAtNotch() {
        for (Character notch : this.rotorType.getNotches()) {
            if (notch == position - 1) {
                return true;
            }
        }
        return false;
    }

    public char encode(char character, char rightRotorPosition) {
//            int inputDeviation = this.position - 'A';
//            int prevRotorDeviation = prevRotorPosition - 'A';
//
//            char inputCharacter;
//            if (character + inputDeviation + prevRotorDeviation > 'Z') {
//                inputCharacter = (char) (character + inputDeviation + prevRotorDeviation - 'Z' + 'A' - 1);
//            } else {
//                inputCharacter = (char) (character + inputDeviation + prevRotorDeviation);
//            }
//
//            return this.rotorType.getWiring().get(inputCharacter);

        int inputDeviation = this.position - rightRotorPosition;

        char inputCharacter;
        if(character + inputDeviation > 'Z') {
            inputCharacter = (char) (character + inputDeviation - 'Z' + 'A' - 1);
        }
        else if (character + inputDeviation < 'A') {
            inputCharacter = (char) (character + inputDeviation + 'Z' - 'A' + 1);
        }
        else {
            inputCharacter = (char) (character + inputDeviation);
        }

        return this.rotorType.getWiring().get(inputCharacter);

    }

    public char encodeReverse(char character, char leftRotorPosition) {
//            // outputKey is the character that encodes into 'character' when encoding from right to left
//            char outputKey = 0; // output here means exiting from the right side of the rotor, as the current does
//
//            for (char key = 'A'; key <= 'Z'; key++) {
//                if (this.rotorType.getWiring().get(key) == character) {
//                    outputKey = key;
//                    break;
//                }
//            }
//
//            int outputDeviation = this.position - 'A';
//
//            char outputCharacter; // the character that actually results on the right side after taking into account the deviation of the rotors from position 'A'
//            if (outputKey + outputDeviation > 'Z') {
//                outputCharacter = (char) (outputKey + outputDeviation - 'Z' + 'A' - 1);
//            } else {
//                outputCharacter = (char) (outputKey + outputDeviation);
//            }
//
//            return outputCharacter;

        // outputKey is the character that encodes into 'character' when encoding from right to left
        // char outputKey = 0; // output here means exiting from the right side of the rotor, as the current does

        int inputDeviation = this.position - leftRotorPosition;

        char inputCharacter; // the character that is the rotor input on the left side after taking into account the deviation of the rotor from the left rotor
        if (character + inputDeviation > 'Z') {
            inputCharacter = (char) (character + inputDeviation - 'Z' + 'A' - 1);
        }
        else if (character + inputDeviation < 'A') {
            inputCharacter = (char) (character + inputDeviation + 'Z' - 'A' + 1);
        }
        else {
            inputCharacter = (char) (character + inputDeviation);
        }

        for (char key = 'A'; key <= 'Z'; key++) {
            if (this.rotorType.getWiring().get(key) == inputCharacter) {
                return key;
            }
        }
        return inputCharacter;
    }
}
