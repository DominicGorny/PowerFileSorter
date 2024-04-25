module com.example.powersorter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.powersorter to javafx.fxml;
    exports com.example.powersorter;
    exports com.example.powersorter.Controllers;
    opens com.example.powersorter.Controllers to javafx.fxml;
    exports com.example.powersorter.Enums;
    opens com.example.powersorter.Enums to javafx.fxml;
    exports com.example.powersorter.FileStructures;
    opens com.example.powersorter.FileStructures to javafx.fxml;
    exports com.example.powersorter.FileStructures.CommandStructures;
    opens com.example.powersorter.FileStructures.CommandStructures to javafx.fxml;
}