package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MastermindMain extends Application {

private MastermindController theController;
private MastermindModel theModel;
private MastermindView theView;

    @Override
    public void init() throws Exception {
        super.init();
        this.theModel = new MastermindModel();
        this.theView = new MastermindView(theModel);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.theController = new MastermindController(this.theView, this.theModel);

        Scene scene = new Scene(theView.getRoot());

        primaryStage.setTitle("Mastermind");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();


        //put this code in the "you won" function
//        WinnerWindow winner = new WinnerWindow();
//
//        Stage winnerStage = new Stage();
//
//        winnerStage.setScene(new Scene(winner.getRoot()));
//        winnerStage.setTitle("Winner winner, chicken dinner!");
//        winnerStage.sizeToScene();
//        winnerStage.show();
        /////////////////////////



        //put this code in the "you lost" function

        /////////////////////////

    }
}
