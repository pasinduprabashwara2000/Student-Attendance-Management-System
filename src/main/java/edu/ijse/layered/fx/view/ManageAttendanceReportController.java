package edu.ijse.layered.fx.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageAttendanceReportController {

    @FXML
    private TableColumn<?, ?> colCourseName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colLectureId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private TableColumn<?, ?> colSubjectName;

    @FXML
    private Button filterBtn;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private Button reportBtn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label titleLabel;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    void genarateReport(ActionEvent event) {

    }

    @FXML
    void onFilter(ActionEvent event) {

    }

}

