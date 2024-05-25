package com.EmProjectApplication.repository;

import com.EmProjectApplication.Entity.Employee;
import com.EmProjectApplication.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> { //interface that extends JpaRepository. This interface will provide CRUD operations (using to save data in the table)
//JpaRepository is a special type of library that helps us store and manage data in a database.

}
