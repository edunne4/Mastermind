/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 11/4/19
 * Time: 8:40 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: WinnerView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.PopupWindows;

import GUI.FancyTextTitle;
import GUI.MastermindMain;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * A class to create a window to be shown when the user wins the game.
 */
public class WinnerWindow {

    /** the main scene graph of the winner window **/
    VBox root;

    /** the quit button that will allow the user to quit the game**/
    Button quitButton;

    /** the button that will allow the user to play again **/
    Button playAgainButton;

    public WinnerWindow() {

        //setup the root as a VBox, add a FancyTextTitle and set the background parameters
        setupRoot();

        //create the buttons and add them to the root
        createButtons();

        eventHandlers();

    }

    /**
     * A helper function that will setup the root
     */
    private void setupRoot() {
        root = new VBox(20);
        root.getChildren().add(new FancyTextTitle(300,100, "YOU WON!"));
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(15));
    }

    /**
     * A helper function will add the buttons to the root
     */
    private void createButtons() {
        quitButton = new Button("Close");
        playAgainButton = new Button("Play again");
        root.getChildren().add(new HBox(20,quitButton,playAgainButton));
    }

    /**
     * Set up handlers for the game over buttons
     */
    private void eventHandlers() {
        quitButton.setOnMouseClicked(event -> System.exit(0));

        //TODO - make this so that a new game is started
        playAgainButton.setOnMouseClicked(event -> new MastermindMain());
    }

    public VBox getRoot() {
        return root;
    }
}