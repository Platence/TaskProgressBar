package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.progressBarTask.ProcessingBar;

public class Controller {

    @FXML
    private AnchorPane mainPane;

    public void initialize() {
        ProgressBar pb = new ProgressBar();
        pb.setLayoutY(10);
        pb.setLayoutX(10);

        ProgressBar pb2 = new ProgressBar();
        pb2.setLayoutY(30);
        pb2.setLayoutX(30);


        Platform.runLater(() ->
                {
                    mainPane.getChildren().add(pb);
                    mainPane.getChildren().add(pb2);
                }
        );

        Thread t1 = new Thread(new ProcessingBar(pb));
        Thread t2 = new Thread(new ProcessingBar(pb2));
        t1.setDaemon(true);t2.setDaemon(true);
        t1.start();
        t2.start();

    }
}
