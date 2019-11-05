package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WinnerMain extends Application {

    WinnerView theView;

    @Override
    public void init() throws Exception {
        super.init();
        theView = new WinnerView();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(theView.getRoot());

        primaryStage.setTitle("Winner winner, chicken dinner!");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();

    }
}
