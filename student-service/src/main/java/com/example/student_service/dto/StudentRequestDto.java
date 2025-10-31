package com.example.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Acts as a data transfer object layer for student
 * </p>
 *
 * @author Kavinila E
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private String studentName;
    private int marks;
    private String city;
    private String pincode;
    private String state;
}
