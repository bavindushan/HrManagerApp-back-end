package edu.icet.dto;

import edu.icet.utill.DepartmentType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private DepartmentType department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
