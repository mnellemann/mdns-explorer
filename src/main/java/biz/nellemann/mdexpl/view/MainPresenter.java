package biz.nellemann.mdexpl.view;

import biz.nellemann.mdexpl.model.MainModel;
import biz.nellemann.mdexpl.service.DiscoveryService;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.control.LifecycleEvent;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);


    @FXML
    private View main;

    @Inject
    private MainModel model;

    @Inject
    private DiscoveryService discoveryService;

    @FXML
    private ResourceBundle resources;

    @FXML
    private CharmListView charmListView;


    @FXML
    public void initialize() {

        log.info("initialize()");

        main.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppManager appManager = AppManager.getInstance();
                AppBar appBar = appManager.getAppBar();

                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e ->
                    appManager.getDrawer().open()));

                appBar.setTitleText("mDNS Explorer");
                //appBar.getActionItems().add(progressIndicator);
            }
        });


    }


    @FXML
    protected void onButtonRefresh() {
        log.info("onButtonRefresh()");


    }


    public void onEventShowing(LifecycleEvent lifecycleEvent) {

    }

    public void onEventHiding(LifecycleEvent lifecycleEvent) {
    }

}
