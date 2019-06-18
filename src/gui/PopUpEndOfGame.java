import java.awt.*;
import javax.swing.*;

public class PopUpEndOfGame extends JPanel {

  public PopUpEndOfGame() {

    Object[] options = {"New Game",
                        "Main Menu",
                        "Quit"};
    int n = JOptionPane.showOptionDialog(this,
        "[ajouter un player] won !",
        "Game has ended",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[2]);

  }

  public static void main(String[] args) {
    new PopUpEndOfGame();
  }

}
