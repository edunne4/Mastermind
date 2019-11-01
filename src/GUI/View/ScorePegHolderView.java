/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 10/31/19
 * Time: 11:04 PM
 *
 * Project: csci205_hw02
 * Package: GUI.board
 * Class: ScorePegHolderView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.View;

import game.score.ScorePegEnum;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ScorePegHolderView extends StackPane {

    private static final double INIT_RADIUS = 5;

    ScorePegView currentPeg;

    /**
     * Creates an empty instance of Circle.
     */
    public ScorePegHolderView() {
        super();
        //create empty black circle
        this.getChildren().add(new Circle(INIT_RADIUS, Color.BLACK));
    }

    /**
     * Create a peg holder with a Code peg in it
     * @param newPeg - the peg that should be in the peg holder
     */
    public ScorePegHolderView(ScorePegEnum newPeg) {
        this();
        //TODO - change this to its own function for adding a peg to this holder
        this.currentPeg = new ScorePegView(newPeg);
        this.getChildren().add(this.currentPeg);
    }
}
