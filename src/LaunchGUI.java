import gui.*;
import quoridor.Game;
import quoridor.Quoridor;

public class LaunchGUI{

    public static void main(String[] args){
        new MenuGui();
        new Quoridor("./data/save/SavedGame.bin");
    }
}
