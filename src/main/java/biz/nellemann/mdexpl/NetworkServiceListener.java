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
import java.util.Iterator;

public class NetworkServiceListener implements ServiceListener {

    private static final Logger log = LoggerFactory.getLogger(NetworkServiceListener.class);

    private final String service;
    private final ObservableList<NetworkService> observableList;

    private final Color color;

    public NetworkServiceListener(String service, ObservableList<NetworkService> observableList, Color color) {
        log.debug("NetworkServiceListener() - type: {}", service);
        this.service = service;
        this.observableList = observableList;
        this.color = color;
    }

    @Override
    public void serviceAdded(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        log.info("serviceRemoved() - Service: " + serviceInfo.getName());
    }

    @Override
    public void serviceRemoved(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        if (serviceInfo != null) {
            String name = serviceInfo.getName();
            String url = serviceInfo.getURLs()[0];
            log.info("serviceRemoved() - Service: " + name);
            Platform.runLater( () -> {
                observableList.stream().filter(e -> (
                    e.getName().equals(name)
                )).forEach(observableList::remove);
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

            NetworkService networkService = new NetworkService(name, service, serviceInfo.getSubtype(), app, url, color);
            for (Iterator<String> it = serviceInfo.getPropertyNames().asIterator(); it.hasNext(); ) {
                String key = it.next();
                String value = serviceInfo.getPropertyString(key);
                //log.info(" -> " + key + " = " + value);
                networkService.addProperty(key, value);
            }

            Platform.runLater(() -> {
                if(!observableList.contains(networkService)) {
                    observableList.add(networkService);
                }
            });
        }

    }

}
