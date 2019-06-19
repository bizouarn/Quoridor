import gui.MenuGui;
import quoridor.Quoridor;

public class LaunchNoGUI {

    public static void main(String[] args){
        String[] nogui = {"nogui"};
        new Quoridor("./data/save/SavedGame.bin",nogui);
    }
}
