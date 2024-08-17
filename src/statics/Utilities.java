package statics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public final class Utilities {
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

    /**
     * Compares each element from a list of <code>String</code> objects with a given String.
     *
     * @param list a list of <code>String</code> objects;
     * @param str the string that will be searched in the list;
     * @return <code>true</code> even if only one character between the list contents and the string matches;
    **/
    public static boolean listContainsStringContent(List<String> list, String str) {
        for(String s : list) {
            for(Character c : s.toCharArray()) {
                if(str.contains(c.toString()))
                    return true;
            }
        }
        return false;
    }

    /**
     * Verifies if the given string contains only letters (uppercase or lowercase).
     *
     * @param string the string that will be verified
     * @return <code>true</code> if string contains only letters, <code>false</code> otherwise.
     */
    public static boolean isStringOfLetters(String string) {
        for (char c : string.toCharArray()) {
            if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')))
                return false;
        }
        return true;
    }
}
