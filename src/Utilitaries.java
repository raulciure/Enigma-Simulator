import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Utilitaries {
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
}
