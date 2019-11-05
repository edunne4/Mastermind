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
package GUI.View;

import game.code.CodePegEnum;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class CodePegView extends Sphere {

    /** The size of the peg in the view */
    static final double PEG_RADIUS = 20;

    /** The factor by which to expand to indicate to the user it is selected */
    static final double PEG_SELECTED_SCALE_FACTOR = 1.2;

    /** The factor by which to make the peg hole */
    static final double PEG_HOLE_SCALE_FACTOR = 0.5;

    /** The type of the peg, with attribute color */
    private CodePegEnum pegType = CodePegEnum.NONE;

    /**
     * A constructor that will, based on the codePeg, create a Sphere that will represent the peg in the view.
     * @param codePeg - the representation of the peg to create
     */
    public CodePegView(CodePegEnum codePeg) {
        super(PEG_RADIUS);
        this.pegType = codePeg;

        //set the color and material of the peg
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(codePeg.getColor());
        material.setSpecularColor(Color.DARKGRAY);
        this.setMaterial(material);
    }


    public CodePegEnum getPegType() {
        return pegType;
    }




}
