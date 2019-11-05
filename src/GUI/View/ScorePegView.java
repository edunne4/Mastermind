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
package GUI.View;

import game.score.ScorePegEnum;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class ScorePegView extends Sphere {

    private static final double PEG_RADIUS = 5;
    private ScorePegEnum pegType = ScorePegEnum.NONE;

    public ScorePegView(ScorePegEnum scorePeg) {
        super(PEG_RADIUS);
        this.pegType = scorePeg;

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(scorePeg.getColor());
        material.setSpecularColor(Color.DARKGRAY);
        this.setMaterial(material);
    }

    public ScorePegEnum getType() {
        return pegType;
    }
}
