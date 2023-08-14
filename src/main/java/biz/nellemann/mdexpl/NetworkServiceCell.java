package biz.nellemann.mdexpl;

import biz.nellemann.mdexpl.model.NetworkService;
import javafx.application.Platform;
import javafx.scene.control.ListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.Clipboard;


public class NetworkServiceCell extends ListCell<NetworkService> {

    private final Rectangle icon;

    private final Clipboard clipboard;
    private final ClipboardContent clipboardContent;

    HBox hBox;

    public NetworkServiceCell() {
        clipboard = Clipboard.getSystemClipboard();
        clipboardContent = new ClipboardContent();

        icon = new Rectangle();
        icon.setHeight(25);
        icon.setWidth(25);
        this.setGraphic(icon);

        this.setOnMouseClicked(e -> {
            if(itemProperty().get() != null) {
                clipboardContent.putString(itemProperty().get().getUrl());
                clipboard.setContent(clipboardContent);
            };
        });
        setText(null);
    }


    @Override
    public void updateItem(NetworkService item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.toString());
            icon.setFill(item.getColor());
            setGraphic(icon);
        }
    }

}
