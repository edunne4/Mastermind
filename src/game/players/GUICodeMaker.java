/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 11/3/19
 * Time: 2:04 PM
 *
 * Project: csci205_hw02
 * Package: game.players
 * Class: GUICodeMaker
 *
 * Description:
 *
 * ****************************************
 */
package game.players;

import game.board.Board;
import game.code.Code;

public class GUICodeMaker extends CodeMaker{

    /**
     * Create a new instance of CodeMaker with a specified {@link Board}
     *
     * @param theBoard
     */
    public GUICodeMaker(Board theBoard) {
        super(theBoard);
    }

    /**
     * Instruct the codeMaker to score the latest guess that is on the board
     *
     * @param row
     */
    @Override
    public void scoreGuessOnBoard(int row) {
        Code guess = theBoard.getCodeAt(row);
        //update model board
        scoreGuess(guess, theBoard.getScoreAt(row));

        //update display
    }

}
