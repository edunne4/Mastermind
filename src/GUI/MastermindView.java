/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 10/29/19
 * Time: 9:43 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MindMasterView
 *
 * Description:
 *
 * ****************************************
 */
package GUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MastermindView {

    private final MastermindModel theModel;

    private VBox root;

    public MastermindView() {
        this.theModel = new MastermindModel();

        this.root = new VBox(20);

        for (int i = 0; i < 12; i++) {
            HBox row = new HBox(20);
            for (int j = 0; j < 8; j++) {
                row.getChildren().add(new PlayingPeg(Color.GREEN));
            }
            root.getChildren().add(row);
        }

    }

    public VBox getRoot() {
        return root;
    }
}