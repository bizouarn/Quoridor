package quoridor;

/**
 * Class containing the method permitting to print the board in the terminal
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class TerminalPrinting {

    /**
     * Invoked to print th board in terminal mode
     *
     * @param board The current board.
     * @return The board into a string.
     * @author Pierre-Galaad Naquet
     */
    public static String printBoard(Board board) {

        String ret = "";
        String layer1 = "";
        String layer2 = "";
        String layer3 = "";

        for (int row = 0; row < board.getSIZE(); row++) {
            for (int col = 0; col < board.getSIZE(); col++) {
                if (board.getSquare(row, col).getFenceN()) {
                    layer1 = layer1 + "  ==  ";
                } else {
                    layer1 = layer1 + "  --  ";
                }
                if (board.getSquare(row, col).getFenceW()) {
                    layer2 = layer2 + "||";
                } else {
                    layer2 = layer2 + " |";
                }

                layer2 = layer2 + board.getSquare(row, col).getStatus().toString();

                if (board.getSquare(row, col).getFenceE()) {
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
                    if (board.getSquare(row, col).getFenceS()) {
                        layer1 = layer1 + "  ==  ";
                    } else {
                        layer1 = layer1 + "  --  ";
                    }
                }
                ret = ret + layer1;
            }
        }
        return ret;
    }
}
