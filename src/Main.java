import models.Machine;
import statics.UserInteraction;
import statics.Init;

public class Main {
    public static void main(String[] args) {
        Machine enigmaMachine = Init.loadData();

        UserInteraction.displayEncoding(enigmaMachine);
    }
}