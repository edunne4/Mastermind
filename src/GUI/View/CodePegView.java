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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;

public class CodePegView extends Sphere {

    static final double INIT_RADIUS = 20;
    static final double SCALE_FACTOR = 1.2;

    private CodePegEnum pegType = CodePegEnum.NONE;


    //TODO possibly change the parameter to the paint color rather than enum to decrease class coupling between this and CodePegEnum
    public CodePegView(CodePegEnum codePeg) {
        super(INIT_RADIUS);
        this.pegType = codePeg;
        setupEffects();

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(codePeg.getColor());
        material.setSpecularColor(Color.DARKGRAY);
        this.setMaterial(material);


    }

    /**
     * Add a drop shadow to the circles.
     */
    private void setupEffects() {
        DropShadow ds = new DropShadow();
        ds.setOffsetX(4.0);
        ds.setOffsetY(4.0);
        ds.setColor(Color.BLACK);
        this.setEffect(ds);
    }

    public CodePegEnum getPegType() {
        return pegType;
    }




}
