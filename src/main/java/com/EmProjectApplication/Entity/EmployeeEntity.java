package com.EmProjectApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity //use if you are save these field on database
@Table(name="Employee_DB")
public class EmployeeEntity { //using entity class to create table in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

}
