package com.sda.Management.dto;


import com.sda.Management.models.User.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    private Long id;
    @NotEmpty(message = "Please enter valid first name")
    private String firstName;
    @NotEmpty(message = "Please enter valid last name")
    private String lastName;
    @NotEmpty(message = "Please enter username")
    private String username;
    @NotEmpty(message = "Please enter valid email")
    private String email;
    @NotEmpty(message = "Please enter valid password")
    private String password;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

}

