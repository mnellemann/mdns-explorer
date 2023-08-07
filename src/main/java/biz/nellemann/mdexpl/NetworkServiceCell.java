package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.ListTile;
import javafx.scene.image.ImageView;

public class NetworkServiceCell extends CharmListCell<NetworkService> {

    private final ListTile tile;
    private final ImageView imageView;

    public NetworkServiceCell() {
        this.tile = new ListTile();
        imageView = new ImageView();
        imageView.setFitHeight(15);
        imageView.setFitWidth(25);
        tile.setPrimaryGraphic(imageView);
        tile.setOnMouseClicked(e -> { System.out.println("Selected ->  " + itemProperty().get().getName() ); });
        setText(null);
    }

    @Override
    public void updateItem(NetworkService item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            tile.textProperty().setAll(item.getName() + " (" + item.getType() + ")",
                "App: " + item.getApp(), "URL: " + item.getUrl()
            );
            //final Image image = Devices.getImage(item.getFlag());
            /*if (image != null) {
                imageView.setImage(image);
            }*/
            setGraphic(tile);
        } else {
            setGraphic(null);
        }
    }


}
