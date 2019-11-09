/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Ryan Bailis
 * Section: MWF 11am
 * Instructor: Professor Brian King
 * Date: 11/3/19
 * Time: 10:29 AM
 *
 * Project: csci205_hw02
 * Package: GUI
 * Class: MastermindTitle
 *
 * Description:
 *
 * ****************************************
 */
package View;

import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * Fancy text for the title of the game
 */
public class FancyTextTitle extends BorderPane {

    private final static int LIGHT_SPACING = 5;
    private final static int LIGHT_SIZE = 10;

    private final static Color LIGHT_COLOR_OFF = Color.GOLDENROD;
    private final static Color LIGHT_COLOR_ON = Color.GOLD;
    private final static int LIGHT_FLASH_SPEED = 500; //ms transition time between the colors

    //window parameters
    private int width;
    private int height;
    private String text;


    public FancyTextTitle(int width, int height, String text) {
        this.width = width;
        this.height = height;
        this.text = text;

        //------set the top row of lights------//
        HBox topLights = new HBox(LIGHT_SPACING);
        topLights.setAlignment(Pos.CENTER);
        int numLightsTop = width / (LIGHT_SIZE+LIGHT_SPACING);

        for (int i = 0; i < numLightsTop; i++) {
            Circle light = new Circle(LIGHT_SIZE);
            startFlashing(light, i);
            topLights.getChildren().add(light);
        }

        this.setTop(topLights);

        //------set the bottom row of lights------//
        HBox bottomLights = new HBox(LIGHT_SPACING);
        bottomLights.setAlignment(Pos.CENTER);
        int numLightsBottom = width / (LIGHT_SIZE+LIGHT_SPACING);

        for (int i = 0; i < numLightsBottom; i++) {
            Circle light = new Circle(LIGHT_SIZE);
            startFlashing(light, i);
            bottomLights.getChildren().add(light);
        }

        this.setBottom(bottomLights);


        //------set the left column of lights------//
        VBox leftLights = new VBox(LIGHT_SPACING);
        leftLights.setAlignment(Pos.CENTER);
        leftLights.setPadding(new Insets(LIGHT_SPACING, 0, LIGHT_SPACING, 0));
        int numLightsLeft = height / (LIGHT_SIZE+LIGHT_SPACING) ;

        for (int i = 0; i < numLightsLeft; i++) {
            Circle light = new Circle(LIGHT_SIZE);
            startFlashing(light, i);
            leftLights.getChildren().add(light);
        }

        this.setLeft(leftLights);

        //------set the right column of lights------//
        VBox rightLights = new VBox(LIGHT_SPACING);
        rightLights.setAlignment(Pos.CENTER);
        rightLights.setPadding(new Insets(LIGHT_SPACING, 0, LIGHT_SPACING, 0));
        int numLightsRight = height / (LIGHT_SIZE+LIGHT_SPACING) ;

        for (int i = 0; i < numLightsRight; i++) {
            Circle light = new Circle(LIGHT_SIZE);
            startFlashing(light, i);
            rightLights.getChildren().add(light);
        }

        this.setRight(rightLights);

        //---set the center text---//
        //create title pane
        createTitlePane(this.text);

    }

    private void createTitlePane(String text) {
        Label titleLabel = new Label(text);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setMaxWidth(this.width - (LIGHT_SIZE*2));
        titleLabel.setMaxHeight(this.height - (LIGHT_SIZE*2));
        titleLabel.setFont(Font.font("Andale Mono", FontWeight.BOLD, 40));
        //titleLabel.setBorder(new Border(new BorderStroke(Color.SEAGREEN, BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));


        this.setCenter(titleLabel);
    }

    private void startFlashing(Circle light, int i) {

        if (i % 2 == 0) {
            FillTransition ft = new FillTransition(Duration.millis(LIGHT_FLASH_SPEED),light,LIGHT_COLOR_ON,LIGHT_COLOR_OFF);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        else {
            FillTransition ft = new FillTransition(Duration.millis(LIGHT_FLASH_SPEED),light,LIGHT_COLOR_OFF,LIGHT_COLOR_ON);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }

    }


}