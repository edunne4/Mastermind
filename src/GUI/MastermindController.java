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
import game.code.CodePegHolder;
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
        for (BoardRowView row : theView.getBoardRows()) {
            for (CodePegHolderView pegHolder : row.getCodePegHolders()) {
                pegHolder.setOnMouseClicked(event -> {
                    if(selectedPeg != CodePegEnum.NONE) {
                        CodePegHolderView thisPegHolder = (CodePegHolderView) event.getSource();
                        thisPegHolder.setCurrentPeg(selectedPeg);
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