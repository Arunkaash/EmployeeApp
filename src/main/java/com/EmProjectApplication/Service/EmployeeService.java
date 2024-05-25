package com.EmProjectApplication.Service;

import com.EmProjectApplication.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();

    Employee readById(Long id);
    boolean deleteEmployee(Long id);

    String updateEmployee(Long id, Employee employee);





}
