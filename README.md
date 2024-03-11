# Employee Management System - Backend

This is the backend component of the Employee Management System. It provides RESTful APIs for managing employee-related operations such as creating, updating, deleting, and retrieving employee information.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL Server (or any other relational database supported by Spring Boot)

## Setup

1. **Clone the repository:**

    ```
    git clone https://github.com/yourusername/employee-management-backend.git
    cd employee-management-backend
    ```

2. **Configure Database:**

    - Create a MySQL database named `employee_management`.
    - Update the `application.properties` file located in `src/main/resources` with your database connection details:

    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Build and Run:**

    ```
    mvn spring-boot:run
    ```

4. **Accessing the Application:**

    Once the application is up and running, you can access the RESTful APIs using the following base URL:

    ```
    http://localhost:8080/api/employees
    ```

## API Endpoints

- **GET /employees**: Get a list of all employees.
- **GET /employees/{id}**: Get details of a specific employee by ID.
- **POST /employees**: Create a new employee.
- **PUT /employees/{id}**: Update an existing employee.
- **DELETE /employees/{id}**: Delete an employee by ID.

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Maven
  
## Architecture

![Screenshot (228)](https://github.com/Gobinath-B/Spring-Employee-Management/assets/81898167/eb7e5a2f-2f84-4b84-af67-bb2e0c6b9068)


## Contributing

Contributions are welcome! If you have any suggestions, feature requests, or bug reports, please create an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
