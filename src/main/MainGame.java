package main;/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 *
 * Name: YOUR NAME
 * Date: 10/18/19
 * Time: 2:30 PM
 *
 * Project: csci205_hw
 * Package: game
 * Class: Game
 * Description:
 *
 * ****************************************
 */

import Model.GameManager;
import Model.board.Board;
import Model.code.CodePegEnum;
import Model.players.CodeBreaker;
import Model.players.CodeMaker;
import Model.players.ConsoleCodeBreaker;
import Model.players.ConsoleCodeMaker;

import java.util.Scanner;

/**
 * This is an example main method that sets up and runs a standard Mastermind game. It shows how to instantiate
 * the important objects used in a game. The majority of a game is run by an instance of {@link GameManager}.
 *
 * @author brk009
 */
public class MainGame {

    /** Standard Mastermind has 12 guesses allowed */
    public static final int NUM_GUESSES = 12;

    /** There are 4 positions to be guessed */
    public static final int CODE_SIZE = 4;

    /** Our game manager */
    private static GameManager theGameManager;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Set up our board to be used between teh codemaker and codebreaker
        Board theBoard = new Board(NUM_GUESSES, CODE_SIZE);

        // Create an instance of {@link ConsoleCodeMaker} to score guess and report back to System.out
        CodeMaker codeMaker = new ConsoleCodeMaker(theBoard);

        // A {@link ConsoleCodeBreaker} will make guesses read in from the user at System.in
        CodeBreaker codeBreaker = new ConsoleCodeBreaker(in, theBoard);

        // Finally, we have the game manager that keeps track of how a game progresses with a board, a codeMaker
        // and a codeBreaker
        theGameManager = new GameManager(theBoard, codeMaker, codeBreaker);

        /*
         * A game is simple. Initialize a new game (which does the work of clearing the board and creating a new
         * secret code. Then, keep taking turns until the game is done, meaning the game is either won (guess was
         * correct), or lost (no more guesses available)
         */
        printGreeting();
        theGameManager.initNewGame();
        while(!theGameManager.isDone()) {
            theGameManager.playNextTurn();
        }
        if (theGameManager.isWin()) {
            System.out.println("Congratulations! You WIN!");
        }
        else {
            System.out.println("Whomp whomp! Sorry. You lose. Correct code was: " + codeMaker.getSecretCode().codeToString());
        }
    }

    /**
     * Print the welcome message for the user
     */
    private static void printGreeting() {
        System.out.printf("Welcome to Mastermind! You have %d guesses, %d pegs for each guess.\n",NUM_GUESSES,CODE_SIZE);
        System.out.print("Valid guesses are: ");
        for (CodePegEnum peg : CodePegEnum.values()) {
            if (peg == CodePegEnum.NONE)
                continue;
            System.out.print(peg.toString() + " ");
        }
        System.out.println();
    }


}
