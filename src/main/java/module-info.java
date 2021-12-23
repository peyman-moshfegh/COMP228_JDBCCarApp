module com.example.peymanmoshfegh_comp228_sec13_testfall2021 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql.rowset;

    opens com.example.peymanmoshfegh_comp228_sec13_testfall2021 to javafx.fxml;
    exports com.example.peymanmoshfegh_comp228_sec13_testfall2021;
}