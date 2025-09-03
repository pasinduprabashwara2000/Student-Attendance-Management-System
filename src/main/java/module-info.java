module edu.ijse.layered.fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires jbcrypt;
    requires net.sf.jasperreports.core;

    opens edu.ijse.layered.fx.view to javafx.fxml;
    opens edu.ijse.layered.fx.dto to javafx.base;
    opens edu.ijse.layered.fx to javafx.graphics;

    exports edu.ijse.layered.fx.view;
    exports edu.ijse.layered.fx.dto;
    exports edu.ijse.layered.fx;
}
