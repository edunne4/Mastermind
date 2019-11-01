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

import GUI.board.BoardRowView;
import GUI.board.CodePegView;
import game.code.CodePegEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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


        //left piece (board)
        VBox leftPane = new VBox(20);
        leftPane.setAlignment(Pos.CENTER);

        //create labels *****************************
        HBox labels = new HBox(20);
        labels.setAlignment(Pos.CENTER);
        Label scoreLabel = new Label("SCORE");
        //scoreLabel.setAlignment(Pos.CENTER);
        labels.getChildren().add(scoreLabel);
        //create secret code hider TODO - this should be a stack a stack pane with the code behind it
        Label secretCodeLabel = new Label("SECRET CODE");
        //secretCodeLabel.setAlignment(Pos.CENTER);
        labels.getChildren().add(secretCodeLabel);

        leftPane.getChildren().add(labels);


        //create board of rows
        VBox rowsView = new VBox(20);
        rowsView.setAlignment(Pos.CENTER);

        leftPane.getChildren().add(rowsView);

        for (int i = 0; i < 12; i++) {
//            HBox row = new HBox(20);
//            for (int j = 0; j < 4; j++) {
//                row.getChildren().add(new PlayingPeg(Color.GREEN));
//            }
            rowsView.getChildren().add(new BoardRowView());
        }
        this.root.setLeft(leftPane);


//        //add scoring rows
//        VBox leftPane = new VBox(20);
//        leftPane.setAlignment(Pos.CENTER);
//        Label scoreLabel = new Label("SCORE");
//        //scoreLabel.setAlignment(Pos.CENTER);
//        leftPane.getChildren().add(scoreLabel);
//        VBox scoreRowsView = new VBox(20);
//        //add rows
//        for (int i = 0; i < 12; i++) {
//            HBox scoreRow = new HBox(20);
//            for (int j = 0; j < 4; j++) {
//                //TODO - change to add new empty peg
//                scoreRow.getChildren().add(new PlayingPeg(Color.BLACK));
//            }
//            scoreRowsView.getChildren().add(scoreRow);
//        }
//        leftPane.getChildren().add(scoreRowsView);
//        this.root.setLeft(leftPane);
//        this.root.setMargin(root.getLeft(), new Insets(20));
//        //root.setAlignment(root.getLeft(), Pos.CENTER);


        //do right pane (playing peg options)
        VBox rightPane = new VBox(20);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.getChildren().add(new Label("PLAYING PEGS"));

        VBox pegOptions = new VBox(20);
        pegOptions.setAlignment(Pos.CENTER);

        //add all peg options to the right side
        for(CodePegEnum peg : CodePegEnum.values()){
            if(peg != CodePegEnum.NONE) {
                pegOptions.getChildren().add(new CodePegView(peg));
            }
        }
        rightPane.getChildren().add(pegOptions);
        root.setRight(rightPane);


    }

    public BorderPane getRoot() {
        return root;
    }
}