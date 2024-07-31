import java.util.List;
import java.util.Map;

public class RotorType {
    private Map<Character, Character> wiring;
    private List<Character> notches;

    public RotorType(Map<Character, Character> wiring, List<Character> notches) {
        this.wiring = wiring;
        this.notches = notches;
    }

    public Map<Character, Character> getWiring() {
        return this.wiring;
    }

    public List<Character> getNotches() {
        return this.notches;
    }
}
