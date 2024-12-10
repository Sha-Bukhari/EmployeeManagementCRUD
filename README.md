
# Employee Management CRUD Application

A **Java-based Employee Management System** built using **Servlets**, **JDBC**, and **MySQL**. 
This project performs **CRUD (Create, Read, Update, Delete)** operations to manage employee records effectively. 
It also features a user-friendly **HTML interface** for interaction.

---

## Features

- **Insert Employees**: Add new employee records to the database.
- **View Employees**: Retrieve details of a single employee or all employees.
- **Update Employees**: Modify existing employee information.
- **Delete Employees**: Remove employee records based on their unique ID.
- **HTML Interface**: Intuitive form for performing all CRUD operations.

---

## Technologies Used

- **Java**: Core programming language for backend development.
- **Servlets**: To handle HTTP requests and responses.
- **JDBC**: For database connectivity and operations.
- **MySQL**: Relational database to store employee data.
- **HTML**: Frontend for the user interface.
- **Apache Tomcat**: Server to deploy and run the application.

---

## Project Structure

```plaintext
EmployeeManagementCRUD/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sha/
│   │   │           ├── bo/
│   │   │           │   ├── Employeeebo.java
│   │   │           │   └── EmployeeeboImpl.java
│   │   │           ├── controller/
│   │   │           │   └── EmployeeServ.java
│   │   │           ├── model/
│   │   │               └── Employee.java
│   │   ├── webapp/
│   │       ├── META-INF/
│   │       ├── WEB-INF/
│   │       │   ├── lib/
│   │       │   │   └── mysql-connector-j-8.0.33.jar
│   │       │   └── web.xml
│   │       ├── index.html
├── build/
├── README.md
└── pom.xml (if using Maven)
```

---

## Prerequisites

- **MySQL Database** installed and running.
- **Apache Tomcat** installed and configured.
- **Java JDK 8 or above** installed.
- **MySQL Connector JAR** placed in `WEB-INF/lib`.

---

## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Sha-Bukhari/EmployeeManagementCRUD.git
   ```
2. **Set Up the Database**:
   - Create a database and table using the following SQL script:
     ```sql
     CREATE TABLE Employee (
         id INT PRIMARY KEY,
         name VARCHAR(100),
         email VARCHAR(100),
         dept VARCHAR(50),
         salary INT
     );
     ```
3. **Update Database Configuration**:
   - Edit the database connection details in `EmployeeboImpl.java`:
     ```java
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your-database", "username", "password");
     ```
4. **Deploy the Project**:
   - Import the project into an IDE (e.g., Eclipse or IntelliJ IDEA).
   - Build and deploy the project to Apache Tomcat.
5. **Access the Application**:
   - Open your browser and navigate to:
     ```bash
     http://localhost:8080/EmployeeManagementCRUD/index.html
     ```
6. **Perform CRUD Operations**:
   - Use the web form to insert, update, delete, or retrieve employee data.

---

## Project Workflow

1. **Frontend**:
   - The `index.html` file provides a simple form for entering employee details and selecting CRUD operations.
2. **Backend**:
   - **Controller**: The `EmployeeServ.java` servlet processes HTTP requests.
   - **Business Logic**: `EmployeeboImpl.java` contains methods to interact with the database using JDBC.
   - **Model**: `Employee.java` represents the employee entity.
3. **Database**:
   - All employee records are stored in a MySQL database.

---

## Why This Project?

This project demonstrates:
- The integration of **Java Servlets** with **JDBC** for database-driven applications.
- Practical application of **Object-Oriented Programming (OOP)** principles.
- Real-world use case of CRUD functionality in backend development.

---

## License

This project is licensed under the **MIT License**. Feel free to use, modify, and share it.

---

## Author

- **[Sha-Bukhari](https://github.com/Sha-Bukhari)**  
  Java Developer | Backend Enthusiast | Open Source Contributor  

For any questions or suggestions, feel free to [contact me](mailto:shabukharimd1@gmail.com).
