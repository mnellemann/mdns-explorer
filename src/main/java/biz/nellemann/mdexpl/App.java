package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.view.AppViewManager;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class App extends Application {

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        AppViewManager.registerViewsAndDrawer();
    }

    @Override
    public void start(Stage primaryStage) {
        //System.setProperty(com.gluonhq.attach.util.Constants.ATTACH_DEBUG,"true");
        appManager.start(primaryStage);
    }


    private void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);
        //scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("/icon.png"))));
    }


    public static void main(String[] args) {
        launch(args);
    }

}
