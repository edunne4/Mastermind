/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 10/31/19
 * Time: 10:09 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: BoardRowView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.View;

import game.board.RowOnBoard;
import game.code.Code;
import game.code.CodePegEnum;
import game.code.CodePegHolder;
import game.score.Score;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class BoardRowView extends HBox {
    /**
     * Possible states that the row can be in
     */
    private enum RowState {
        UNSET(Color.BLACK), ACTIVE(Color.RED), READY_TO_BE_SET(Color.GREENYELLOW), SET(Color.BLACK);

        /** Color to indicate state of a row, applied to the border */
        private Color indicatorColor;

        RowState(Color indicatorColor) {
            this.indicatorColor = indicatorColor;
        }

        public Color getIndicatorColor() {
            return indicatorColor;
        }


    }

    /** The state of the row. This will be used to determine and display which row is active */
    private RowState state = RowState.UNSET;

    /** a list of CodePegHolderView that will be stored as a part of the BoardRowView */
    private List<CodePegHolderView> codePegHolders = new ArrayList<>();

    /** an HBox to hold the pegRow (the playing pegs) */
    private HBox pegRow;

    /** an HBox to hold the scoreRow (the scoring pegs) */
    private HBox scoreRow;

    /**
     * Explicit constructor for showing an empty row
     * @param numPegs the number of pegs in a code guess
     */
    public BoardRowView(int numPegs) {
        this(new RowOnBoard(numPegs));
    }
    /**
     * Explicit constructor for showing a specific row
     * @param row the row to show
     */

    public BoardRowView(RowOnBoard row) {
        scoreRow = new HBox(10);
        pegRow = new HBox(10);
        this.setSpacing(10);

        Score score = row.getScore();

        //create empty scoring pegs
        for (int i = 0; i < row.getCode().getCodeSize(); i++) {
            scoreRow.getChildren().add(new ScorePegHolderView(score.getScoringPegAt(i)));
        }

        Code code = row.getCode();

        //create empty pegs
        for (int i = 0; i < row.getCode().getCodeSize(); i++) {
            codePegHolders.add(new CodePegHolderView(code.getPegAt(i), this));
        }

        pegRow.getChildren().addAll(codePegHolders);
        pegRow.setBorder(new Border(new BorderStroke(state.getIndicatorColor(), BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));

        this.getChildren().addAll(scoreRow, pegRow);
    }


    public List<CodePegHolderView> getCodePegHolders() {
        return codePegHolders;
    }

    /**
     * A method to determine if the row is full or not. Based on this, the border color of the row will be set.
     * @return a boolean. True if the row is full, false if the row is not full.
     */
    public boolean isRowFull(){
        for (Node child : pegRow.getChildren()) {
            CodePegHolderView pegHolder = (CodePegHolderView) child;
            if(pegHolder.getCurrentPeg().getPegType() == CodePegEnum.NONE){
                return false;
            }
        }
        state = RowState.READY_TO_BE_SET;
        //update border color
        updateBorderColor();
        return true;
    }

    /**
     * Set the state of the row to active
     */
    public void activate(){
        state = RowState.ACTIVE;
        updateBorderColor();
    }

    /**
     * Change the border color of the peg row based on the current state of the row
     */
    private void updateBorderColor(){
        pegRow.setBorder(new Border(new BorderStroke(state.getIndicatorColor(), BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));
    }

    /**
     * Convert the GUI code into a Game peg code
     * @return the Game peg code string that is represented by this row
     */
    public String getCodeString(){
        String sCode = "";
        for (Node child : this.pegRow.getChildren()) {
            CodePegHolderView pegHolder = (CodePegHolderView) child;
            CodePegView peg = pegHolder.getCurrentPeg();
            if(peg != null){
                sCode += peg.getPegType().toString();
            }
        }

        return sCode;
    }


    /**
     * Lock the current pegs into place by changing the state to set
     */
    public void confirmPegs(){
        state = RowState.SET;
        updateBorderColor();
    }

    /**
     * @return whether or not this row is in the active state or not
     */
    public boolean isActive() {
        return state == RowState.ACTIVE || state == RowState.READY_TO_BE_SET;
    }

    /**
     * Takes in a score from the model and sets the score visually in the view
     * @param score the score to set on the view
     */
    public void updateScore(Score score) {
        for (int i = 0; i < scoreRow.getChildren().size(); i++) {
            ScorePegHolderView pegHolderView = (ScorePegHolderView) scoreRow.getChildren().get(i);
            pegHolderView.setCurrentPeg(score.getScoringPegAt(i));
        }
    }

    public HBox getPegRow() {
        return pegRow;
    }

}
