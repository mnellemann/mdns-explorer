module biz.nellemann.mdexpl {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.jmdns;
    requires org.slf4j;
    requires javax.inject;
    requires java.annotation;
    requires java.desktop;

    opens biz.nellemann.mdexpl to javafx.fxml;
    exports biz.nellemann.mdexpl;
}
