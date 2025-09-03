package edu.ijse.layered.fx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    private int id;
    private String username;
    private String password;
    private String role;

}
