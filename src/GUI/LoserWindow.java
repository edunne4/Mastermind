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
package GUI;

import GUI.View.BoardRowView;
import game.board.RowOnBoard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoserWindow {

    VBox root;
    Button quitButton;
    Button playAgainButton;
    BoardRowView winningPegs;

    public LoserWindow() {

        root = new VBox(20);
        root.getChildren().add(new FancyTextTitle(300,100, "YOU LOST"));
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(15));


        quitButton = new Button("Close");
        playAgainButton = new Button("Play again");

        Text playingPegsText = new Text("The secret code was:");
        playingPegsText.setFill(Color.WHITE);

        winningPegs = new BoardRowView(6);

        HBox codeReveal = new HBox(20, playingPegsText,winningPegs.getPegRow());

        root.getChildren().add(codeReveal);

        root.getChildren().add(new HBox(20,quitButton,playAgainButton));

        codeReveal.setAlignment(Pos.CENTER);

        eventHandlers();

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