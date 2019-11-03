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
package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MastermindTitle extends BorderPane {

    private final static int LIGHT_SPACING = 10;
    private final static int LIGHT_SIZE = 10;
    private final static Color LIGHT_COLOR = Color.GOLD;


    public MastermindTitle(int width, int height) {

        //------set the top row of lights------//
        HBox topLights = new HBox(LIGHT_SPACING);
        int numLightsTop = width / (LIGHT_SIZE+LIGHT_SIZE);

        for (int i = 0; i < numLightsTop; i++) {
            Circle light = new Circle(LIGHT_SIZE, LIGHT_COLOR);
            topLights.getChildren().add(light);

        }

        this.setTop(topLights);

        //------set the bottom row of lights------//
        HBox bottomLights = new HBox(LIGHT_SPACING);
        int numLightsBottom = width / (LIGHT_SIZE+LIGHT_SIZE);

        for (int i = 0; i < numLightsBottom; i++) {
            Circle light = new Circle(LIGHT_SIZE, LIGHT_COLOR);
            bottomLights.getChildren().add(light);

        }

        this.setBottom(bottomLights);


        //------set the left column of lights------//
        VBox leftLights = new VBox(LIGHT_SPACING);
        leftLights.setPadding(new Insets(LIGHT_SPACING, 0, LIGHT_SPACING, 0));
        int numLightsLeft = height / (LIGHT_SIZE+LIGHT_SIZE);

        for (int i = 0; i < numLightsLeft; i++) {
            Circle light = new Circle(LIGHT_SIZE, LIGHT_COLOR);
            leftLights.getChildren().add(light);

        }

        this.setLeft(leftLights);

        //------set the left column of lights------//
        VBox rightLights = new VBox(LIGHT_SPACING);
        rightLights.setPadding(new Insets(LIGHT_SPACING, 0, LIGHT_SPACING, 0));
        int numLightsRight = height / (LIGHT_SIZE+LIGHT_SIZE);

        for (int i = 0; i < numLightsRight; i++) {
            Circle light = new Circle(LIGHT_SIZE, LIGHT_COLOR);
            rightLights.getChildren().add(light);

        }

        this.setRight(rightLights);

        //---set the center text---//
        //create title pane
        Label titleLabel = new Label("MASTERMIND");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setTextFill(Color.SEAGREEN);
        titleLabel.setMaxWidth(width - LIGHT_SIZE*2);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        titleLabel.setPadding(new Insets(5));
        //titleLabel.setBorder(new Border(new BorderStroke(Color.SEAGREEN, BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));


        this.setCenter(titleLabel);










    }


}