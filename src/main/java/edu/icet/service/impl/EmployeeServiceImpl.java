package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;
    final ModelMapper mapper;

    @Override
    public void addEmployee(Employee employee) {
        // Name Validation
        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (!employee.getName().matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Name must contain only alphabets and spaces");
        }
        if (employee.getName().length() > 100) {
            throw new IllegalArgumentException("Name cannot exceed 100 characters");
        }

        // Email Validation
        if (employee.getEmail() == null || employee.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (!employee.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Department Validation
        if (employee.getDepartment() == null) {
            throw new IllegalArgumentException("Department must be provided");
        }

        // Check Email is unique one or not
        if (repository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        repository.save(mapper.map(employee, EmployeeEntity.class));
    }
}
