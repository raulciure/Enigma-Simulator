import models.Machine;
import models.Plugboard;
import models.Rotor;
import models.RotorType;
import statics.UserInteraction;
import statics.Utilitaries;
import statics.Init;

public class Main {
    public static void main(String[] args) {
        Machine enigmaMachine = Init.loadData();

        UserInteraction.displayEncoding(enigmaMachine);
    }
}