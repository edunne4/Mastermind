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

import GUI.View.*;
import game.code.CodePegEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class MastermindView {

    private final MastermindModel theModel;

    private BorderPane root;

    /** The peg objects that can be clicked on for choosing pegs */
    private List<CodePegHolderView> pegOptions = new ArrayList<>();

    private BoardView boardView;

    private MenuDropdown menuDropdown;
    private Button submitBtn;
    private ScrollPane scroller;


    public MastermindView(MastermindModel theModel) {
        this.theModel = theModel;
        initSceneGraph();
    }

    private void initSceneGraph() {
        this.root = new BorderPane();

        //set general styling attributes of the root
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
        root.setPadding(new Insets(15));

        //create the mastermind title. This will be placed at the top of the window.
        createTitle();

        //create the playing area of the game. This includes the scoring and playing peg holders.
        createPlayingArea();

        //create the playing pegs and menu. This will be placed on the right side of the window.
        createPegsandMenu();
    }

    private void createTitle() {
        FancyTextTitle title = new FancyTextTitle(300,45, "MASTERMIND");
        VBox top = new VBox();
        top.getChildren().add(title);

        this.root.setTop(top);
        root.setAlignment(root.getTop(), Pos.CENTER);
        root.setMargin(root.getTop(), new Insets(15));
    }

    private void createPegsandMenu() {

        //do right pane (playing peg options)
        VBox rightPane = new VBox(20);
        //rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(0,0,0,20));

        menuDropdown = new MenuDropdown();
        rightPane.getChildren().add(menuDropdown.getMenuBar());

        //submit guess button
        submitBtn = new Button("SUBMIT GUESS");
        submitBtn.setDisable(true); //disable it to start off
        rightPane.getChildren().add(submitBtn);



        Label playingPegsLabel = new Label("PLAYING PEGS");
        rightPane.getChildren().add(playingPegsLabel);

        // peg options *******************************************
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
        //********************************************************
        root.setRight(rightPane);
    }

    public void createPlayingArea() {
        scroller = new ScrollPane();
        VBox board = new VBox(20);
        board.setPadding(new Insets(10));
        board.setBorder(new Border(new BorderStroke(Color.WHEAT, BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(10))));
        board.setAlignment(Pos.TOP_CENTER);

        //create board of rows ****************************
        boardView = new BoardView(theModel.getTheGameManager().getTheBoard().getNumRows(), theModel.getTheGameManager().getTheBoard().getNumPegs());
        board.getChildren().add(boardView);
        scroller.setContent(board);
        scroller.setPrefViewportHeight(100);
        //scroller.setMinViewportWidth(250);
        this.root.setLeft(scroller);
    }

    public BorderPane getRoot() {
        return root;
    }

    public List<CodePegHolderView> getPegOptions() {
        return pegOptions;
    }

    public void showWinMenu(){
        WinnerWindow winner = new WinnerWindow();

        Stage winnerStage = new Stage();

        winnerStage.setScene(new Scene(winner.getRoot()));
        winnerStage.setTitle("Winner winner, chicken dinner!");
        winnerStage.sizeToScene();
        winnerStage.show();
    }

    public void showLoseMenu(){
        LoserWindow loser = new LoserWindow();

        Stage looserStage = new Stage();

        looserStage.setScene(new Scene(loser.getRoot()));
        looserStage.setTitle("Awww. You lost!");
        looserStage.sizeToScene();
        looserStage.show();
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public MenuDropdown getMenuDropdown() {
        return menuDropdown;
    }

    public void activateRow(int rowIndex) {
        if(rowIndex < boardView.getBoardRows().size()) {
            boardView.getBoardRows().get(rowIndex).activate();
        }
    }

    public void allowGuess(boolean enable){
        submitBtn.setDisable(!enable);
    }

    public Button getSubmitBtn() { return submitBtn; }

    public ScrollPane getScroller() {
        return scroller;
    }
}