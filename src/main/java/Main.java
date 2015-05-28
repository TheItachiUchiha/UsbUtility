/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
*/

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 *
 * @author combozo
 */
public class Main extends Application {

    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;
    private Stage mainStage = new Stage();
    private static final int SPLASH_WIDTH = 676;
    private static final int SPLASH_HEIGHT = 227;

    @Override
    public void init() {
        ImageView splash = new ImageView();
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH - 20);
        progressText = new Label("تحميل بيانات البرنامج ...");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle("-fx-padding: 5; -fx-background-color: cornsilk; -fx-border-width:5; -fx-border-color: linear-gradient(to bottom, chocolate, derive(chocolate, 50%));");
        splashLayout.setEffect(new DropShadow());
    }

    @Override
    public void start(Stage initStage) throws Exception {
        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
        final Task preloaderTask = new Task() {
            @Override
            protected Object call() throws InterruptedException {
                updateMessage("Loading Chancecoin");
                /*  FXMLLoader fxmloader = new FXMLLoader();
                 Parent root = fxmloader.load(getClass().getResource("/views/mainFxml.fxml"));
                 MainFxmlController c = (MainFxmlController) fxmloader.getController();
                 Scene scene = new Scene(root);
                 //////////////////////


                 Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();


                 stage.getIcons().add(new Image(getClass().getResourceAsStream("/imgs/favIco.png")));

                 stage.setX(primaryScreenBounds.getMinX());
                 stage.setY(primaryScreenBounds.getMinY());
                 stage.setWidth(primaryScreenBounds.getWidth());
                 stage.setHeight(primaryScreenBounds.getHeight());
                 stage.setTitle("أستحــقاقــات");
                 /////////////////////////////////



                 stage.setScene(scene);
                 stage.show();

                 */
                return null;
            }
        };

        showSplash(initStage, preloaderTask);
        new Thread(preloaderTask).start();
        showMainStage();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }





    private void showMainStage() throws IOException {
        // create the scene
        FXMLLoader fxmloader = new FXMLLoader();
        Parent root = fxmloader.load(getClass().getResource("/views/mainFxml.fxml"));
        Scene scene = new Scene(root);
        //////////////////////


        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();


        mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/imgs/favIco.png")));

        mainStage.setX(primaryScreenBounds.getMinX());
        mainStage.setY(primaryScreenBounds.getMinY());
        mainStage.setWidth(primaryScreenBounds.getWidth());
        mainStage.setHeight(primaryScreenBounds.getHeight());
        mainStage.setTitle("أستحــقاقــات");
        /////////////////////////////////



        mainStage.setScene(scene);
        mainStage.show();

        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }



    private void showSplash(final Stage initStage, Task task) {
        progressText.textProperty().bind(task.messageProperty());
        loadProgress.progressProperty().bind(task.progressProperty());
        task.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                if (newState == Worker.State.SUCCEEDED) {
                    loadProgress.progressProperty().unbind();
                    loadProgress.setProgress(1);
                    mainStage.setIconified(false);
                    initStage.toFront();
                    FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
                    fadeSplash.setFromValue(1.0);
                    fadeSplash.setToValue(0.0);
                    fadeSplash.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            initStage.hide();
                        }
                    });
                    fadeSplash.play();
                }
            }
        });

        Scene splashScene = new Scene(splashLayout);
        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }
}