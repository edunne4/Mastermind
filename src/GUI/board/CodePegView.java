/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 10/29/19
 * Time: 9:35 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: PlayingPeg
 *
 * Description:
 *
 * ****************************************
 */
package GUI.board;

import game.code.CodePegEnum;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CodePegView extends Circle {

    private static final double INIT_RADIUS = 20;

    //TODO possibly change the parameter to the paint color rather than enum to decrease class coupling between this and CodePegEnum
    public CodePegView(CodePegEnum codePeg) {
        super(INIT_RADIUS,codePeg.getColor());
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
