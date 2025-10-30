package com.example.student_service.controller;

import com.example.student_service.dto.StudentRequestDto;
import com.example.student_service.entity.Student;
import com.example.student_service.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Handle different HTTP methods (GET, POST, PUT, DELETE, etc.)
 * </p>
 *
 * @author Kavinila E
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * <p>
     * creates the student record
     * </p>
     *
     * @param studentRequestDto  Represents the {@link StudentRequestDto}
     * @return {@link Student}
     */
    @PostMapping("/create")
    public Student createStudent(final @RequestBody StudentRequestDto studentRequestDto){
        return  studentService.createStudent(studentRequestDto);
    }

    /**
     * <p>
     * Gets all the student records related to entity
     * </p>
     *
     * @return the {@link java.util.Collection} of {@link Student}
     */
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * <p>
     * Updates the student by given id
     * </p>
     *
     * @param id                 Represents the id of the student
     * @param studentRequestDto  Represents the {@link StudentRequestDto}
     * @return updated {@link Student}
     */
    @PutMapping("/{id}")
    public Student updateStudent(final @PathVariable Integer id, final @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.updateStudent(id, studentRequestDto);
    }

    /**
     * <p>
     * Used to delete the student by the given id
     * </p>
     *
     * @param id   Represents the student id
     * @return {@link }
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(final @PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }
}
