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
package View;

import Model.code.CodePegEnum;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;

/**
 * Represents a physical code peg holder on a game board with the capability to hold and display a code peg GUI object
 */
public class CodePegHolderView extends StackPane {

    /** The row of the the board this is in (optional) */
    private BoardRowView rowThisIsIn = null;

    /** The current GUI peg view held by this peg holder */
    private CodePegView currentPeg;

    /** whether or not the code peg holder is selected by the user */
    private SimpleBooleanProperty isSelected = new SimpleBooleanProperty(false);


    /**
     * Initialize the the hole view
     */
    public CodePegHolderView() {
        super();
        //create empty black circle
        this.getChildren().add(new Circle(CodePegView.PEG_RADIUS*CodePegView.PEG_HOLE_SCALE_FACTOR, Color.BLACK));
        this.getChildren().add(new Circle(CodePegView.PEG_RADIUS *CodePegView.PEG_SELECTED_SCALE_FACTOR, Color.TRANSPARENT));

    }

    /**
     * Create a peg holder with a Code peg in it
     * @param newPeg - the peg that should be in the peg holder
     */
    public CodePegHolderView(CodePegEnum newPeg) {
        this();
        setCurrentPeg(newPeg);
    }

    /**
     * Create a peg holder with a Code peg in it
     * @param newPeg the peg that should be in the peg holder
     * @param rowThisIsIn the row view that this code peg holder belongs to
     */
    public CodePegHolderView(CodePegEnum newPeg, BoardRowView rowThisIsIn) {
        this();
        setCurrentPeg(newPeg);
        this.rowThisIsIn = rowThisIsIn;
    }

    /**
     * Assign a ScorePegView object to this peg holder to be displayed
     * @param newPeg the peg to be set
     */
    public void setCurrentPeg(CodePegEnum newPeg){
        setCurrentPeg(new CodePegView(newPeg));
    }

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


    /**
     * Make the peg appear selected
     */
    public void select(){
        this.isSelected.setValue(true);
        currentPeg.setRadius(CodePegView.PEG_RADIUS *CodePegView.PEG_SELECTED_SCALE_FACTOR);

        //set the specular color to WHITE
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(currentPeg.getPegType().getColor());
        material.setSpecularColor(Color.WHITE);
        currentPeg.setMaterial(material);
    }

    /**
     * Make the peg appear deselected
     */
    public void deselect(){
        this.isSelected.setValue(false);
        currentPeg.setRadius(CodePegView.PEG_RADIUS);

        //set the specular color back to DARKGRAY
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(currentPeg.getPegType().getColor());
        material.setSpecularColor(Color.DARKGRAY);
        currentPeg.setMaterial(material);

    }

    public CodePegView getCurrentPeg() {
        return currentPeg;
    }

    public BoardRowView getRowThisIsIn() {
        return rowThisIsIn;
    }

    public boolean isSelected() {
        return isSelected.get();
    }

    public SimpleBooleanProperty isSelectedProperty() {
        return isSelected;
    }

}
