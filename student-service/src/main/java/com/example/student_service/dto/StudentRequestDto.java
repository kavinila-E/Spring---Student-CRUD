package com.example.student_service.dto;

import lombok.Data;

/**
 * <p>
 * Acts as a data transfer object layer for student
 * </p>
 *
 * @author Kavinila E
 */
@Data
public class StudentRequestDto {
    private String studentName;
    private String address;
    private int marks;
}
