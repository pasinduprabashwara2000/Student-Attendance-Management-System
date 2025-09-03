package edu.ijse.layered.fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageReportsController {

    @FXML
    private Button attendanceBtn;

    @FXML
    private Button menuBtn;

    @FXML
    private Label titleLabel;

    @FXML
    private Hyperlink tradeMarkLabel;

    @FXML
    void navigateMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManageReportsController.class.getResource("/edu/ijse/layered/fx/MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.setResizable(false);
        stage.show();

        ((Stage) menuBtn.getScene().getWindow()).close();
    }

    @FXML
    void navigateReports(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManageReportsController.class.getResource("/edu/ijse/layered/fx/ManageAttendanceReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Manage Attendance Report");
        stage.setResizable(false);
        stage.show();

        ((Stage) attendanceBtn.getScene().getWindow()).close();
    }

}
