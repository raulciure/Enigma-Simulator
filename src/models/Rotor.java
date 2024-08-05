package models;

import statics.Utilitaries;

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

    public void setPosition(char position) {
        this.position = position;
    }

    public void step() {
        if(this.position == 'Z') {
            this.position = 'A';
        }
        else {
            position++;
        }
    }

    public boolean wasAtNotch() {
        for (Character notch : this.rotorType.getNotches()) {
            if (notch == this.position - 1) {
                return true;
            }
        }
        return false;
    }

//    public boolean wasAtNotch() {
//        for (Character notch : this.getNotches()) {
//            if (notch == Utilitaries.getRealCharacter(this.position, this.ringSetting) - 1) {
//                return true;
//            }
//        }
//        return false;
//    }

    /*
    TODO: Create explanation for encoding functions (with emphasis on deviation logic)!
     */
    public char encode(char character, char rightRotorPosition, char rightRotorRingSetting) {
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

        char realPosition = Utilitaries.getRealCharacter(this.position, this.ringSetting);
        char realRightRotorPosition = Utilitaries.getRealCharacter(rightRotorPosition, rightRotorRingSetting);

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

    /*
    TODO: Create explanation for encoding functions (with emphasis on deviation logic)!
     */
    public char encodeReverse(char character, char leftRotorPosition, char leftRotorRingSetting) {
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

        char realPosition = Utilitaries.getRealCharacter(this.position, this.ringSetting);
        char realLeftRotorPosition = Utilitaries.getRealCharacter(leftRotorPosition, leftRotorRingSetting);

        int inputDeviation = realPosition - realLeftRotorPosition;

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
            if (this.getWiring().get(key) == inputCharacter) {
                return key;
            }
        }
        return inputCharacter;
    }
}
