/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 11/3/19
 * Time: 2:01 PM
 *
 * Project: csci205_hw02
 * Package: game.players
 * Class: GUICodeBreaker
 *
 * Description:
 *
 * ****************************************
 */
package game.players;

import game.board.Board;

public class GUICodeBreaker extends CodeBreaker {

    /**
     * Create a new CodeBreaker with the specified {@link Board}
     *
     * @param theBoard
     */
    public GUICodeBreaker(Board theBoard) {
        super(theBoard);
    }

    /**
     * Abstract method - the CodeBreaker implementation must play their move on the board
     *
     * @param row is the row that the CodeBreaker must play a move on
     */
    @Override
    public void playGuessOnBoard(int row) {

    }
}
