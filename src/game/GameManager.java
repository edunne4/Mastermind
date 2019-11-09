/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 3:23 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: Game
 * Description:
 *
 * ****************************************
 */

package game;

import game.board.Board;
import game.players.CodeBreaker;
import game.players.CodeMaker;
import game.players.GUICodeMaker;
import game.score.Score;

/**
 * A class that encapsulates all objects needed to play a game of Mastermind. It includes the following
 * <ul>
 *     <li>{@link Board}</li>
 *     <li>{@link CodeMaker}</li>
 *     <li>{@link CodeBreaker}</li>
 * </ul>
 * It provides a method, {@link #playNextTurn()} to control playing an entire turn, including fetching a code from
 * the CodeBreaker, and scoring it from the CodeMaker. After instantiating a Game instance, play begins as soon
 * as the first call to {@link #playNextTurn()} is invoked
 */
public class GameManager {
    /**
     * Possible states that the game can be in
     */
    private enum GameState {
        READY, CODEBREAKER_TURN, CODEMAKER_RESPOND, DONE;

    }
    /** The board that will maintain all pegs played thorughout the game */
    private Board theBoard;

    /** The codeMaker who scores guesses */
    private CodeMaker codeMaker;

    /** The codeBreaker, who will make guesses */
    private CodeBreaker codeBreaker;

    /** The current state of the game */
    private GameState state;

    /** The current row being played in the game, initialized to -1 before the game begins */
    private int currentRowBeingPlayed;

    /**
     * Construct a new Game instance with a specified board, codeMaker and codeBreaker. The game state
     * is initialized to {@link GameState#READY} and the current row is initialized to -1 until the
     * game play begins by invoking {@link #playNextTurn()}
     *
     * @param theBoard represents the {@link Board} instance being managed
     * @param codeMaker is the {@link CodeMaker} who will score guesses
     * @param codeBreaker is the {@link CodeBreaker} who will make guesses
     */
    public GameManager(Board theBoard, CodeMaker codeMaker, CodeBreaker codeBreaker) {
        this.theBoard = theBoard;
        this.codeMaker = codeMaker;
        this.codeBreaker = codeBreaker;
        this.state = GameState.READY;
        this.currentRowBeingPlayed = -1;
    }

    /**
     * Initialize a new game, which comes down to basically clearing everything out and creating
     * a new code
     */
    public void initNewGame() {
        theBoard.removeAll();
        codeMaker.generateNewSecret();
    }

    /** @return {@code true} is the game is finished, {@code false} otherwise */
    public boolean isDone() {
        return state == GameState.DONE;
    }

    /**
     * @return {@code true} if the last guess played is a winning guess, which is only determined after
     * the {@link CodeMaker} scores the guess that was played at the most recent row played
     */
    public boolean isWin() {
        return theBoard.getScoreAt(currentRowBeingPlayed).isWin();
    }

    /**
     * @return the number of total rows in the game
     */
    public int getNumRowsInGame() { return theBoard.getNumRows(); }

    /**
     * @return the total number of pegs used for a guess
     */
    public int getNumPegsForGuess() { return theBoard.getNumPegs(); }

    /**
     * @return the number of rows that have been played in this game
     */
    public int getNumTurnsPlayed() {
        return currentRowBeingPlayed + 1;
    }


    /**
     * Performs the heavy work of orchestrating everything that needs to happen to ensure ONE turn is executed
     * in the correct order. This method will first call {@link CodeBreaker#playGuessOnBoard(int)} to play a
     * guess on the board at the current row. Then {@link CodeMaker#scoreGuessOnBoard(int)} will score that guess by
     * placing the scoring pegs on the board.
     *
     * If the game represents a win, then the game is set to {@link GameState#DONE}
     * If the game has no more moves available on the board, it is also set to {@link GameState#DONE}
     *
     * The {@link #isWin()} method can be used to see if the current game is a winning game or not
     *
     * @return {@link GameState}
     */
    public GameState playNextTurn() {
        currentRowBeingPlayed++;

        if (state == GameState.READY || state == GameState.CODEBREAKER_TURN) {
            codeBreaker.playGuessOnBoard(currentRowBeingPlayed);
            state = GameState.CODEMAKER_RESPOND;
            codeMaker.scoreGuessOnBoard(currentRowBeingPlayed);

            if (isWin())
                state = GameState.DONE;
            else {
                if (currentRowBeingPlayed+1 == theBoard.getNumRows())
                    state = GameState.DONE;
                else
                    state = GameState.CODEBREAKER_TURN;
            }
        }
        return state;
    }


    /**
     * This method is similar to playNextTurn but with specific guess parameter that can be called by the rest of the MVC
     * @param sGuess the guess to use on the next turn
     * @return the current game state
     */
    public GameState playNextTurnWithGuess(String sGuess) {
        currentRowBeingPlayed++;

        if (state == GameState.READY || state == GameState.CODEBREAKER_TURN) {
            //codeBreaker.playGuessOnBoard(currentRowBeingPlayed);
            codeBreaker.playThisGuessOnBoard(currentRowBeingPlayed, sGuess);
            state = GameState.CODEMAKER_RESPOND;
            codeMaker.scoreGuessOnBoard(currentRowBeingPlayed);

            if (isWin())
                state = GameState.DONE;
            else {
                if (currentRowBeingPlayed+1 == theBoard.getNumRows())
                    state = GameState.DONE;
                else
                    state = GameState.CODEBREAKER_TURN;
            }
        }
        return state;
    }


    /**
     * @return the board object that is currently being played
     */
    public Board getTheBoard() {
        return theBoard;
    }

    /**
     * @return the score of the current row being played
     */
    public Score getCurrentScore() {
        return theBoard.getScoreAt(currentRowBeingPlayed);
    }
}
