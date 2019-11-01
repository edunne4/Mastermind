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

public class MastermindController {
    private MastermindView theView;
//    private MastermindModel theModel;

    private CodePegEnum selectedPeg;


    public MastermindController(MastermindView theView/*, MastermindModel theModel  */) {
        this.theView = theView;
        //this.theModel = theModel;
        createEventHandlers();

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