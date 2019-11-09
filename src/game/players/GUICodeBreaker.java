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

/**
 * represents the codebreaker that the GUI uses to make guess on the model board
 */
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
     * Unused method because GUI View package determines what guess to make, and this codebreaker is part of the model,
     * which does not have access to the view package
     *
     * @param row is the row that the CodeBreaker must play a move on
     */
    @Override
    public void playGuessOnBoard(int row) {
        //String sGuess = theBoardView.getBoardRows().get(row).getCodeString();

        System.out.println("Making Guess");

        theBoard.getCodeAt(row).update("1234");
    }


}
