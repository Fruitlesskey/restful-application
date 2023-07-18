package com.example.restfulapplication.controller;

import com.example.restfulapplication.entity.Employee;
import com.example.restfulapplication.entity.EmployeeRequest;
import com.example.restfulapplication.exception.EmployeeException;
import com.example.restfulapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();

    }

    @PostMapping("/employees")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Employee createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.updateEmployee(request);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee();
    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasAuthority('USER_READ')")
    public Employee getById(@PathVariable("id") Long id) throws EmployeeException {
        return employeeService.getEmployeeById(id);
    }

}
