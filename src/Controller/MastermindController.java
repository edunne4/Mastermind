/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis and Ethan Dunne
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 10/29/19
 * Time: 9:41 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MindMasterController
 *
 * Description:
 *
 * ****************************************
 */
package Controller;

import Model.MastermindModel;
import View.*;
import Model.code.CodePegEnum;
import Model.score.Score;
import javafx.scene.control.MenuItem;

/**
 * The controller of the MVC for this game, connecting the view with the model
 */
public class MastermindController {

    private MastermindView theView;
    private MastermindModel theModel;

    /** The type of peg that is currently selected */
    private CodePegEnum selectedPeg = CodePegEnum.NONE;


    /**
     * Explicit Constructor to set up event handlers between the view and the model
     * @param theView - the GUI view controller
     * @param theModel - the data of the mastermind game going on behind the scenes
     */
    public MastermindController(MastermindView theView, MastermindModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        pegEventHandlers();
        menuEventHandlers();
        exitEventHandler();
        buttonEventHandler();
        //doScrollPaneBindings();

        theView.activateRow(0);

    }

    /**
     * make the peg options selectable and make the board rows clickable
     */
    private void pegEventHandlers() {

        //make each peg option in the peg options have an on click event
        for (CodePegHolderView pegOption : theView.getPegOptions()) {
            //make each peg selectable/deselectable
            pegOption.setOnMouseClicked(event -> {
                CodePegHolderView pegHolderView = (CodePegHolderView) event.getSource();
                if(pegHolderView.isSelected()) {
                    deselectPeg(pegHolderView);
                }else{
                    selectPeg(pegHolderView);
                }
            });
        }


        //make peg holders selectable
        for (BoardRowView row : theView.getBoardView().getBoardRows()) {
            for (CodePegHolderView pegHolder : row.getCodePegHolders()) {
                pegHolder.setOnMouseClicked(event -> {
                    //if you have a peg option selected, place it on click
                    if(selectedPeg != CodePegEnum.NONE) {
                        //get the peg holder object
                        CodePegHolderView thisPegHolder = (CodePegHolderView) event.getSource();
                        //get the row it's in
                        BoardRowView theRowThisIsIn = thisPegHolder.getRowThisIsIn();
                        //if this is the active row
                        if(theRowThisIsIn != null && theRowThisIsIn.isActive()) {
                            //place peg in peg holder
                            thisPegHolder.setCurrentPeg(selectedPeg);
                            //check if the row is full and if so, display submit guess button
                            if (theRowThisIsIn.isRowFull()) {
                                //enable submit button
                                theView.allowGuess(true);
                            }
                        }
                    }
                });

            }
        }
    }

    /**
     * Set up event for when the submit button is pressed
     */
    private void buttonEventHandler() {
        theView.getSubmitBtn().setOnAction(event -> {
            //disable the button
            theView.allowGuess(false);

            BoardRowView currentRowView = theView.getBoardView().getRowViewAt(theModel.getTheGameManager().getNumTurnsPlayed());
            //make a guess with the code in the active row
            Score scoreForThisGuess = theModel.makeGuess(currentRowView.getCodeString());
//            System.out.println(scoreForThisGuess.scoreToString());
            currentRowView.updateScore(scoreForThisGuess);
            currentRowView.confirmPegs(); //changes the state from active to set

            //check for gameover
            if(theModel.getTheGameManager().isDone()){
                if(theModel.getTheGameManager().isWin()) {
                    theView.showWinMenu();
                }else{
                    theView.showLoseMenu();
                }
            }else{ //keep playing
                theView.activateRow(theModel.getTheGameManager().getNumTurnsPlayed());
            }
        });
    }


    /**
     * Handle the pressing of the exit button
     */
    private void exitEventHandler() {
        theView.getMenuDropdown().getQuit().setOnAction( event -> System.exit(0));
    }

    /**
     * handle when different options are chosen for numPegs and numRows
     */
    private void menuEventHandlers() {

        //set the number of pegs
        for (MenuItem menuItem : theView.getMenuDropdown().getNumPegs().getItems()) {
            menuItem.setOnAction(event -> {
                System.out.println("The user now wants " + menuItem.getText() + " pegs.");
                theModel.setNumberPegs(Integer.parseInt(menuItem.getText()));
                theView.createPlayingArea();

                //get game ready to be played again
                theView.activateRow(theModel.getTheGameManager().getNumTurnsPlayed());

                //recreate eventhandlers for all pegs
                pegEventHandlers();
                //doScrollPaneBindings();
            });

        }

        //set the number of turns
        for (MenuItem menuItem : theView.getMenuDropdown().getNumTurns().getItems()) {
            menuItem.setOnAction(event -> {
                System.out.println("The user now wants " + menuItem.getText() + " turns.");
                theModel.setNumberTurns(Integer.parseInt(menuItem.getText()));
                theView.createPlayingArea();
                //get game ready to be played again with the new number of pegs
                theView.activateRow(theModel.getTheGameManager().getNumTurnsPlayed());

                //recreate event handlers for all pegs
                pegEventHandlers();
                //doScrollPaneBindings();

            });

        }
    }

    private void doScrollPaneBindings() {
        theView.getScroller().prefViewportWidthProperty().bind(theView.getRoot().widthProperty().multiply(0.6));
    }


    /**
     * Helper method to select a peg option when it is clicked
     * @param pegClicked - the peg holder view that was clicked
     */
    private void selectPeg(CodePegHolderView pegClicked){
        //deselect all other pegs
        for (CodePegHolderView pegOption : theView.getPegOptions()) {
            deselectPeg(pegOption);
        }
        selectedPeg = pegClicked.getCurrentPeg().getPegType();
        pegClicked.select();
    }

    /**
     * Helper method to deselect a peg option when it is clicked
     * @param pegClicked - the peg option chosen to be deselected
     */
    private void deselectPeg(CodePegHolderView pegClicked){
        selectedPeg = CodePegEnum.NONE;
        pegClicked.deselect();
    }


}