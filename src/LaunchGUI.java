import gui.*;
import quoridor.Game;
import quoridor.Quoridor;

import java.awt.*;

public class LaunchGUI{

    public static void main(String[] args){
        new MenuGui();
        new Game(true);
        new Quoridor();
    }
}
