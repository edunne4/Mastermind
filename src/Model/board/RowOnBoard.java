/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 2:31 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: RowOnBoard
 * Description:
 *
 * ****************************************
 */

package Model.board;

import Model.code.Code;
import Model.score.Score;

/**
 * This class represents a single row of {@link Code} and {@link Score} pegs a board in the game of Mastermind.
 * One row has both a Code played by a {@link Model.players.CodeBreaker}, and a Score played by a
 * {@link Model.players.CodeMaker}
 *
 * @author brk009
 */
public class RowOnBoard {
    /** The code played by a {@link Model.players.CodeBreaker} */
    private Code code;

    /** The score filled in by a {@link Model.players.CodeMaker} */
    private Score score;

    /**
     * Initialize a new row on the board
     * @param numPegs is the number of pegs used for each code
     */
    public RowOnBoard(int numPegs) {
        this.code = new Code(numPegs);
        this.score = new Score(numPegs);
    }

    public Code getCode() { return this.code; }
    public Score getScore() { return this.score; }

    /**
     * Remove all pegs from this row on the board, meaning, all entries will be set to their
     * respective NONE values.
     */
    public void removeAll() {
        code.removeAll();
        score.removeAll();
    }
}
