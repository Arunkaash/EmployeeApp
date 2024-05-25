package com.EmProjectApplication.Controller;

import com.EmProjectApplication.Entity.Employee;
import com.EmProjectApplication.Service.EmployeeService;
import com.EmProjectApplication.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
//    List<Employee> employees = new ArrayList<>();
//    EmployeeService employeeService = new EmployeeServiceImpl();
    @Autowired
    EmployeeService employeeService;
    @GetMapping("employee")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("employee/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.readById(id);
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee employee){
//        employees.add(employee);
        employeeService.createEmployee(employee);
        return "Save successfully...";
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Successfully Deleted...";
        }
        return "Not found !";
    }

    @PutMapping("employee/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

}
