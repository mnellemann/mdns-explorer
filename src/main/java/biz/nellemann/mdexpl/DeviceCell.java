package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.Device;
import biz.nellemann.mdexpl.model.Devices;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.ListTile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeviceCell extends CharmListCell<Device> {

    private final ListTile tile;
    private final ImageView imageView;

    public DeviceCell() {
        this.tile = new ListTile();
        imageView = new ImageView();
        imageView.setFitHeight(15);
        imageView.setFitWidth(25);
        tile.setPrimaryGraphic(imageView);
        setText(null);
    }

    @Override
    public void updateItem(Device item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            tile.textProperty().setAll(item.getName() + " (" + item.getAbbr() + ")",
                "Capital: " + item.getCapital() +
                    ", Population (M): " + String.format("%.2f", item.getPopulation() / 1_000_000d),
                "Area (km" + "\u00B2" + "): " + item.getArea() +
                    ", Density (pop/km" + "\u00B2" + "): " + String.format("%.1f", item.getDensity())
            );
            final Image image = Devices.getImage(item.getFlag());
            if (image != null) {
                imageView.setImage(image);
            }
            setGraphic(tile);
        } else {
            setGraphic(null);
        }
    }

}
