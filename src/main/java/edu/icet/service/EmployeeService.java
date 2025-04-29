package edu.icet.service;

import edu.icet.dto.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);
}
