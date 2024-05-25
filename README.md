#EmployeeApp
This project is a Spring Boot application that demonstrates basic CRUD (Create, Read, Update, Delete) operations for managing employee information. It utilizes a RESTful API for communication, Spring Data JPA for database interaction, Lombok for boilerplate code reduction, and an H2 in-memory database for storage. You can access the application at http://localhost:8080/employee

Technologies Used
Spring Boot: Simplifies the development of production-ready Spring applications.
Spring Data JPA: Facilitates easy and powerful database interactions using the Java Persistence API.
Lombok: Reduces boilerplate code with annotations.
H2 Database: Provides an in-memory database for quick setup and testing.
REST API: Exposes endpoints for CRUD operations on employee data.
Key Features
Create Employee: Add a new employee to the database.
Read Employees: Retrieve all employees or a single employee by ID.
Update Employee: Modify the details of an existing employee.
Delete Employee: Remove an employee from the database.
Project Structure
Entity Layer: Contains the EmployeeEntity class, representing the employee data model.

java
Copy code
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
}
Repository Layer: Defines the EmployeeRepository interface extending JpaRepository for database operations.

java
Copy code
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
Service Layer: Contains the business logic in the EmployeeService class.

java
Copy code
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDto, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully...";
    }

    // Other CRUD methods...
}
Controller Layer: Exposes RESTful endpoints via the EmployeeController class.

java
Copy code
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeService.getAllEmployees();
        return employeeList.stream().map(employeeEntity -> {
            Employee emp = new Employee();
            BeanUtils.copyProperties(employeeEntity, emp);
            return emp;
        }).collect(Collectors.toList());
    }

    // Other CRUD endpoints...
}
H2 Database Configuration
properties
Copy code
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
Running the Project
Clone the repository.
Run the Spring Boot application.
Access the H2 console at http://localhost:8080/h2-console with configured credentials.
Use tools like Postman or curl to interact with the REST API at http://localhost:8080/employee
This project serves as a practical example of building a full-featured CRUD application using modern Spring Boot practices.
