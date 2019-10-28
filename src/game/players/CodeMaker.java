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
 * Class: CodeMaker
 * Description:
 *
 * ****************************************
 */

package game.players;

import game.board.Board;
import game.code.Code;
import game.code.CodePegEnum;
import game.code.SecretCode;
import game.score.Score;
import game.score.ScorePegEnum;

/**
* This class represents the behavior of a CodeMaker in the Mastermind game. A
 * codemaker's job is to hold a secret code, and give back scores based on guesses made
 * The code maker scores guesses that are played on the board, and stores the score back
 * on the board.
 *
 * @author brk009
*/
public abstract class CodeMaker {
    /** The {@link Board} that the codemaker uses to score guesses made. Scores are stored back to the board */
    protected Board theBoard;

    /** The secret code that is created and stored by the CodeMaker */
    protected SecretCode secretCode;

    /**
     * Create a new instance of CodeMaker with a specified {@link Board}
     * @param theBoard
     */
    public CodeMaker(Board theBoard) {
        this.theBoard = theBoard;
        this.secretCode = new SecretCode(theBoard.getNumPegs());
        this.secretCode.generate();
    }

    /**
     * Instruct the codeMaker to generate a new secret code
     */
    public void generateNewSecret() {
        this.secretCode.generate();
    }

    /**
     * Get the secret - this eventually needs to be revealed if the game is lost, so we need a way to provide it!
     * @return the secret code {@link SecretCode}
     */
    public SecretCode getSecretCode() { return this.secretCode; }

    /**
     * Instruct the codeMaker to score the latest guess that is on the board
     */
    public abstract void scoreGuessOnBoard(int row);

    /**
     * This does the heavy work of scoring a guess. Keeping this function away from the public API for
     * the time, since it shouldn't be necessary to work outside of the board.
     *
     * @param guess - the guess to score
     * @param score - the score to update based on the guess
     */
    protected void scoreGuess(Code guess, Score score) {

        // Make a copy so that we can safely erase pegs as we're checking, for simplicity
        Code secretCopy = this.secretCode.copyOf(),
                guessCopy = guess.copyOf();

        // First, check for exact matches...
        for (int i = 0; i < guess.getCodeSize(); i++) {
            if (secretCopy.getPegAt(i) == guess.getPegAt(i)) {
                score.addPeg(ScorePegEnum.RED);
                secretCopy.remove(i);
                guessCopy.remove(i);
            }
        }

        // Check out the remaining for occurrence in different positions
        for (int i = 0; i < guess.getCodeSize(); i++) {
            if (guessCopy.getPegAt(i) == CodePegEnum.NONE)
                continue;

            // If the secret contains the peg at position i
            Integer j = secretCopy.contains(guessCopy.getPegAt(i));
            if (j != null) {
                score.addPeg(ScorePegEnum.WHITE);
                guessCopy.remove(i);
                secretCopy.remove(j);
            }
        }
    }


}
