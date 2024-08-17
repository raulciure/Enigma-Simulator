package models;

import statics.Utilities;

import java.util.List;
import java.util.Map;

public class Rotor {
     private RotorType rotorType;
     private char position;
     private char ringSetting;

    public Rotor(RotorType rotorType, Character position, Character ringSetting) {
        this.rotorType = rotorType;
        this.position = position;
        this.ringSetting = ringSetting;
    }

    public Rotor(RotorType rotorType) {
        this.rotorType = rotorType;
        this.position = 'A';
        this.ringSetting = 'A';
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

    public char getRingSetting() {
        return ringSetting;
    }

    public void setRotorType(RotorType rotorType) {
        this.rotorType = rotorType;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public void setRingSetting(char ringSetting) {
        this.ringSetting = ringSetting;
    }

    public void step() {
        if(this.position == 'Z') {
            this.position = 'A';
        }
        else {
            position++;
        }
    }

    // The notch being on the ring, and the current position being the ring indicated one, it is not required to get the real position in this context
    public boolean wasAtNotch() {
        for (Character notch : this.getNotches()) {
            if (notch == this.position - 1) {
                return true;
            }
        }
        return false;
    }

    /*
    Logic explanation:
       * On each side of the main rotors, the contacts correspond to sequential alphabet letters (A, B, C, etc.);
       * Each letter on the right side goes into a letter on the left side according to the wiring table;
       * Because the rotors turn, the connection between letters will always change
       (A from rotor 1 connects to A from rotor 2, but after turn B from rotor 1 connects to A from rotor 2) -
       - this was called (in this context): deviation;
       * Because the rotors also feature the ring setting, this must also be taken into account when determining the
       deviation of the previous rotor (for forward encoding, the right rotor, for reverse encoding, the left rotor);
       * Using deviation we can determine the input letter of the current rotor that the output letter of the right rotor connects to;
       * Because with the deviation the input character can exceed 'Z', an overflow circular logic needed to be implemented.
     */
    public char encode(char character, char rightRotorPosition, char rightRotorRingSetting) {
        char realPosition = Rotor.getRealCharacter(this.position, this.ringSetting);
        char realRightRotorPosition = Rotor.getRealCharacter(rightRotorPosition, rightRotorRingSetting);

        int inputDeviation = realPosition - realRightRotorPosition;

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

        return this.getWiring().get(inputCharacter);
    }

    public char encodeReverse(char character, char leftRotorPosition, char leftRotorRingSetting) {
        char realPosition = Rotor.getRealCharacter(this.position, this.ringSetting);
        char realLeftRotorPosition = Rotor.getRealCharacter(leftRotorPosition, leftRotorRingSetting);

        int inputDeviation = realPosition - realLeftRotorPosition;

        char inputCharacter; // the character that is the rotor input on the left side after taking into account the deviation of this rotor from the left rotor
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
            if (this.getWiring().get(key) == inputCharacter) {
                return key;
            }
        }
        return inputCharacter;
    }

    /**
     * Recieves a character and an offset and returns the character that "offsets" into the given deviatedCharacter.
     *
     * @param deviatedCharacter the character that is deviated with the given <code>offset</code>;
     * @param offset the offset from the real character of the current character;
     * @return the real character.
     */
    public static char getRealCharacter(char deviatedCharacter, int offset) {
        if(deviatedCharacter - offset < 'A') {
            return (char) (deviatedCharacter - offset + 'Z' - 'A' + 1);
        }
        return (char) (deviatedCharacter - offset);
    }

    /**
     * Recieves a character and an offset and returns the character that "offsets" into the given deviatedCharacter.
     *
     * @param deviatedCharacter the character that is deviated with the given <code>offset</code>;
     * @param charOffset the character offset (e.g. rotor ring setting) from the real character of the current character;
     * @return the real character.
     */
    public static char getRealCharacter(char deviatedCharacter, char charOffset) {
        int offset = charOffset - 'A';

        return getRealCharacter(deviatedCharacter, offset);
    }
}
