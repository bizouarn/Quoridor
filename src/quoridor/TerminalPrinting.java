package quoridor;

/**
 * Class containing the method permiting to print the board in the terminal
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class TerminalPrinting {

    /**
     * The current board
     */
    private Board board;

    /**
     * Invoked to print th board in terminal mode
     * @author Pierre-Galaad Naquet
     */
    public static String printBoard(Board board) {

        String ret = "";
        String layer1 = "";
        String layer2 = "";
        String layer3 = "";

        for (int row = 0; row < board.getSIZE(); row++) {
            for (int col = 0; col < board.getSIZE(); col++) {
                if (board.getSquare(row, col).getFenceN() == true) {
                    layer1 = layer1 + "  ==  ";
                } else {
                    layer1 = layer1 + "  --  ";
                }
                if (board.getSquare(row, col).getFenceW() == true) {
                    layer2 = layer2 + "||";
                } else {
                    layer2 = layer2 + " |";
                }

                layer2 = layer2 + board.getSquare(row, col).getStatus().toString();

                if (board.getSquare(row, col).getFenceE() == true) {
                    layer2 = layer2 + "||";
                } else {
                    layer2 = layer2 + "| ";
                }
            }
            ret = ret + layer1 + "\n" + layer2 + "\n" + layer3;
            layer1 = "";
            layer2 = "";
            if (row == board.getSIZE() - 1) {
                for (int col = 0; col < board.getSIZE(); col++) {
                    if (board.getSquare(row, col).getFenceS() == true) {
                        layer1 = layer1 + "  ==  ";
                    } else {
                        layer1 = layer1 + "  --  ";
                    }
                }
                ret = ret+layer1;
            }
        }
        return ret;
    }
}
