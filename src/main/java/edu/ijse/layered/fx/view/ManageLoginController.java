package edu.ijse.layered.fx.view;

import edu.ijse.layered.fx.controller.UserController;
import edu.ijse.layered.fx.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageLoginController {

    private final UserController userController = new UserController();

    @FXML
    private Button clearBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Label roleLabel;

    @FXML
    private ChoiceBox<String> rolePicker;

    @FXML
    private Label titleLabel;

    @FXML
    private Hyperlink tradeMarkLabel;

    @FXML
    private TextField userTxt;

    @FXML
    void navigateClear(ActionEvent event) {
        userTxt.setText("");
        passwordTxt.setText("");
        rolePicker.setValue(null);
    }

    @FXML
    void navigateLogin(ActionEvent event) {

        try {
            String username = userTxt.getText();
            String password = passwordTxt.getText();
            String role = rolePicker.getValue();

            if (username.isEmpty() || password.isEmpty() || role == null) {
                showAlert(Alert.AlertType.WARNING, "Please fill all fields!");
                return;
            }

            UserDto userdto = new UserDto(username, password, role);

            boolean loginSuccess = userController.login(userdto);

            if (loginSuccess) {
                if (role.equalsIgnoreCase("Admin")) {
                    openWindow("/edu/ijse/layered/fx/MainMenu.fxml", "Main Menu");
                    showAlert(Alert.AlertType.INFORMATION, "Admin Login Successfully!");
                } else if (role.equalsIgnoreCase("Lecture")) {
                    openWindow("/edu/ijse/layered/fx/ManageAttendance.fxml", "Manage Attendance");
                    showAlert(Alert.AlertType.INFORMATION, "Lecture Login Successfully!");
                } else {
                    showAlert(Alert.AlertType.WARNING, "Invalid role!");
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Invalid username or password!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    private void openWindow(String fxmlPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManageLoginController.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();

        ((Stage) loginBtn.getScene().getWindow()).close();
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
