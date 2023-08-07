package biz.nellemann.mdexpl.service;

import biz.nellemann.mdexpl.NetworkServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Singleton
public class DiscoveryService {

    private final static Logger log = LoggerFactory.getLogger(DiscoveryService.class);

    // http://www.dns-sd.org/serviceTypes.html
    private final List<String> services = Arrays.asList(
        "http", "https", "upnp", "ssh", "sip", "rdp", "ntp", "rdp", "rtsp",
        "ntp", "smb", "nfs", "llrp", "ftp", "ep", "daap", "ipp", "ipps",
        "googlecast", "appletv", "appletv-itunes", "smartenergy", "skype", "bittorrent",
        "sonos", "airplay"
    );

    @PostConstruct
    public void initialize() {
        log.info("initialize()");
        try {
            JmDNS jmdns = JmDNS.create(null, "mdnsExplorer");
            services.forEach(service -> {
                String serviceType = String.format("_%s._%s.local.", service, "tcp");
                NetworkServiceListener networkServiceListener = new NetworkServiceListener(serviceType);
                jmdns.addServiceListener(serviceType, networkServiceListener);
            });
        } catch (IOException e) {
            log.error("initialize() - {}", e.getMessage());
        }
    }



}
