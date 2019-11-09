/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/4/19
 * Time: 4:57 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: Board
 * Description:
 *
 * ****************************************
 */

package Model.board;

import Model.code.Code;
import Model.score.Score;

import java.util.ArrayList;

/**
 * This class will represent a board where the game play will take place. {@link Model.players.CodeMaker} and
 * {@link Model.players.CodeBreaker} will both play on a shared board, taking turns placing their pegs directly
 * on the board using their moves {@link Model.players.CodeBreaker#playGuessOnBoard} and
 * {@link Model.players.CodeMaker#scoreGuessOnBoard} respectively.
 */
public class Board {
    private int numRows;
    private int numPegs;
    private ArrayList<RowOnBoard> rows;

    /**
     * Initialize a new empty board for Mastermind
     * @param numRows - number of rows to allow to be played with the game
     * @param numPegs - the number of pegs allowed to guess
     */
    public Board(int numRows, int numPegs) {
        this.numRows = numRows;
        this.numPegs = numPegs;
        this.rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new RowOnBoard(numPegs));
        }
    }

    public RowOnBoard getRowAt(int i) {
        return rows.get(i);
    }

    public Code getCodeAt(int i) {
        return getRowAt(i).getCode();
    }
    public Score getScoreAt(int i) {
        return getRowAt(i).getScore();
    }

    public int getNumRows() { return this.numRows; }
    public int getNumPegs() { return this.numPegs; }

    /**
     * Remove all pegs on the board, by iterating through every row and removing their rows
     */
    public void removeAll() {
        for (int i = 0; i < numRows; i++) {
            rows.get(i).removeAll();
        }
    }

}
