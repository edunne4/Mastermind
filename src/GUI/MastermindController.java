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

import GUI.View.CodePegView;
import game.code.CodePegEnum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class MastermindController {

    private MastermindView theView;
    private MastermindModel theModel;

    private CodePegEnum selectedPeg;


    public MastermindController(MastermindView theView, MastermindModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        createEventHandlers();
        menuEventHandlers();
        exitEventHandler();

    }

    private void createEventHandlers() {

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
        //TODO - deselect all other pegs
        selectedPeg = pegClicked.getPegType();
        pegClicked.select();
        System.out.println("Selected");
    }

    private void deselectPeg(CodePegView pegClicked){
        selectedPeg = CodePegEnum.NONE;
        pegClicked.deselect();
        System.out.println("Deselected");
    }


}