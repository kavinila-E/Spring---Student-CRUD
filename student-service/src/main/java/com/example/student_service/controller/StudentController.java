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
     * Handles the creation of a new student record.
     * </p>
     *
     * <p>
     * This method receives a {@link StudentRequestDto} object from the client request body,
     * which contains the student details such as name, address, and marks.
     * It then delegates the request to the {@link com.example.student_service.service.StudentService}
     * to perform the creation logic and persist the record into the database.
     * </p>
     *
     * @param studentRequestDto the {@link StudentRequestDto} containing the student details to be created
     * @return the newly created {@link Student} entity with a generated student ID
     */
    @PostMapping("/create")
    public Student createStudent(final @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.createStudent(studentRequestDto);
    }

    /**
     * <p>
     * Retrieves all student records from the database.
     * </p>
     *
     * <p>
     * This endpoint fetches all the student entities available in the system.
     * It delegates the request to the {@link com.example.student_service.service.StudentService}
     * to retrieve the data and returns a list of {@link Student} objects.
     * </p>
     *
     * @return a list of all {@link Student} entities present in the system
     */
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * <p>
     * Updates an existing student record based on the provided student ID.
     * </p>
     *
     * <p>
     * This method accepts a student ID as a path variable and a {@link StudentRequestDto}
     * object containing the updated student details. It delegates the update operation
     * to the {@link com.example.student_service.service.StudentService}.
     * </p>
     *
     * @param id                the unique identifier of the student to be updated
     * @param studentRequestDto the {@link StudentRequestDto} containing updated details
     * @return the updated {@link Student} entity after persistence
     */
    @PutMapping("/{id}")
    public Student updateStudent(final @PathVariable Integer id, final @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.updateStudent(id, studentRequestDto);
    }

    /**
     * <p>
     * Gets the {@link Student} matches for the given id
     * </p>
     *
     * @param id Represents the id of the student
     * @return the {@link Student}
     */
    @GetMapping("/{id}")
    public Student getStudentById(final Integer id) {
        return studentService.getStudent(id);
    }

    /**
     * <p>
     * Gets the {@link StudentRequestDto} matches for the given id
     * </p>
     *
     * @param id Represents the student id
     * @return {@link StudentRequestDto}
     */
    @GetMapping("/procedure/{id}")
    public StudentRequestDto getStudentByStoredProcedure(@PathVariable Integer id) {
        return studentService.getStudentByStoredProcedure(id);
    }

    /**
     * <p>
     * Deletes a student record by its unique ID.
     * </p>
     *
     * <p>
     * This endpoint removes the student record corresponding to the given ID.
     * It delegates the delete operation to the {@link com.example.student_service.service.StudentService}.
     * If the student does not exist, an error response is returned.
     * </p>
     *
     * @param id the unique identifier of the student to be deleted
     * @return a success message defined in {@link com.example.student_service.constants.StudentConstants}
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(final @PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("function/{id}")
    public String getPincode(final @PathVariable Integer id) {
        return studentService.getPincode(id);
    }
}
