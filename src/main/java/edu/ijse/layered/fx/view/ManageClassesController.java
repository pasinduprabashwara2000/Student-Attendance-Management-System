package edu.ijse.layered.fx.view;

import edu.ijse.layered.fx.controller.ClassController;
import edu.ijse.layered.fx.dto.ClassDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ManageClassesController {

    private final ClassController classController = new ClassController();

    @FXML
    private TableColumn<ClassDto, String> classId;

    @FXML
    private TableColumn<ClassDto, String> courseId;

    @FXML
    private TextField courseTxt;

    @FXML
    private TableColumn<ClassDto, LocalDate> date;

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<ClassDto> detailsTabel;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTxt;

    @FXML
    private Label lecLabel;

    @FXML
    private TableColumn<ClassDto, String> lectureId;

    @FXML
    private TextField lectureTxt;

    @FXML
    private Label nameLabel;

    @FXML
    private Button resetBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Label subLabel;

    @FXML
    private TableColumn<ClassDto, String> subjectId;

    @FXML
    private TextField subjectTxt;

    @FXML
    private Button updateBtn;

    @FXML
    private void initialize() {

        classId.setCellValueFactory(new PropertyValueFactory<>("classId"));
        subjectId.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        lectureId.setCellValueFactory(new PropertyValueFactory<>("lectureId"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadTable();
    }

    @FXML
    private void loadTable() {
        try {
            detailsTabel.getItems().clear();
            detailsTabel.getItems().addAll(classController.getAllClasses());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        idTxt.clear();
        courseTxt.clear();
        subjectTxt.clear();
        lectureTxt.clear();
        dateTxt.setValue(null);
        detailsTabel.getSelectionModel().clearSelection();
    }

    @FXML
    void saveClasses(ActionEvent event) {
        try {
            ClassDto classesDto = new ClassDto(
                    idTxt.getText(),
                    courseTxt.getText(),
                    subjectTxt.getText(),
                    lectureTxt.getText(),
                    dateTxt.getValue()
            );

            String rsp = classController.addClasses(classesDto);
            clear(event);
            loadTable();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(rsp);
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void updateClasses(ActionEvent event) {
        try {
            ClassDto classesDto = new ClassDto(
                    idTxt.getText(),
                    courseTxt.getText(),
                    subjectTxt.getText(),
                    lectureTxt.getText(),
                    dateTxt.getValue()
            );

            String rsp = classController.updateClasses(classesDto);
            clear(event);
            loadTable();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(rsp);
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void deleteClasses(ActionEvent event) {
        try {
            String rsp = classController.deleteClasses(idTxt.getText());
            clear(event);
            loadTable();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(rsp);
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
