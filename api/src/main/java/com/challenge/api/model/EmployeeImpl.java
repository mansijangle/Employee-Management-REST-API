package com.challenge.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

/**
 * Concrete implementation of the {@link Employee} domain model.
 * Serves as the primary data transfer object across all layers.
 * Lombok @Data auto-generates getters, setters, equals, hashCode.
 */
@Data
public class EmployeeImpl implements Employee {

    private UUID uuid;

    @NotNull(message = "First name is required") private String firstName;

    @NotNull(message = "Last name is required") private String lastName;

    private String fullName;

    @NotNull(message = "Salary is required") private Integer salary;

    @NotNull(message = "Age is required") private Integer age;

    @NotNull(message = "Job title is required") private String jobTitle;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email is required") private String email;

    private Instant contractHireDate;

    // Nullable — null means employee is still active
    private Instant contractTerminationDate;
}
