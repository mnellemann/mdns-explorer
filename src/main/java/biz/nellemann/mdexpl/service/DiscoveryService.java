package biz.nellemann.mdexpl.service;

import biz.nellemann.mdexpl.NetworkServiceListener;
import biz.nellemann.mdexpl.model.NetworkService;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.jmdns.JmDNS;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Singleton
public class DiscoveryService {

    private final static Logger log = LoggerFactory.getLogger(DiscoveryService.class);

    private ObservableList<NetworkService> observableList;

    private JmDNS jmdns;

    // From: http://www.dns-sd.org/serviceTypes.html + some guesses
    private final List<String> services = Arrays.asList(
        "http", "https", "upnp", "ssh", "sip", "rdp", "ntp", "rdp", "rtsp",
        "ntp", "smb", "nfs", "llrp", "ftp", "ep", "daap", "ipp", "ipps",
        "googlecast", "sonos", "airplay", "smartenergy", "skype", "bittorrent"
    );

    @PostConstruct
    public void initialize() {
        log.info("initialize()");
        try {
            jmdns = JmDNS.create(null, "mdnsExplorer");
        } catch (IOException e) {
            log.error("initialize() - {}", e.getMessage());
        }
    }

    public void register() {

    }

    public void setObservableList(ObservableList<NetworkService> list) {
        this.observableList = list;
        services.forEach(service -> {
            String serviceType = String.format("_%s._%s.local.", service, "tcp");
            NetworkServiceListener networkServiceListener = new NetworkServiceListener(serviceType, observableList);
            jmdns.addServiceListener(serviceType, networkServiceListener);
        });
    }


}
