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

import GUI.View.BoardRowView;
import GUI.View.CodePegHolderView;
import GUI.View.CodePegView;
import game.GameManager;
import game.code.CodePegEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class MastermindView {

    private final MastermindModel theModel;

    private BorderPane root;

    /** The peg objects that can be clicked on for choosing pegs */
    private List<CodePegHolderView> pegOptions = new ArrayList<>();
    /** All row views in the board */
    private List<BoardRowView> boardRows = new ArrayList<>();

    private MenuDropdown menuDropdown;

    public MastermindView() {
        this.theModel = new MastermindModel();
        initSceneGraph();
    }

    private void initSceneGraph() {
        this.root = new BorderPane();

        root.setPadding(new Insets(15));

        MastermindTitle title = new MastermindTitle(300,80);
        VBox top = new VBox();
        top.getChildren().add(title);

        this.root.setTop(top);
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
        //********************************************


        //create board of rows ****************************
        VBox rowsView = new VBox(10);
        rowsView.setAlignment(Pos.CENTER);

        leftPane.getChildren().add(rowsView);

        for (int i = 0; i < 12; i++) {
            boardRows.add(new BoardRowView(4));
        }
        rowsView.getChildren().addAll(boardRows);
        this.root.setLeft(leftPane);
        //************************************************


        //do right pane (playing peg options)
        VBox rightPane = new VBox(20);
        //rightPane.setAlignment(Pos.CENTER);

        menuDropdown = new MenuDropdown();
        rightPane.getChildren().add(menuDropdown.getMenuBar());

        Label playingPegsLabel = new Label("PLAYING PEGS");

        rightPane.getChildren().add(playingPegsLabel);

        VBox pegOptionsBox = new VBox(20);
        pegOptionsBox.setAlignment(Pos.CENTER);

        //add all peg options to the right side
        for(CodePegEnum peg : CodePegEnum.values()){
            if(peg != CodePegEnum.NONE) {
                //TODO maybe these should not be CodePegView, but some selectable subclass
                CodePegHolderView pegHolderView = new CodePegHolderView(peg);
                //add to scene graph
                pegOptionsBox.getChildren().add(pegHolderView);
                //but also store it so that adding event handlers is easy
                pegOptions.add(pegHolderView);
            }
        }
        rightPane.getChildren().add(pegOptionsBox);
        root.setRight(rightPane);



    }

    public BorderPane getRoot() {
        return root;
    }

    public List<CodePegHolderView> getPegOptions() {
        return pegOptions;
    }

    public List<BoardRowView> getBoardRows() {
        return boardRows;
    }

    public MenuDropdown getMenuDropdown() {
        return menuDropdown;
    }
}