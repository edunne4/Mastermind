/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 10/31/19
 * Time: 11:19 PM
 *
 * Project: csci205_hw02
 * Package: GUI.board
 * Class: ScorePegView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.board;

import game.score.ScorePegEnum;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ScorePegView extends Circle {
    private static final double INIT_RADIUS = 10;

    public ScorePegView(ScorePegEnum scorePeg) {
        super(INIT_RADIUS,scorePeg.getColor());
        setupEffects();
    }

    /**
     * Add a drop shadow to the rectangles.
     */
    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);
    }
}
