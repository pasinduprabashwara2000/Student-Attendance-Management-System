package edu.ijse.layered.fx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceDto {

    private int attendance_id;
    private LocalDate date;
    private String lecture_id;
    private String student_name;
    private String course_name;
    private String subject_name;
    private String status;

}
