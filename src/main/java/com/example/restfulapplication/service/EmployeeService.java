package com.example.restfulapplication.service;

import com.example.restfulapplication.entity.Employee;
import com.example.restfulapplication.entity.EmployeeRequest;
import com.example.restfulapplication.exception.EmployeeException;
import com.example.restfulapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Employee getEmployeeById(Long id) throws EmployeeException {
        Employee employee;
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            throw new EmployeeException("Employee with id: " + id + " was not found");
        }
        return employee;
    }
}
