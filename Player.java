package BridgeBuilderAdv;
/**
 * This class presents methods related to the player(you!).
 * @author Ariana F
 */

public class Player {
    private char token;
    private int score;

    /**   Constructor, Initialize the token and score.
     */
    public Player() {
        token = '+';
        score = 0;
    }

    /**   -- Place the player's token on the game board at the specified row and column.
     * @param board
     * @param row
     * @param col
     */
    public void makeMove(GameBoard board, int row, int col) {
        board.placeToken(row, col, this.token);
    }

    /**   -- Return the player's token.
     * @return
     */
    public char getToken() {
        return token;
    }

    /**    -- Return the player's current score.
     * @return
     */
    public int getScore() {
        return score;
    }

    /**  -- Increase the player's score by the specified increment.
     * @param increment
     */
    public void addScore(int increment) {
        score+= increment;
    }

}

