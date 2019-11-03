/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 10/29/19
 * Time: 9:41 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MindMasterModel
 *
 * Description:
 *
 * ****************************************
 */
package GUI;

import game.GameManager;
import game.board.Board;
import game.players.*;

public class MastermindModel {

    /** Standard Mastermind has 12 guesses allowed */
    protected static final int DEFAULT_NUMBER_TURNS = 12;

    /** There are 4 positions to be guessed */
    protected static final int DEFAULT_CODE_SIZE = 4;

    protected static final int MIN_NUMBER_PEGS = 3;
    protected static final int MAX_NUMBER_PEGS = 8;
    protected static final int MIN_NUMBER_TURNS = 5;
    protected static final int MAX_NUMBER_TURNS = 15;

    /** Our game manager */
    private static GameManager theGameManager;
    private Board theBoard;

    public MastermindModel() {
        // Set up our board to be used between teh codemaker and codebreaker
        theBoard = new Board(DEFAULT_NUMBER_TURNS, DEFAULT_CODE_SIZE);

        // Create an instance of {@link ConsoleCodeMaker} to score guess and report back to System.out
        CodeMaker codeMaker = new GUICodeMaker(theBoard);

        // A {@link ConsoleCodeBreaker} will make guesses read in from the user at System.in
        CodeBreaker codeBreaker = new GUICodeBreaker(theBoard);

        // Finally, we have the game manager that keeps track of how a game progresses with a board, a codeMaker
        // and a codeBreaker
        theGameManager = new GameManager(theBoard, codeMaker, codeBreaker);

    }

    public Board getTheBoard() {
        return theBoard;
    }

    public void startGame(){
        System.out.println("Starting Game");
    }
    public void playNextTurn(){
        theGameManager.playNextTurn();
    }
}