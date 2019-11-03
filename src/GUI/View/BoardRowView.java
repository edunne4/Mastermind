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
import game.score.Score;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class BoardRowView extends HBox {

    /** A boolean for whether or not this is the current row being played or not. */
    private SimpleBooleanProperty isActiveRow = new SimpleBooleanProperty(false);

    private List<CodePegHolderView> codePegHolders = new ArrayList<>();

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
        HBox scoreRow = new HBox(10);
        HBox pegRow = new HBox(10);
        this.setSpacing(20);


        Score score = row.getScore();
        //create empty scoring pegs
        for (int i = 0; i < row.getCode().getCodeSize(); i++) {
            scoreRow.getChildren().add(new ScorePegHolderView(score.getScoringPegAt(i)));
        }

        Code code = row.getCode();
        //create empty pegs
        for (int i = 0; i < row.getCode().getCodeSize(); i++) {
            codePegHolders.add(new CodePegHolderView(code.getPegAt(i)));
        }
        pegRow.getChildren().addAll(codePegHolders);
        pegRow.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));

        this.getChildren().addAll(scoreRow, pegRow);

    }


    public List<CodePegHolderView> getCodePegHolders() {
        return codePegHolders;
    }

    public boolean isActiveRow() {
        return isActiveRow.get();
    }

    public SimpleBooleanProperty isActiveRowProperty() {
        return isActiveRow;
    }
}
