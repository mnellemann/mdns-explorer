package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import biz.nellemann.mdexpl.service.DiscoveryService;
import jakarta.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.ResourceBundle;

public class MainPresenter {

    private static final Logger log = LoggerFactory.getLogger(MainPresenter.class);



    @FXML
    private BorderPane view;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ListView<NetworkService> listView;

    @FXML
    public ListView<String> propertiesList;

    @Inject
    DiscoveryService discoveryService;

    private final ObservableList<NetworkService> devicesList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        log.info("initialize()");
        listView.setItems(devicesList);
        listView.setCellFactory(p -> new NetworkServiceCell());
        discoveryService = new DiscoveryService(devicesList);
    }


}
