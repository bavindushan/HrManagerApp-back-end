package edu.icet.service;

import edu.icet.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

    List<Employee> getAllEmployee();
}
