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

import GUI.View.BoardRowView;
import GUI.View.CodePegHolderView;
import GUI.View.CodePegView;
import game.code.CodePegEnum;
import javafx.beans.binding.Bindings;
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

        theModel.startGame();
        theView.activateRow(0);

    }

    private void pegEventHandlers() {

        //make each peg option in the peg options have an on click event
        for (CodePegView pegOption : theView.getPegOptions()) {
            //make each peg selectable/deselectable
            pegOption.setOnMouseClicked(event -> {
                CodePegView pegView = (CodePegView) event.getSource();
                if(pegView.isSelected()) {
                    deselectPeg(pegView);
                }else{
                    selectPeg(pegView);
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
                                System.out.println("Row is full! Can Submit guess!");
                            }
                        }
                    }
                });

            }
            //set up binding for each row to show whether or not they are active
            //row.isActiveRowProperty().bind;
        }
    }


    private void exitEventHandler() {

        theView.getMenuDropdown().getQuit().setOnAction( event -> System.exit(0));


    }

    private void menuEventHandlers() {

        //set the number of pegs
        for (MenuItem menuItem : theView.getMenuDropdown().getNumPegs().getItems()) {
            menuItem.setOnAction(event ->
                    System.out.println("The user now wants " + menuItem.getText() + " pegs."));
        }

        //set the number of turns
        for (MenuItem menuItem : theView.getMenuDropdown().getNumTurns().getItems()) {
            menuItem.setOnAction(event ->
                    System.out.println("The user now wants " + menuItem.getText() + " turns."));
        }

    }

    private void selectPeg(CodePegView pegClicked){
        //deselect all other pegs
        for (CodePegView pegOption : theView.getPegOptions()) {
            deselectPeg(pegOption);
        }
        selectedPeg = pegClicked.getPegType();
        pegClicked.select();
    }

    private void deselectPeg(CodePegView pegClicked){
        selectedPeg = CodePegEnum.NONE;
        pegClicked.deselect();
    }


}