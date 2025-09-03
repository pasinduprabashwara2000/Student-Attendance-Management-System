package edu.ijse.layered.fx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

    private int regNum;
    private String name;
    private String contactDetails;

}
