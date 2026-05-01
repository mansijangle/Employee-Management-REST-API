package com.challenge.api.controller;

import com.challenge.api.dto.EmployeeRequest;
import com.challenge.api.dto.EmployeeResponse;
import com.challenge.api.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Get all employees")
    @ApiResponse(
            responseCode = "200",
            description = "List of employees",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))
    @GetMapping
    public List<EmployeeResponse> getAll(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        return service.getAllEmployees(page, size);
    }

    @Operation(summary = "Get employee by UUID")
    @ApiResponse(
            responseCode = "200",
            description = "Employee found",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))
    @GetMapping("/{uuid}")
    public EmployeeResponse getById(@PathVariable UUID uuid) {
        return service.getEmployeeByUuid(uuid);
    }

    @Operation(summary = "Create employee")
    @ApiResponse(
            responseCode = "201",
            description = "Employee created",
            content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))
    @PostMapping
    public EmployeeResponse create(@Valid @RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }

    @Operation(summary = "Search employees by filters")
    @GetMapping("/search")
    public List<EmployeeResponse> search(
            @RequestParam(required = false) Integer minSalary, @RequestParam(required = false) String jobTitle) {

        return service.searchEmployees(minSalary, jobTitle);
    }
}
