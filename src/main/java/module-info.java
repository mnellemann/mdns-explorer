module biz.nellemann.mdexpl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javax.jmdns;
    requires org.slf4j;
    requires jakarta.inject;
    requires jakarta.annotation;
    requires atlantafx.base;

    opens biz.nellemann.mdexpl to javafx.fxml;
    exports biz.nellemann.mdexpl;
}
