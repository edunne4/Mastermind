/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 12:00 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: CodeMaker
 * Description:
 *
 * ****************************************
 */

package Model.players;

import Model.board.Board;
import Model.code.Code;

/**
 * This is a codemaker that interacts with System.out to print the score.
 */
public class ConsoleCodeMaker extends CodeMaker {

    public ConsoleCodeMaker(Board theBoard) {
        super(theBoard);
    }

    /**
     * Score the guess that was played at the specified row. The score will be also stored at
     * the row
     *
     * @param row where the guess was played by the {@link CodeBreaker}
     */
    @Override
    public void scoreGuessOnBoard(int row)
    {
        Code guess = theBoard.getCodeAt(row);
        scoreGuess(guess, theBoard.getScoreAt(row));
        System.out.printf("You guessed %s --> %s\n", theBoard.getCodeAt(row).codeToString(),
                          theBoard.getScoreAt(row).scoreToString());
    }

}
