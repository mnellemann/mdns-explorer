package biz.nellemann.mdexpl;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.Taskbar.Feature;
import java.io.IOException;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Make all stages close and the app exit when the primary stage is closed
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });

        // Set icon on the application bar
        var appIcon = new Image("/icon.png");
        primaryStage.getIcons().add(appIcon);

        // Set icon on the taskbar/dock
        if (Taskbar.isTaskbarSupported()) {
            var taskbar = Taskbar.getTaskbar();

            if (taskbar.isSupported(Feature.ICON_IMAGE)) {
                final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                var dockIcon = defaultToolkit.getImage(getClass().getResource("/icon.png"));
                taskbar.setIconImage(dockIcon);
            }

        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("mDNS Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
