package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import com.gluonhq.attach.util.impl.ClipboardUtils;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.ListTile;
import javafx.scene.input.ClipboardContent;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.Clipboard;

import java.util.Optional;

public class NetworkServiceCell extends CharmListCell<NetworkService> {

    private final ListTile tile;
    private final Rectangle icon;

    private final Clipboard clipboard;
    private final ClipboardContent clipboardContent;

    public NetworkServiceCell() {
        clipboard = Clipboard.getSystemClipboard();
        clipboardContent = new ClipboardContent();

        this.tile = new ListTile();
        //imageView = new ImageView();
        //imageView.setFitHeight(15);
        //imageView.setFitWidth(25);
        //tile.setPrimaryGraphic(imageView);
        icon = new Rectangle();
        icon.setHeight(25);
        icon.setWidth(25);
        tile.setPrimaryGraphic(icon);
        tile.setOnMouseClicked(e -> {
            clipboardContent.putString(itemProperty().get().getUrl());
            clipboard.setContent(clipboardContent);
        });
        setText(null);
    }

    @Override
    public void updateItem(NetworkService item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            tile.textProperty().setAll(item.getName(),
                item.getApp() + " (" + item.getSubType() + ") - " + item.getUrl()
            );
            icon.setFill(item.getColor());
            setGraphic(tile);
        } else {
            setGraphic(null);
        }
    }


}
