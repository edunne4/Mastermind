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
package View;

import Model.score.ScorePegEnum;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**
 * A class to represent a scoring peg in the view
 */
public class ScorePegView extends Sphere {

    /** The size of the peg in the view */
    private static final double PEG_RADIUS = 5;

    /** The type of the peg, with attribute color */
    private ScorePegEnum pegType;

    /**
     * A constructor that will, based on the scorePeg, create a Sphere that will represent the peg in the view.
     * @param scorePeg - the representation of the peg to create
     */
    public ScorePegView(ScorePegEnum scorePeg) {
        super(PEG_RADIUS);
        this.pegType = scorePeg;

        //set the color and material of the peg
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(scorePeg.getColor());
        material.setSpecularColor(Color.DARKGRAY);
        this.setMaterial(material);
    }

    public ScorePegEnum getType() {
        return pegType;
    }
}
