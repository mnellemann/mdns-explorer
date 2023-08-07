package biz.nellemann.mdexpl.model;

import com.gluonhq.attach.cache.Cache;
import com.gluonhq.attach.cache.CacheService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Devices {

    private static final Cache<String, Image> CACHE;

    static {
        CACHE = CacheService.create()
            .map(cache -> cache.<String, Image>getCache("images"))
            .orElseThrow(() -> new RuntimeException("No CacheService available"));
    }

    private static final String URL_PATH = "https://upload.wikimedia.org/wikipedia/commons/thumb/";

    public static ObservableList<Device> statesList = FXCollections.observableArrayList(
        new Device("Alabama", "AL", "Montgomery", 4903185, 135767, URL_PATH + "5/5c/Flag_of_Alabama.svg/23px-Flag_of_Alabama.svg.png"),
        new Device("Alaska", "AK", "Juneau", 731545, 1723337, URL_PATH + "e/e6/Flag_of_Alaska.svg/21px-Flag_of_Alaska.svg.png"),
        new Device("Arizona", "AZ", "Phoenix", 7278717, 295233, URL_PATH + "9/9d/Flag_of_Arizona.svg/23px-Flag_of_Arizona.svg.png"),
        new Device("Arkansas", "AR", "Little Rock", 3017804, 137733, URL_PATH + "9/9d/Flag_of_Arkansas.svg/23px-Flag_of_Arkansas.svg.png"),
        new Device("California", "CA", "Sacramento", 39512223, 423968, URL_PATH + "0/01/Flag_of_California.svg/23px-Flag_of_California.svg.png"),
        new Device("Colorado", "CO", "Denver", 5758736, 269602, URL_PATH + "4/46/Flag_of_Colorado.svg/23px-Flag_of_Colorado.svg.png"),
        new Device("Connecticut", "CT", "Hartford", 3565287, 14356, URL_PATH + "9/96/Flag_of_Connecticut.svg/20px-Flag_of_Connecticut.svg.png"),
        new Device("Delaware", "DE", "Dover", 973764, 6446, URL_PATH + "c/c6/Flag_of_Delaware.svg/23px-Flag_of_Delaware.svg.png"),
        new Device("Florida", "FL", "Tallahassee", 21477737, 170312, URL_PATH + "f/f7/Flag_of_Florida.svg/23px-Flag_of_Florida.svg.png"),
        new Device("Georgia", "GA", "Atlanta", 10617423, 153910, URL_PATH + "5/54/Flag_of_Georgia_%28U.S._state%29.svg/23px-Flag_of_Georgia_%28U.S._state%29.svg.png"),
        new Device("Hawaii", "HI", "Honolulu", 1415872, 28314, URL_PATH + "e/ef/Flag_of_Hawaii.svg/23px-Flag_of_Hawaii.svg.png"),
        new Device("Idaho", "ID", "Boise", 1787065, 216443, URL_PATH + "a/a4/Flag_of_Idaho.svg/19px-Flag_of_Idaho.svg.png"),
        new Device("Illinois", "IL", "Springfield", 12671821, 149997, URL_PATH + "0/01/Flag_of_Illinois.svg/23px-Flag_of_Illinois.svg.png")

    );

    public static Image getUSFlag() {
        return getImage(URL_PATH + "a/a4/Flag_of_the_United_States.svg/320px-Flag_of_the_United_States.svg.png");
    }

    /**
     * This method will always return the required image.
     * It will cache the image and return from cache if still there.
     * @param image: A valid url to retrieve the image
     * @return an Image
     */
    public static Image getImage(String image) {
        if (image == null || image.isEmpty()) {
            return null;
        }
        Image cachedImage = CACHE.get(image);
        if (cachedImage == null) {
            cachedImage = new Image(image, true);
            cachedImage.errorProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    CACHE.remove(image);
                }
            });
            CACHE.put(image, cachedImage);
        }
        return cachedImage;
    }

}
