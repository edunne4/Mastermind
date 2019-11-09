/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 2:45 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: CodeBreaker
 * Description:
 *
 * ****************************************
 */

package game.players;

import game.board.Board;
import game.code.Code;

import java.util.Scanner;

/**
 * Represents a code breaker by asking the user for the next move to be played from the console {@link System#in}
 */
public class ConsoleCodeBreaker extends CodeBreaker {
    private Scanner in;

    public ConsoleCodeBreaker(Scanner in, Board theBoard) {
        super(theBoard);
        this.in = in;
    }

    /**
     * Ask the user for a valid move, and play it on the board
     * @param row is the row that the CodeBreaker must play a move on
     */
    @Override
    public void playGuessOnBoard(int row) {
        boolean isValid = false;
        String sGuess = null;
        while (!isValid) {
            System.out.printf("Guess %d: \n", row + 1);
            sGuess = in.nextLine().strip();
            if (Code.strIsValid(sGuess)) {
                isValid = true;
            }
            else {
                System.out.println("Invalid guess! Try again!");
            }
        }
        theBoard.getCodeAt(row).update(sGuess);
    }

}
