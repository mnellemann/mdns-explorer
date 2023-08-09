package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class NetworkServiceListener implements ServiceListener {

    private static final Logger log = LoggerFactory.getLogger(NetworkServiceListener.class);

    private final String service;
    private final ObservableList<NetworkService> observableList;

    private final Color color;

    public NetworkServiceListener(String service, ObservableList<NetworkService> observableList, Color color) {
        log.info("NetworkServiceListener() - type: {}", service);
        this.service = service;
        this.observableList = observableList;
        this.color = color;
    }

    @Override
    public void serviceAdded(ServiceEvent event) {
    }

    @Override
    public void serviceRemoved(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        if (serviceInfo != null) {
            String name = serviceInfo.getName();
            log.info("serviceRemoved() - Service: " + name);
            NetworkService oldNetworkService = new NetworkService(name, service, serviceInfo.getApplication(), serviceInfo.getURLs()[0], color);
            Platform.runLater(() -> {
                observableList.remove(oldNetworkService);
            });
        }
    }

    @Override
    public void serviceResolved(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        if (serviceInfo != null) {
            String url = serviceInfo.getURLs()[0];
            String name = serviceInfo.getName();
            String app = serviceInfo.getApplication();
            log.info("serviceResolved() - Service: {} - {} with url {}", app, name, url);
            NetworkService newNetworkService = new NetworkService(name, service, app, url, color);
            Platform.runLater(() -> {
                if(!observableList.contains(newNetworkService)) {
                    observableList.add(newNetworkService);
                }
            });
        }

    }

}
