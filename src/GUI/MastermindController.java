/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
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
package GUI;

import GUI.View.*;
import game.code.CodePegEnum;
import game.code.CodePegHolder;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import game.score.Score;
import javafx.scene.control.MenuItem;

public class MastermindController {

    private MastermindView theView;
    private MastermindModel theModel;

    private CodePegEnum selectedPeg = CodePegEnum.NONE;


    public MastermindController(MastermindView theView, MastermindModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        pegEventHandlers();
        menuEventHandlers();
        exitEventHandler();
        buttonEventHandler();

        theView.activateRow(0);

    }

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
            //set up binding for each row to show whether or not they are active
            //row.isActiveRowProperty().bind;
        }
    }

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


    private void exitEventHandler() {

        theView.getMenuDropdown().getQuit().setOnAction( event -> System.exit(0));


    }

    private void menuEventHandlers() {

        //set the number of pegs
        for (MenuItem menuItem : theView.getMenuDropdown().getNumPegs().getItems()) {
            menuItem.setOnAction(event -> {
                System.out.println("The user now wants " + menuItem.getText() + " pegs.");
                theModel.setNumberPegs(Integer.parseInt(menuItem.getText()));
                theView.createPlayingArea();

                //get game ready to be played again
                resetGame();

                //recreate eventhandlers for all pegs
                pegEventHandlers();
            });

        }

        //set the number of turns
        for (MenuItem menuItem : theView.getMenuDropdown().getNumTurns().getItems()) {
            menuItem.setOnAction(event -> {
                System.out.println("The user now wants " + menuItem.getText() + " turns.");
                theModel.setNumberTurns(Integer.parseInt(menuItem.getText()));
                theView.createPlayingArea();
                //get game ready to be played again
                resetGame();

                //recreate eventhandlers for all pegs
                pegEventHandlers();

            });

        }
    }

    private void resetGame(){
        //reset the model's game
        //theModel.getTheGameManager().initNewGame();

        //reset the view's game
        BoardRowView currentRowView = theView.getBoardView().getRowViewAt(theModel.getTheGameManager().getNumTurnsPlayed());
        currentRowView.activate();

    }

    private void selectPeg(CodePegHolderView pegClicked){
        //deselect all other pegs
        for (CodePegHolderView pegOption : theView.getPegOptions()) {
            deselectPeg(pegOption);
        }
        selectedPeg = pegClicked.getCurrentPeg().getPegType();
        pegClicked.select();
    }

    private void deselectPeg(CodePegHolderView pegClicked){
        selectedPeg = CodePegEnum.NONE;
        pegClicked.deselect();
    }


}