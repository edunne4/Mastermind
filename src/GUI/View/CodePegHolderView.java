/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 10/31/19
 * Time: 10:58 PM
 *
 * Project: csci205_hw02
 * Package: GUI.board
 * Class: CodePegHolderView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.View;

import game.code.CodePegEnum;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CodePegHolderView extends StackPane {

    private static final double INIT_RADIUS = 10;

    private CodePegView currentPeg;


    public CodePegHolderView() {
        super();
        //create empty black circle
        this.getChildren().add(new Circle(INIT_RADIUS, Color.BLACK));
    }

    /**
     * Create a peg holder with a Code peg in it
     * @param newPeg - the peg that should be in the peg holder
     */
    public CodePegHolderView(CodePegEnum newPeg) {
        this();
        setCurrentPeg(newPeg);
    }

    public void setCurrentPeg(CodePegEnum newPeg){
        setCurrentPeg(new CodePegView(newPeg));
    }
    //TODO maybe get rid of this overload and just have the one that accepts the enum as parameter
    public void setCurrentPeg(CodePegView newPegView) {
        this.currentPeg = newPegView;
        //return currentPeg.getPegType(); //TODO - return previous peg held here

        //this.getChildren().clear(); // get rid of any previous children
        if(newPegView.getPegType() != CodePegEnum.NONE) { // If there is a non-none peg here, show it
            this.getChildren().add(this.currentPeg);
        }
    }

    public CodePegView getCurrentPeg() {
        return currentPeg;
    }
}
