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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class WinnerView {

    VBox root;

    public WinnerView() {
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setPadding(new Insets(15));

        BorderPane title = new MastermindTitle(300,100, "YOU WON!");
        root.getChildren().add(title);

    }

    public VBox getRoot() {
        return root;
    }
}