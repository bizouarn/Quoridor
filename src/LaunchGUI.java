import gui.*;
import quoridor.Game;
import quoridor.Quoridor;

import javax.swing.*;
import java.awt.*;

public class LaunchGUI{

    public LaunchGUI(){
        Game game = new Game(true);
        game.start();
    }

    public static void main(String[] args){
        String[] game = {"Game"};
        new Quoridor(game);
    }
}
