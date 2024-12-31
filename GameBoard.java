package BridgeBuilderAdv;
/**
 * This class presents methods related to the Game Board.
 * @author Ariana F
 * @since 2023-07-03 :):):):):)woohhh!
 * 150 Word Summary below
 */

import java.util.Scanner;
public class GameBoard {
    private char[][] board;
    private int size;

    /**  Constructor- Initialize the board to a 2D char array with '.' representing empty positions.
     * @param size
     */
    public GameBoard(int size) {
        this.size = size;   //implicit parameter, if a field member and parameter have the same identifier6.11
        this.board = new char[this.size][this.size];

        for (int i = 0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = '.';
            }
        }
    }

    /**-- Place the given token at the specified row and column on the game board.
     * @param row
     * @param col
     * @param token
     */
    public void placeToken(int row, int col, char token) {
        board[row][col] = token;
    }

    /**Check whether the specified position on the board is empty (denoted by '.').
     * @param row
     * @param col
     * @return
     */
    public boolean isPositionEmpty(int row, int col) {
        return board[row][col] == '.';
    }


    /** -- Return the size of the game board.
     * @return
     */
    public int getSize() {
        return size;
    }

    /** -- Print the game board on the console, including row and column numbers.
     */
    public void displayBoard() {
        // Print letters A-Z
        System.out.print("  ");
        for (int i = 0; i < this.size; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        // Print numbers 0-25
        for (int i = 0; i < this.size; i++) {
            System.out.print((char) ('0' + i) + " ");

            for (int j = 0; j < this.size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** -- Check whether the player has won the game in any direction (left-to-right, bottom-to-top,
     * or diagonally). Return 1 for left-to-right, 2 for bottom-to-top, 3 for diagonal, and 0 for no win.
     */
    public int checkForWinDirection(Player player) {
        char playerToken = player.getToken();
        //checks bottom-to-top
        for (int j= 0; j<size; j++) {
            for (int i=0; i<size; i++) {
                if (board[i][j]!= playerToken) {
                    break;
                }
                if (i== size-1) {   //is used to check if we have reached the last element in the loop iteration.
                    return 2;
                }
            }
        }
        //checks left-to-right
        for (int i = 0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j] != playerToken) {
                    break;
                }
                if (j == size-1) {   //is used to check if we have reached the last element in the column
                    return 1;
                }
            }
        }
        //checks diagonal
        for (int i =1; i<size; i++) {
            if (board[i][i]!=playerToken) {
                break;
            }
            if (i== size-1) {
                return 3;
            }
        }
        return 0;
    }

    /**   -- Check whether the game board is full, indicating a tie.
     * @return
     */
    public boolean checkForTie() {
        for (int i = 1; i<size; i++) {
            for (int j=1; j<size; j++) {
                if (this.isPositionEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 150 Word Summary
 * So first I figured out that size parameter repr the size of the board, meaning
 * that the elements are actually 0 to (size-1). That's how I figured out the for loops
 * and also nested for loops because of the rows and columns. To test the solution,
 * I ran my code in Main, and compared with the expected output provided. I can explain
 * checkForWinDirection method (if player token makes a column section), basically for loop
 * starts column =0 and checks each row, which are elements in that column...then
 * to the next column =1 etc... if you reached last element in the column (and all elements
 * are player tokens), then you return 2, which refers to smth in Main.java.
 *
 * Challenges faced: This code actually took me less than an hour because it was a
 * modification from my original code (which took MANY days, sadly) and let me just say, I over-complicated
 * everything. For my original code, it was basically the same as this, but
 * I used this.size = size+1; so that the headers A-Z and side columns 0-25 also
 * counted as an element to iterate through in the for loops. OMG the amount of
 * small adjustments I had to make in my old code whether it be adding 1 subtracting
 * 1 and whatever. Glad I actually made that mistake tho, because I got a lot of practice
 * thinking of solutions to make my loops and conditions work with this.size=size+1;
 */


