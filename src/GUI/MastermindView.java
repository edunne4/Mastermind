/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 10/29/19
 * Time: 9:43 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MindMasterView
 *
 * Description:
 *
 * ****************************************
 */
package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MastermindView {

    private final MastermindModel theModel;

    private BorderPane root;

    public MastermindView() {
        this.theModel = new MastermindModel();

        initSceneGraph();
    }

    private void initSceneGraph() {
        this.root = new BorderPane();

        root.setPadding(new Insets(15));

        //create title pane
        Label titleLabel = new Label("MASTERMIND");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setTextFill(Color.SEAGREEN);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 60));
//        titleLabel.setPadding(new Insets(15));
        titleLabel.setBorder(new Border(new BorderStroke(Color.SEAGREEN, BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));
        this.root.setTop(titleLabel);
        root.setAlignment(root.getTop(), Pos.CENTER);
        root.setMargin(root.getTop(), new Insets(15));


        //center piece
        VBox centerPane = new VBox(20);
        centerPane.setAlignment(Pos.CENTER);

        //create board
        VBox rowsView = new VBox(20);
        //create secret code hider
        Label secretCodeLabel = new Label("SECRET CODE");
//        secretCodeLabel.setAlignment(Pos.CENTER);
        centerPane.getChildren().add(secretCodeLabel);
        centerPane.getChildren().add(rowsView);

        for (int i = 0; i < 12; i++) {
            HBox row = new HBox(20);
            for (int j = 0; j < 8; j++) {
                row.getChildren().add(new PlayingPeg(Color.GREEN));
            }
            rowsView.getChildren().add(row);
        }
        this.root.setCenter(centerPane);


        //add scoring rows
        VBox leftPane = new VBox(20);
        leftPane.getChildren().add(new Label("SCORE"));
        VBox scoreRowsView = new VBox(10);
        //add rows
        for (int i = 0; i < 12; i++) {
            HBox scoreRow = new HBox(20);
            for (int j = 0; j < 4; j++) {
                //TODO - change to add new empty peg
                scoreRow.getChildren().add(new PlayingPeg(Color.BLACK));
            }
            scoreRowsView.getChildren().add(scoreRow);
        }
        leftPane.getChildren().add(scoreRowsView);
        this.root.setLeft(leftPane);

    }

    public BorderPane getRoot() {
        return root;
    }
}