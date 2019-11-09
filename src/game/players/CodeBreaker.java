/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/23/19
 * Time: 3:41 PM
 *
 * Project: csci205_hw
 * Package: game.players
 * Class: CodeBreaker
 * Description:
 *
 * ****************************************
 */

package game.players;

import game.board.Board;
import game.code.Code;

/**
 * This abstract class represents the behavior of a codebreaker in the Mastermind game. The codebreaker's job is
 * to keep making guesses until it gets the correct guess. All guesses are played directly on the board using the
 * method {@link #playGuessOnBoard}.
 */
public abstract class CodeBreaker {
    /** All code breakers play their moves directly on a board */
    protected Board theBoard;

    /**
     * Create a new CodeBreaker with the specified {@link Board}
     *
     * @param theBoard
     */
    public CodeBreaker(Board theBoard) {
        this.theBoard = theBoard;
    }

    /**
     * Abstract method - the CodeBreaker implementation must play their move on the board
     *
     * @param row is the row that the CodeBreaker must play a move on
     */
    public abstract void playGuessOnBoard(int row);



    /**
     * Update the board with a specific guess
     * @param row the row index of the row to update
     * @param sGuess the guess to update the row with
     */
    public void playThisGuessOnBoard(int row, String sGuess){
        theBoard.getCodeAt(row).update(sGuess);
    }
}
