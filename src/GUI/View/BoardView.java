/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ethan Dunne
 * Section: 11am
 * Date: 11/3/19
 * Time: 3:01 PM
 *
 * Project: csci205_hw02
 * Package: GUI.View
 * Class: BoardView
 *
 * Description:
 *
 * ****************************************
 */
package GUI.View;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BoardView extends VBox {

    /** All row views in the board */
    private BoardRowView[] boardRows;


    /**
     * Creates a VBox layout with spacing = 0 and alignment at TOP_LEFT.
     */
    public BoardView(int numRows, int numPegs) {
        super(10);
        this.setAlignment(Pos.CENTER);

        boardRows = new BoardRowView[numRows];

        //make {numRows} rows each with {numPegs} pegs
        for (int i = 0; i < numRows; i++) {
            boardRows[i] = new BoardRowView(numPegs);
        }
        this.getChildren().addAll(boardRows);
    }

    public BoardRowView[] getBoardRows() {
        return boardRows;
    }
}
