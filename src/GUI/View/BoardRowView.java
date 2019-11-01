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
import javafx.scene.layout.HBox;

public class BoardRowView extends HBox {

    public BoardRowView() {
        HBox scoreRow = new HBox(20);
        HBox pegRow = new HBox(20);
        this.setSpacing(20);

        //create empty scoring peg holders
        for (int i = 0; i < 4; i++) {
            scoreRow.getChildren().add(new ScorePegHolderView());
        }

        //create empty code peg holders
        for (int i = 0; i < 4; i++) {
            pegRow.getChildren().add(new CodePegHolderView());
        }

        this.getChildren().addAll(scoreRow, pegRow);
    }

    public BoardRowView(RowOnBoard row) {
        HBox scoreRow = new HBox(20);
        HBox pegRow = new HBox(20);
        this.setSpacing(20);


        Score score = row.getScore();
        //create empty scoring pegs
        for (int i = 0; i < 4; i++) {
            scoreRow.getChildren().add(new ScorePegView(score.getScoringPegAt(i)));
        }

        Code code = row.getCode();
        //create empty pegs
        for (int i = 0; i < 4; i++) {
            pegRow.getChildren().add(new CodePegView(code.getPegAt(i)));
        }

        this.getChildren().addAll(scoreRow, pegRow);
    }
}
