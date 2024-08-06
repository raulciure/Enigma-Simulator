package statics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public final class Utilitaries {
    public static Map<Character, Character> createHashMap(String keys, String values) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }
        return map;
    }

    public static List<Character> createArrayList(String string) {
        List<Character> list = new ArrayList<>();
        for(Character c : string.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    // Compares each element from a list of Strings with a given String
    // Returns true even if one character between the list contents and the string matches
    public static boolean listContainsStringContent(List<String> list, String str) {
        for(String s : list) {
            for(Character c : s.toCharArray()) {
                if(str.contains(c.toString()))
                    return true;
            }
        }
        return false;
    }

    // Recieves a character and an offset and returns the character that "offsets" into the given deviatedCharacter.
    public static char getRealCharacter(char deviatedCharacter, int offset) {
        if(deviatedCharacter - offset < 'A') {
            return (char) (deviatedCharacter - offset + 'Z' - 'A' + 1);
        }
        return (char) (deviatedCharacter - offset);
    }

    public static char getRealCharacter(char deviatedCharacter, char charOffset) {
        int offset = charOffset - 'A';

        return getRealCharacter(deviatedCharacter, offset);
    }

    public static boolean isStringOfLetters(String string) {
        for (char c : string.toCharArray()) {
            if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')))
                return false;
        }
        return true;
    }
}
