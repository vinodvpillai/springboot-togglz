package com.vinod.togglz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRegisterDto implements Serializable {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
}
