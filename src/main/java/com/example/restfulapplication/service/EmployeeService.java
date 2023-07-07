package com.example.restfulapplication.service;

import com.example.restfulapplication.entity.Employee;
import com.example.restfulapplication.entity.EmployeeRequest;
import com.example.restfulapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getEmployees() {
        return null;
    }

    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        return repository.save(employee);
    }


    public Employee updateEmployee(EmployeeRequest request) {
        return null;
    }

    public void deleteEmployee() {
    }
}
