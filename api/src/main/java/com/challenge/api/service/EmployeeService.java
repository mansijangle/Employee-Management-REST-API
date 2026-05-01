package com.challenge.api.service;

import com.challenge.api.dto.EmployeeRequest;
import com.challenge.api.dto.EmployeeResponse;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.time.Instant;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService implements IEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final List<Employee> store = new ArrayList<>();

    public EmployeeService() {
        createInternal("Ramesh", "Kumar", 50000, 28, "Engineer", "ramesh@mail.com");
        createInternal("Priya", "Sharma", 60000, 25, "Manager", "priya@mail.com");
    }

    private void createInternal(String f, String l, int s, int a, String j, String e) {
        EmployeeImpl emp = new EmployeeImpl();
        emp.setUuid(UUID.randomUUID());
        emp.setFirstName(f);
        emp.setLastName(l);
        emp.setFullName(f + " " + l);
        emp.setSalary(s);
        emp.setAge(a);
        emp.setJobTitle(j);
        emp.setEmail(e);
        emp.setContractHireDate(Instant.now());
        store.add(emp);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees(int page, int size) {
        log.info("Fetching employees page={} size={}", page, size);

        int start = page * size;
        int end = Math.min(start + size, store.size());

        if (start > store.size()) return List.of();

        return store.subList(start, end).stream().map(this::map).toList();
    }

    @Override
    public EmployeeResponse getEmployeeByUuid(UUID uuid) {
        log.info("Fetching employee {}", uuid);

        Employee e = store.stream()
                .filter(emp -> emp.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        return map(e);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest r) {
        log.info("Creating employee {}", r.getEmail());

        EmployeeImpl e = new EmployeeImpl();
        e.setUuid(UUID.randomUUID());
        e.setFirstName(r.getFirstName());
        e.setLastName(r.getLastName());
        e.setFullName(r.getFirstName() + " " + r.getLastName());
        e.setSalary(r.getSalary());
        e.setAge(r.getAge());
        e.setJobTitle(r.getJobTitle());
        e.setEmail(r.getEmail());
        e.setContractHireDate(Instant.now());

        store.add(e);

        return map(e);
    }

    @Override
    public List<EmployeeResponse> searchEmployees(Integer minSalary, String jobTitle) {
        return store.stream()
                .filter(e -> minSalary == null || e.getSalary() >= minSalary)
                .filter(e -> jobTitle == null || e.getJobTitle().equalsIgnoreCase(jobTitle))
                .map(this::map)
                .toList();
    }

    private EmployeeResponse map(Employee e) {
        return EmployeeResponse.builder()
                .uuid(e.getUuid())
                .fullName(e.getFullName())
                .salary(e.getSalary())
                .age(e.getAge())
                .jobTitle(e.getJobTitle())
                .email(e.getEmail())
                .contractHireDate(e.getContractHireDate())
                .contractTerminationDate(e.getContractTerminationDate())
                .build();
    }
}
