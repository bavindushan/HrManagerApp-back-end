package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        try {
            service.addEmployee(employee);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Employee added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        try {
            service.updateEmployee(employee);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Employee updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){

        try {
            service.deleteEmployeeById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Employee deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
