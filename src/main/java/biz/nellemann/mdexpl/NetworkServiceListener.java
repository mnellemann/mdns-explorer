package biz.nellemann.mdexpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.util.HashMap;

public class NetworkServiceListener implements ServiceListener {

    private static final Logger log = LoggerFactory.getLogger(NetworkServiceListener.class);

    private final HashMap<String, String> onlineList = new HashMap<>();

    private final String serviceType;

    public NetworkServiceListener(String type) {
        log.info("NetworkServiceListener() - type: {}", type);
        this.serviceType = type;
    }

    @Override
    public void serviceAdded(ServiceEvent event) {
    }

    @Override
    public void serviceRemoved(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        if (serviceInfo != null) {
            String name = serviceInfo.getName();
            onlineList.remove(name);
            log.info("serviceRemoved() - Removed service: " + name);
        }
    }

    @Override
    public void serviceResolved(ServiceEvent event) {
        ServiceInfo serviceInfo = event.getInfo();
        if (serviceInfo != null) {
            String url = serviceInfo.getURLs()[0];
            String name = serviceInfo.getName();
            String app = serviceInfo.getApplication();
            log.debug(serviceInfo.toString());
            onlineList.put(name, url);
            log.info("serviceResolved() - Found {}: {} with url {}", app, name, url);
        }

    }

}
