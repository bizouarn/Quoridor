import gui.*;
import quoridor.Game;

public class LaunchGUI {
    public static void main(String[] args){
        new Gui(new Game(true));
    }
}
