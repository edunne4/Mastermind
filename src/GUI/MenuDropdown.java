/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 11/2/19
 * Time: 10:05 PM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MeunDropDown
 *
 * Description: http://tutorials.jenkov.com/javafx/menubar.html
 *
 * ****************************************
 */
package GUI;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

public class MenuDropdown extends MenuBar {

    private static final int MIN_NUMBER_PEGS = 3;
    private static final int MAX_NUMBER_PEGS = 8;
    private static final int MIN_NUMBER_TURNS = 5;
    private static final int MAX_NUMBER_TURNS = 15;

    private static final int DEFAULT_NUMBER_PEGS = 4;
    private static final int DEFAULT_NUMBER_TURNS = 12;

    private MenuBar menuBar;
    private ToggleGroup numTurnsToggleGroup;
    private final ToggleGroup numPegsToggleGroup;
    private Menu quit;
    private final Menu numTurns;
    private final Menu numPegs;

    public MenuDropdown() {
        this.menuBar = new MenuBar();

        //get rid of background
        menuBar.setBackground(Background.EMPTY);

        Menu settings = new Menu("Settings");

        //set image of the settings settings
        ImageView settingsImage = new ImageView(new Image(getClass().getResourceAsStream("icons/settings.png")));
        settingsImage.setFitWidth(25);
        settingsImage.setFitHeight(25);
        settings.setGraphic(settingsImage);

        //create the "number of pegs" setting
        numPegs = new Menu("Number of Pegs");
        numPegsToggleGroup = new ToggleGroup();
        for (int i = MIN_NUMBER_PEGS; i <= MAX_NUMBER_PEGS; i++) {
            RadioMenuItem item = new RadioMenuItem(String.valueOf(i));
            numPegs.getItems().add(item);
            numPegsToggleGroup.getToggles().add(item);



            //set default num pegs toggle
            if (i == DEFAULT_NUMBER_PEGS) {
                numPegsToggleGroup.selectToggle(item);
            }
        }

        //create the "number of turns" settings
        numTurns = new Menu("Number of Turns");
        numTurnsToggleGroup = new ToggleGroup();
        for (int i = MIN_NUMBER_TURNS; i <= MAX_NUMBER_TURNS; i++) {
            RadioMenuItem item = new RadioMenuItem(String.valueOf(i));
            numTurns.getItems().add(item);
            numTurnsToggleGroup.getToggles().add(item);

            //set default num turns toggle
            if (i == DEFAULT_NUMBER_TURNS) {
                numTurnsToggleGroup.selectToggle(item);
            }

        }

        //set image of the settings settings
        quit = new Menu("Quit");
        ImageView exitIcon = new ImageView(new Image(getClass().getResourceAsStream("icons/exit.png")));
        exitIcon.setFitWidth(25);
        exitIcon.setFitHeight(25);
        quit.setGraphic(exitIcon);

        MenuItem quitforSure = new MenuItem("Exit Game Now");
        quit.getItems().add(quitforSure);


        //add to settings
        settings.getItems().addAll(numPegs, numTurns);
        menuBar.getMenus().add(settings);
        menuBar.getMenus().add(quit);


    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getQuit() {
        return quit;
    }

    public Menu getNumTurns() {
        return numTurns;
    }

    public Menu getNumPegs() {
        return numPegs;
    }
}