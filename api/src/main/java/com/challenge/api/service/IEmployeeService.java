package com.challenge.api.service;

import com.challenge.api.dto.EmployeeRequest;
import com.challenge.api.dto.EmployeeResponse;
import java.util.List;
import java.util.UUID;

public interface IEmployeeService {

    List<EmployeeResponse> getAllEmployees(int page, int size);

    EmployeeResponse getEmployeeByUuid(UUID uuid);

    EmployeeResponse createEmployee(EmployeeRequest request);

    List<EmployeeResponse> searchEmployees(Integer minSalary, String jobTitle);
}
