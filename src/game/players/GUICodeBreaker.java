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

import GUI.View.BoardView;
import game.board.Board;
import game.code.Code;

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
     *
     *
     * @param row is the row that the CodeBreaker must play a move on
     */
    @Override
    public void playGuessOnBoard(int row) {
        //String sGuess = theBoardView.getBoardRows().get(row).getCodeString();

        System.out.println("Making Guess");

        theBoard.getCodeAt(row).update("1234");
    }

    /**
     * Update the board with a specific guess
     * @param row the row index of the row to update
     * @param sGuess the guess to update the row with
     */
    @Override
    public void playThisGuessOnBoard(int row, String sGuess){
        theBoard.getCodeAt(row).update(sGuess);
    }
}
