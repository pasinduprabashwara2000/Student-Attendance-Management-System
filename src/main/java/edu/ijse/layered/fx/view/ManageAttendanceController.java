package edu.ijse.layered.fx.view;

import edu.ijse.layered.fx.controller.AttendanceController;
import edu.ijse.layered.fx.dto.AttendanceDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.Objects;

public class ManageAttendanceController {

    final private AttendanceController attendanceController = new AttendanceController();

    @FXML
    private TableColumn<AttendanceDto, Integer> colId;

    @FXML
    private TableColumn<AttendanceDto, String> colCourseName;

    @FXML
    private TableColumn<AttendanceDto, java.time.LocalDate> colDate;

    @FXML
    private TableColumn<AttendanceDto, String> colLectureId;

    @FXML
    private TableColumn<AttendanceDto, Objects> colStatus;

    @FXML
    private TableColumn<AttendanceDto, String> colStudentName;

    @FXML
    private TableColumn<AttendanceDto, String> colSubjectName;

    @FXML
    private TextField courseTxt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<AttendanceDto> detailsTable;

    @FXML
    private TextField lectureTxt;

    @FXML
    private Button resetBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private ComboBox<String> statusPicker;

    @FXML
    private TextField studentTxt;

    @FXML
    private TextField subjectTxt;

    @FXML
    private Button updateBtn;

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("attendance_id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colLectureId.setCellValueFactory(new PropertyValueFactory<>("lecture_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        colSubjectName.setCellValueFactory(new PropertyValueFactory<>("subject_name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadTable();
    }

    @FXML
    public void loadTable(){
        try {
            detailsTable.getItems().clear();
            detailsTable.getItems().addAll(attendanceController.getAllAttendance());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    void Clear(ActionEvent event) {
        lectureTxt.clear();
        studentTxt.clear();
        courseTxt.clear();
        subjectTxt.clear();
        datePicker.setValue(null);
        statusPicker.setValue(null);
    }

    @FXML
    void navigateDelete(ActionEvent event) {
        try {
            if (datePicker.getValue() == null) {
                throw new IllegalArgumentException("Please select a date to delete.");
            }

            String rsp = attendanceController.deleteAttendance(datePicker.getValue().toString());
            Clear(event);
            loadTable();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(rsp);
            alert.showAndWait();

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void navigateSave(ActionEvent event) {
        try {
            AttendanceDto attendanceDto = new AttendanceDto(
                    0,
                    datePicker.getValue(),
                    lectureTxt.getText(),
                    studentTxt.getText(),
                    courseTxt.getText(),
                    subjectTxt.getText(),
                    statusPicker.getValue()
            );

            String rsp = attendanceController.saveAttendance(attendanceDto);
            Clear(event);
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
    void navigateUpdate(ActionEvent event) {
        try {
            AttendanceDto attendanceDto = new AttendanceDto(
                    0,
                    datePicker.getValue(),
                    lectureTxt.getText(),
                    studentTxt.getText(),
                    courseTxt.getText(),
                    subjectTxt.getText(),
                    statusPicker.getValue()
            );

            String rsp = attendanceController.updateAttendance(attendanceDto);
            Clear(event);
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
