import java.awt.*;
import javax.swing.*;

public class PopUpEndOfGame extends JPanel {

  public int popUpEndOfGame() throws IllegalStateException {
    Object[] options = { "New Game", "Main Menu", "Leave" };
    int choice = JOptionPane.showOptionDialog(null,
        "[Name player] Has won !",
        "Game has ended !",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]);

    int ret = 0;

    if (choice == JOptionPane.YES_OPTION) {
      ret = 1;
    }

    if (choice == JOptionPane.NO_OPTION) {
      ret = 2;
    }

    if (choice == JOptionPane.CANCEL_OPTION) {
      ret = 3;
    }
  }
  return ret;
}
