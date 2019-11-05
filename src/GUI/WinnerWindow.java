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
package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class WinnerWindow {

    VBox root;
    Button quitButton;
    Button playAgainButton;

    public WinnerWindow() {

        root = new VBox(20);
        root.getChildren().add(new FancyTextTitle(300,100, "YOU WON!"));
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(15));


        quitButton = new Button("Close");
        playAgainButton = new Button("Play again");

        root.getChildren().add(new HBox(20,quitButton,playAgainButton));

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