package statics;

import models.Machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class UserInteraction {
    private static String languageOption;

    public static void plugboardSelection(String languageOption, Scanner scanner, List<String> plugboardMap) {
        if (languageOption.equals("1")) { // English
            System.out.println("Please enter pair of letters to connect to plugboard (eg. AB) one per line (maximum 12).");
            System.out.println("To end operation type '0'.");

            int counter = 0;
            while (counter < 12) {
                System.out.print("\t> ");
                String input = scanner.nextLine();

                if(input.equals("0")) {
                    break;
                }

                if(Utilitaries.listContainsStringContent(plugboardMap, input)) {
                    System.out.println("Letter(s) socket already used!");
                }
                else {
                    plugboardMap.add(input);
                    counter++;
                }

            }
            if(counter == 12) {
                System.out.println("All wires used!\n");
            }

        }
        else if (languageOption.equals("2")) { // German
            System.out.println("Bitte geben Sie ein Buchstabenpaar für die Verbindung zum Steckerbrett ein (z. B. AB), einen pro Zeile (maximal 12).");
            System.out.println("Um den Vorgang zu beenden, geben Sie '0' ein.");

            int counter = 0;
            while (counter < 12) {
                System.out.print("\t> ");
                String input = scanner.nextLine();

                if(input.equals("0")) {
                    break;
                }

                if(Utilitaries.listContainsStringContent(plugboardMap, input)) {
                    System.out.println("Buchstab(en) Sockel bereits belegt!");
                }
                else {
                    plugboardMap.add(input);
                    counter++;
                }

            }
            if(counter == 12) {
                System.out.println("Alle Drähte verwendet!\n");
            }
        }
    }

    public static void rotorSelection(String languageOption, Scanner scanner, List<String> availableRotors, StringBuilder wheelTypeString, List<Character> rotorsPositions, List<Character> ringsPositions, int rotorNumber) {
        if(languageOption.equals("1")) { // English
            if (rotorNumber >= 1 && rotorNumber <= 3) { // Normal rotors
                while (true) {
                    System.out.println("Rotor " + rotorNumber + "(from right):");
                    System.out.println("\tAvailable rotors:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\t" + "Selection:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        // Get ring setting
                        while(true) {
                            System.out.println("\tSet ring position (A-Z)");
                            System.out.print("\t" + "> ");

                            char ringSetting = scanner.nextLine().charAt(0);

                            if(ringSetting >= 'A' && ringSetting <= 'Z') {
                                ringsPositions.add(rotorNumber - 1, ringSetting);
                                break;
                            }
                            else {
                                System.out.println("\tOption invalid!");
                            }
                        }

                        // Get rotor position
                        while(true) {
                            System.out.println("\tSet rotor position (A-Z)");
                            System.out.print("\t" + "> ");

                            char position = scanner.nextLine().charAt(0);

                            if(position >= 'A' && position <= 'Z') {
                                rotorsPositions.add(rotorNumber - 1, position);
                                break;
                            }
                            else {
                                System.out.println("\tOption invalid!");
                            }
                        }
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tRotor not available or non-existent!");
                    }

                    System.out.println();
                }
            }
            else if (rotorNumber == 4) { // Extra rotor
                while (true) {
                    System.out.println("Extra rotor:");
                    System.out.println("\tAvailable rotors:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\t" + "Selection:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        // Get ring setting
                        while(true) {
                            System.out.println("\tSet ring position (A-Z)");
                            System.out.print("\t" + "> ");

                            char ringSetting = scanner.nextLine().charAt(0);

                            if(ringSetting >= 'A' && ringSetting <= 'Z') {
                                ringsPositions.add(rotorNumber - 1, ringSetting);
                                break;
                            }
                            else {
                                System.out.println("\tOption invalid!");
                            }
                        }

                        // Get rotor position
                        while(true) {
                            System.out.println("\tSet rotor position (A-Z)");
                            System.out.print("\t" + "> ");

                            char position = scanner.nextLine().charAt(0);

                            if(position >= 'A' && position <= 'Z') {
                                rotorsPositions.add(rotorNumber - 1, position);
                                break;
                            }
                            else {
                                System.out.println("\tOption invalid!");
                            }
                        }
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tRotor not available or non-existent!");
                    }

                    System.out.println();
                }
            }
            else if (rotorNumber == 5) { // Reflector
                while (true) {
                    System.out.println("Reflector:");
                    System.out.println("\tAvailable reflectors:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\t" + "Selection:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tReflector not available or non-existent!");
                    }

                    System.out.println();
                }
            }
        }
        else if(languageOption.equals("2")) { // German
            if (rotorNumber >= 1 && rotorNumber <= 3) { // Normal rotors
                while (true) {
                    System.out.println("models.Rotor " + rotorNumber + "(von rechts):");
                    System.out.println("\tVerfügbare Rotoren:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\tSelektion:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        // Get ring setting
                        while(true) {
                            System.out.println("\tRingposition einstellen (A-Z)");
                            System.out.print("\t" + "> ");

                            char ringSetting = scanner.nextLine().charAt(0);

                            if(ringSetting >= 'A' && ringSetting <= 'Z') {
                                ringsPositions.add(rotorNumber - 1, ringSetting);
                                break;
                            }
                            else {
                                System.out.println("\tOption ungültig!");
                            }
                        }

                        // Get rotor position
                        while(true) {
                            System.out.println("\tRotorposition einstellen (A-Z)");
                            System.out.print("\t" + "> ");

                            char position = scanner.nextLine().charAt(0);

                            if(position >= 'A' && position <= 'Z') {
                                rotorsPositions.add(rotorNumber - 1, position);
                                break;
                            }
                            else {
                                System.out.println("\tOption ungültig!");
                            }
                        }
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tRotor nicht vorhanden oder nicht lieferbar!");
                    }

                    System.out.println();
                }
            }
            else if (rotorNumber == 4) { // Extra rotor
                while (true) {
                    System.out.println("Zusatzwalze :");
                    System.out.println("\tVerfügbare Rotoren:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\tSelektion:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        // Get ring setting
                        while(true) {
                            System.out.println("\tRingposition einstellen (A-Z)");
                            System.out.print("\t" + "> ");

                            char ringSetting = scanner.nextLine().charAt(0);

                            if(ringSetting >= 'A' && ringSetting <= 'Z') {
                                ringsPositions.add(rotorNumber - 1, ringSetting);
                                break;
                            }
                            else {
                                System.out.println("\tOption ungültig!");
                            }
                        }

                        // Get rotor position
                        while(true) {
                            System.out.println("\tRotorposition einstellen (A-Z)");
                            System.out.print("\t" + "> ");

                            char position = scanner.nextLine().charAt(0);

                            if(position >= 'A' && position <= 'Z') {
                                rotorsPositions.add(rotorNumber - 1, position);
                                break;
                            }
                            else {
                                System.out.println("\tOption ungültig!");
                            }
                        }
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tRotor nicht vorhanden oder nicht lieferbar!");
                    }

                    System.out.println();
                }
            }
            else if (rotorNumber == 5) { // Reflector
                while (true) {
                    System.out.println("Umkehrwalze (UKW):");
                    System.out.println("\tVerfügbar Umkehrwalze:");
                    System.out.println("\t" + availableRotors);
                    System.out.println("\tSelektion:");
                    System.out.print("\t" + "> ");

                    String selection = scanner.nextLine();

                    if (availableRotors.contains(selection)) {
                        wheelTypeString.append(selection);
                        availableRotors.remove(selection);
                        break;
                    }
                    else {
                        System.out.println("\tUmkehrwalze nicht vorhanden oder nicht lieferbar!");
                    }

                    System.out.println();
                }
            }
        }

    }

    public static void displayMenu(List<String> plugboardStringMap, StringBuilder rotor1Type,
                                    StringBuilder rotor2Type, StringBuilder rotor3Type, StringBuilder extraRotorType, StringBuilder reflectorType,
                                    List<Character> rotorsPositions, List<Character> ringsPositions) {
        // Build local variables
        List<String> availableNormalRotors = new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII"));
        List<String> availableExtraRotors = new ArrayList<>(Arrays.asList("beta", "gamma"));
        List<String> availableReflectors = new ArrayList<>(Arrays.asList("b", "c"));

        // Print banner
        System.out.println("+=======================================================================================+\n" +
                "|  _____       _                         ____  _                 _       _              |\n" +
                "| | ____|_ __ (_) __ _ _ __ ___   __ _  / ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __  |\n" +
                "| |  _| | '_ \\| |/ _` | '_ ` _ \\ / _` | \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__| |\n" +
                "| | |___| | | | | (_| | | | | | | (_| |  ___) | | | | | | | |_| | | (_| | || (_) | |    |\n" +
                "| |_____|_| |_|_|\\__, |_| |_| |_|\\__,_| |____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|    |\n" +
                "|                |___/                                                                  |\n" +
                "+=======================================================================================+");
        System.out.println("\n\n");
        System.out.println("----Enigma M4 Simulator----\n\n");

        Scanner scanner = new Scanner(System.in);

        // Select language
        while(true) {
            System.out.println("Select language | Sprache auswählen");
            System.out.println("[1] English");
            System.out.println("[2] Deutsch");

            System.out.print("> ");

            UserInteraction.languageOption = scanner.nextLine();

            // English menu
            if (UserInteraction.languageOption.equals("1")) {
                // Select operation mode
                System.out.println("Select operation mode");
                break;
            }
            // German menu
            else if (UserInteraction.languageOption.equals("2")) {
                // Select operation mode
                System.out.println("Betriebsart wählen");
                break;
            }
            else {
                System.out.println("Option invalid! | Option ungültig!\n");
            }
        }

        // Rotor 1
        rotorSelection(UserInteraction.languageOption, scanner, availableNormalRotors, rotor1Type, rotorsPositions, ringsPositions,1);
        // Rotor 2
        rotorSelection(UserInteraction.languageOption, scanner, availableNormalRotors, rotor2Type, rotorsPositions, ringsPositions,2);
        // Rotor 3
        rotorSelection(UserInteraction.languageOption, scanner, availableNormalRotors, rotor3Type, rotorsPositions, ringsPositions,3);
        // Extra rotor
        rotorSelection(UserInteraction.languageOption, scanner, availableExtraRotors, extraRotorType, rotorsPositions, ringsPositions,4);
        // Reflector
        rotorSelection(UserInteraction.languageOption, scanner, availableReflectors, reflectorType, null, null,5);
        // Plugboard
        plugboardSelection(UserInteraction.languageOption, scanner, plugboardStringMap);
    }

    public static void displayEncoding(Machine machine) {
        System.out.println("----------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        String input;

        if(UserInteraction.languageOption.equals("1")) { // English
            while(true) {
                System.out.println("Type message to be encoded followed by Enter!");
                System.out.println("To exit program, type '0'.");
                System.out.print("> ");

                input = scanner.nextLine();

                if (input.equals("0")) {
                    break;
                }

                String output = machine.encode(input);
                System.out.println("\t[Output]: " + output);
            }
        }
        else if(UserInteraction.languageOption.equals("2")) { // German
            while(true) {
                System.out.println("Geben Sie die zu verschlüsselnde Nachricht ein, und drücken Sie anschließend die Eingabetaste!");
                System.out.println("Um das Programm zu beenden, geben Sie „0“ ein.");
                System.out.print("> ");

                input = scanner.nextLine();

                if (input.equals("0")) {
                    break;
                }

                String output = machine.encode(input);
                System.out.println("\t[Ausgabe]: " + output);
            }
        }

        scanner.close();
    }
}
