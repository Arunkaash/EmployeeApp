package com.EmProjectApplication.Service;

import com.EmProjectApplication.Entity.Employee;
import com.EmProjectApplication.Entity.EmployeeEntity;
import com.EmProjectApplication.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity(); //created object to pass data in the entity
        BeanUtils.copyProperties(employee,employeeEntity); //take data from employee copy into employeeEntity
        employeeRepository.save(employeeEntity);
//        employees.add(employee); //saving data locally
        return "Saved Successfully...";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList= employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity: employeeList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee readById(Long id) {
        EmployeeEntity employeeEntity1 = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity1, employee);
        return employee;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity extistingEmployee = employeeRepository.findById(id).get();
        extistingEmployee.setName(employee.getName());
        extistingEmployee.setPhone(employee.getPhone());
        extistingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(extistingEmployee);
        return "Successfully updated...";
    }
}
