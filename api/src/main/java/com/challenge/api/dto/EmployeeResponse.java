package com.challenge.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Schema(description = "Employee response object")
@Data
@Builder
public class EmployeeResponse {

    @Schema(example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID uuid;

    @Schema(example = "John Doe")
    private String fullName;

    @Schema(example = "50000")
    private Integer salary;

    @Schema(example = "30")
    private Integer age;

    @Schema(example = "Software Engineer")
    private String jobTitle;

    @Schema(example = "john.doe@mail.com")
    private String email;

    private Instant contractHireDate;
    private Instant contractTerminationDate;
}
