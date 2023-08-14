package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import biz.nellemann.mdexpl.service.DiscoveryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);


    @FXML
    private BorderPane view;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ListView<NetworkService> listView;

    @Inject
    DiscoveryService discoveryService;

    private final ObservableList<NetworkService> devicesList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        log.info("initialize()");

        view.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            log.info("Window closing");
            discoveryService.destroy();
        });

        discoveryService = new DiscoveryService();
        discoveryService.initialize();
        discoveryService.setObservableList(devicesList);
        listView.setItems(devicesList);
        listView.setCellFactory(p -> new NetworkServiceCell());
    }


}
