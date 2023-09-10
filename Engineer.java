package BridgeBuilderAdv;
/**
 * This class presents methods related to the Engineer and its two move options.
 * @author Ariana Feng
 */
import java.util.Random;
public class Engineer {
    private char token;
    private boolean hardMode;

    /** -- Initialize the token and set the hardMode. Constructor.
     * @param hardMode
     */
    public Engineer(boolean hardMode) {
        token = '0';
        this.hardMode = hardMode;
    }

    /**  -- Based on the difficulty level (hardMode), make a move on the game board at a position determined by the BridgeBuilderAdv.Engineer's strategy.
     * In easy mode, select a random empty position. In hard mode, select the next empty position after the player's last position,
     * or if the row is full, select the topmost empty position in the same column.
     * @param board
     * @param playerLastRow
     * @param playerLastCol
     */
    public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
        Random randGen = new Random();
        int size = board.getSize();

        if (hardMode) {
            boolean rightwardSearch = true;

            for (int i = playerLastRow; i < size; i++) {
                for (int j = playerLastCol; j < size; j++) {
                    if (board.isPositionEmpty(i, j)) {
                        board.placeToken(i, j, token);
                        return;
                    }
                }
            }
            if (!rightwardSearch) {
                for (int j = 0; j < size; j++) {
                    for (int i = 0; i < size; i++) {
                        if (board.isPositionEmpty(i, j)) {
                            board.placeToken(i, j, token);
                            return;
                        }
                    }
                }
            }
        }
        else {
            int row, col;

            do {
                row = randGen.nextInt(size);
                col = randGen.nextInt(size);
            }
            while (!board.isPositionEmpty(row, col));
            board.placeToken(row, col, token);
        }
    }


    /** -- Return the token of the engineer.
     * @return
     */
    public char getToken() {
        return token;
    }
}
