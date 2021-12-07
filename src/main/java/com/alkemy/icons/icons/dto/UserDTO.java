package com.alkemy.icons.icons.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO {
    @Email
    private String email;
    @Size(min = 8)
    private String password;

}
