package biz.nellemann.mdexpl.view;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class AboutPresenter {

    private static final Logger log = LoggerFactory.getLogger(AboutPresenter.class);


    @FXML
    private ResourceBundle resources;

    @FXML
    View about;

    @FXML
    Label labelInfoWebsite;

    @FXML
    Label labelVersion;

    @Inject String appVersion;
    @Inject String aboutWebsite;


    @FXML
    public void initialize() {
        log.info("initialize()");

        about.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();

                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                    appManager.getDrawer().open()));

                appBar.setTitleText("About");

                appBar.getActionItems().add(MaterialDesignIcon.CLOSE.button(e -> {
                    appManager.goHome();
                }));

            }
        });

        labelVersion.setText(appVersion);
        labelInfoWebsite.setText(aboutWebsite);

    }



}
