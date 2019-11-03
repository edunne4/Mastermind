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
    private RowState state = RowState.UNSET;

    /** A boolean for whether or not this is the current row being played or not. */
    //private SimpleBooleanProperty isActiveRow = new SimpleBooleanProperty(false);

    private List<CodePegHolderView> codePegHolders = new ArrayList<>();

    private HBox pegRow;

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
        this.setSpacing(20);


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

    public boolean isRowFull(){
        for (Node child : pegRow.getChildren()) {
            CodePegHolderView pegHolder = (CodePegHolderView) child;
            if(pegHolder.getCurrentPeg().getPegType() == CodePegEnum.NONE){
                return false;
            }
        }
        return true;
    }

    public void activate(){
        state = RowState.ACTIVE;
        pegRow.setBorder(new Border(new BorderStroke(state.getIndicatorColor(), BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));
    }


    /**
     * Confirm that these pegs are the ones to be locked in place
     * @return the code that these pegs form in the game's format
     */
    public void confirmPegs(){
        //use ordinal+1 of the pegs' enums to create the code in the games format

    }


    /**
     * @return whether or not this row is in the active state or not
     */
    public boolean isActive() {
        return state == RowState.ACTIVE;
    }
}
