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
//        Circle clickCircle = new Circle(CodePegView.INIT_RADIUS+2, Color.BLUEVIOLET);
//        clickCircle.setOpacity(0.2);
        //add a transparent circle for clicking on and to prevent size changes of a row
        this.getChildren().add(new Circle(CodePegView.INIT_RADIUS+2, Color.TRANSPARENT));
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
    public CodePegEnum setCurrentPeg(CodePegView newPegView) {
        //return the previous peg type held here if it is not null
        CodePegEnum oldPeg = (currentPeg != null) ? currentPeg.getPegType() : CodePegEnum.NONE;

        //remove the old peg
        this.getChildren().remove(this.currentPeg);

        //set the new one
        this.currentPeg = newPegView;
        if(newPegView.getPegType() != CodePegEnum.NONE) { // If there is a non-none peg here, show it
            this.getChildren().add(this.currentPeg);
        }
        return  oldPeg;
    }

    public CodePegView getCurrentPeg() {
        return currentPeg;
    }
}
