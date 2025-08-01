module biz.nellemann.mdexpl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires atlantafx.base;
    requires jakarta.inject;
    requires org.slf4j;
    requires javax.jmdns;

    opens biz.nellemann.mdexpl to javafx.fxml;
    exports biz.nellemann.mdexpl;
    exports biz.nellemann.mdexpl.model;
}
