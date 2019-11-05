/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 11/4/19
 * Time: 10:08 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: LooserWindow
 *
 * Description:
 *
 * ****************************************
 */
package GUI.PopupWindows;

import GUI.FancyTextTitle;
import GUI.MastermindMain;
import GUI.View.BoardRowView;
import game.board.RowOnBoard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * A class to create a window to be shown when the user loses the game.
 */
public class LoserWindow {

    /** the main scene graph of the winner window **/
    VBox root;

    /** the quit button that will allow the user to quit the game**/
    Button quitButton;

    /** the button that will allow the user to play again **/
    Button playAgainButton;

    /** the secret code pegs that will be displayed to the user **/
    BoardRowView winningPegs;

    public LoserWindow() {

        //setup the root as a VBox, add a FancyTextTitle and set the background parameters
        setupRoot();

        //create the buttons and add them to the root
        createButtons();

        //create the HBox that will allow the secret code to be displayed
        createCodeReveal();

        eventHandlers();

    }

    private void createCodeReveal() {
        HBox codeReveal = new HBox(20);
        codeReveal.setAlignment(Pos.CENTER);

        Text playingPegsText = new Text("The secret code was:");
        playingPegsText.setFill(Color.WHITE);
        codeReveal.getChildren().addAll(playingPegsText,winningPegs.getPegRow());

        winningPegs = new BoardRowView(6);
        root.getChildren().add(codeReveal);
    }

    private void createButtons() {
        quitButton = new Button("Close");
        playAgainButton = new Button("Play again");
        root.getChildren().add(new HBox(20,quitButton,playAgainButton));
    }

    private void setupRoot() {
        root = new VBox(20);
        root.getChildren().add(new FancyTextTitle(300,100, "YOU LOST"));
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(15));
    }

    private void eventHandlers() {
        quitButton.setOnMouseClicked(event -> System.exit(0));

        //TODO - make this so that a new game is started
        playAgainButton.setOnMouseClicked(event -> new MastermindMain());
    }

    public VBox getRoot() {
        return root;
    }

}