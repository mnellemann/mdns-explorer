package biz.nellemann.mdexpl.service;

import biz.nellemann.mdexpl.NetworkServiceListener;
import biz.nellemann.mdexpl.model.NetworkService;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.jmdns.JmDNS;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class DiscoveryService {

    private final static Logger log = LoggerFactory.getLogger(DiscoveryService.class);

    private ObservableList<NetworkService> observableList;

    private JmDNS jmdns;

    /*private final HashMap<String, Color> services = HashMap<>({
        "http", "https", "upnp", "ssh", "sip", "rdp", "ntp", "rdp", "rtsp",
        "ntp", "smb", "nfs", "llrp", "ftp", "ep", "daap", "ipp", "ipps",
        "googlecast", "sonos", "airplay", "smartenergy", "skype", "bittorrent"
    );*/

    // From: http://www.dns-sd.org/serviceTypes.html +
    // https://jonathanmumm.com/tech-it/mdns-bonjour-bible-common-service-strings-for-various-vendors/ + some guesses
    private final Map<String, Color> services  = new HashMap<>() {{
        put("http", Color.BLUE);
        put("https", Color.DARKBLUE);

        put("googlecast", Color.RED);
        //put("googlezone", Color.RED);
        put("googlerpc", Color.RED);
        put("airplay", Color.SLATEGRAY);
        put("sonos", Color.SANDYBROWN);
        //put("spotify-connect", Color.SANDYBROWN);

        put("ssh", Color.GOLD);
        put("rdp", Color.GOLD);
        put("teamviewer", Color.GOLD);

        put("ipp", Color.LIGHTGRAY);
        put("ipps", Color.LIGHTGRAY);
        put("printer", Color.LIGHTGRAY);
        put("scanner", Color.LIGHTGRAY);

        put("nfs", Color.CORAL);
        put("smb", Color.CORAL);
        put("cifs", Color.CORAL);
        put("webdav", Color.CORAL);

        put("smartenergy", Color.LIGHTGREEN);
        put("hap", Color.LIGHTGREEN);
        put("homekit", Color.LIGHTGREEN);
        put("homebridge", Color.LIGHTGREEN);

        put("sip", Color.YELLOW);
        put("skype", Color.YELLOW);

        //put("rdlink", Color.KHAKI);
    }};


    @PostConstruct
    public void initialize() {
        log.info("initialize()");
        try {
            jmdns = JmDNS.create(InetAddress.getByName("0.0.0.0"), "mdnsExplorer");
        } catch (IOException e) {
            log.error("initialize() - {}", e.getMessage());
        }
    }


    public void setObservableList(ObservableList<NetworkService> list) {
        this.observableList = list;
        services.forEach((item, color) -> {
            String service = String.format("_%s._%s.local.", item, "tcp");
            NetworkServiceListener networkServiceListener = new NetworkServiceListener(service, observableList, color);
            jmdns.addServiceListener(service, networkServiceListener);
        });
    }

}
