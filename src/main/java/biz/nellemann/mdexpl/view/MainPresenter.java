package biz.nellemann.mdexpl.view;

import biz.nellemann.mdexpl.NetworkServiceCell;
import biz.nellemann.mdexpl.model.NetworkService;
import biz.nellemann.mdexpl.model.MainModel;
import biz.nellemann.mdexpl.service.DiscoveryService;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.LifecycleEvent;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
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

    private ObservableList<NetworkService> devicesList = FXCollections.observableArrayList();


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
            }
        });

        discoveryService.setObservableList(devicesList);

        charmListView.setItems(devicesList);
        charmListView.setCellFactory(p -> new NetworkServiceCell());
    }


    public void onEventShowing(LifecycleEvent lifecycleEvent) {

    }

    public void onEventHiding(LifecycleEvent lifecycleEvent) {
    }

}
