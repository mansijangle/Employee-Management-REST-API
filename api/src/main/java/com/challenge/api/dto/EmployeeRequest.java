package com.challenge.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotNull private String firstName;

    @NotNull private String lastName;

    @Min(1)
    @NotNull private Integer salary;

    @Min(18)
    @NotNull private Integer age;

    @NotNull private String jobTitle;

    @Email
    @NotNull private String email;
}
