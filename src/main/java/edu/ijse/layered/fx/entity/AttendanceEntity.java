package edu.ijse.layered.fx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceEntity {

    private int attendance_id;
    private LocalDate date;
    private String lecture_id;
    private String student_name;
    private String course_name;
    private String subject_name;
    private String status;

}
