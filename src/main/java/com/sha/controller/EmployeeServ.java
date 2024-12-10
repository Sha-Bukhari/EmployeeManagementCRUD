package com.sha.controller;

import com.sha.bo.EmployeeboImpl;
import com.sha.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeServlet")
public class EmployeeServ extends HttpServlet {
    private EmployeeboImpl empService = new EmployeeboImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dept = request.getParameter("dept");
        String salaryParam = request.getParameter("salary");
        int salary = (salaryParam != null && !salaryParam.isEmpty()) ? Integer.parseInt(salaryParam) : 0;

        String resultMessage = "";

        switch (operation) {
            case "insert":
                Employee newEmployee = new Employee(id, name, email, dept, salary);
                int insertResult = empService.insert(newEmployee);
                resultMessage = (insertResult > 0) ? "Employee inserted successfully!" : "Failed to insert employee.";
                break;

            case "update":
                Employee updatedEmployee = new Employee(id, name, email, dept, salary);
                int updateResult = empService.update(updatedEmployee);
                resultMessage = (updateResult > 0) ? "Employee updated successfully!" : "Failed to update employee.";
                break;

            case "delete":
                int deleteResult = empService.delete(id);
                resultMessage = (deleteResult > 0) ? "Employee deleted successfully!" : "Failed to delete employee.";
                break;

            case "get":
                Employee retrievedEmployee = empService.get(id);
                resultMessage = (retrievedEmployee != null) ? retrievedEmployee.toString() : "Employee not found.";
                break;

            default:
                resultMessage = "Invalid operation.";
                break;
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>" + resultMessage + "</h1>");
        response.getWriter().println("<a href='employee_form.html'>Go Back</a>");
    }
}
