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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;

public class CodePegHolderView extends StackPane {


    private BoardRowView rowThisIsIn = null;
    private CodePegView currentPeg;

    private SimpleBooleanProperty isSelected = new SimpleBooleanProperty(false);


    public CodePegHolderView() {
        super();
        //create empty black circle
        this.getChildren().add(new Circle(CodePegView.PEG_RADIUS*CodePegView.PEG_HOLE_SCALE_FACTOR, Color.BLACK));
//        Circle clickCircle = new Circle(CodePegView.INIT_RADIUS+2, Color.BLUEVIOLET);
//        clickCircle.setOpacity(0.2);
        //add a transparent circle for clicking on and to prevent size changes of a row
        this.getChildren().add(new Circle(CodePegView.PEG_RADIUS *CodePegView.PEG_SELECTED_SCALE_FACTOR, Color.TRANSPARENT));

//        //get border set up
//        this.select();
//        this.deselect();
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
     * Creates a StackPane layout with default CENTER alignment.
     */
    public CodePegHolderView(CodePegEnum newPeg, BoardRowView rowThisIsIn) {
        this();
        setCurrentPeg(newPeg);
        this.rowThisIsIn = rowThisIsIn;
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

    public void select(){
        this.isSelected.setValue(true);
        //super.setStroke(Color.BLACK); //TODO - change this color value to a binding
        //super.setStrokeWidth(4);
        currentPeg.setRadius(CodePegView.PEG_RADIUS *CodePegView.PEG_SELECTED_SCALE_FACTOR);

        //set the specular color to WHITE
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(currentPeg.getPegType().getColor());
        material.setSpecularColor(Color.WHITE);
        currentPeg.setMaterial(material);
    }
    public void deselect(){
        this.isSelected.setValue(false);
        //this.setStroke(Color.TRANSPARENT);
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
