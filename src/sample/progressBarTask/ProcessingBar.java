package sample.progressBarTask;

import javafx.application.Platform;
import javafx.beans.value.ObservableDoubleValue;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class ProcessingBar extends Task<Void> {

    private ProgressBar progressBar;
    private static final double MAX_VALUE = 1.0D;

    public ProcessingBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected Void call() throws Exception {

        // Есть ещё вариант с методом bind
        // Например
        // progressBar.progressProperty().bind(this.progressProperty());

        double startValue = 0D;
        System.out.println("start");
        while (startValue<MAX_VALUE){
            Thread.sleep(1000);
            setValue(startValue+=0.1D);
            System.out.println("Change Bar");
        }
        return null;
    }

    private void setValue(double value){
        Platform.runLater(()->{this.progressBar.setProgress(value);});
    }




}
