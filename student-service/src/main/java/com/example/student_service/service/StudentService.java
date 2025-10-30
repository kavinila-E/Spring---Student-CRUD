package com.example.student_service.service;

import com.example.student_service.constants.StudentConstants;
import com.example.student_service.dto.StudentRequestDto;
import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * <p>
 * Performs the services for student entity
 * </p>
 *
 * @author Kavinila E
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    /**
     * Used to  create the student
     *
     * @param studentRequestDto Represents the {@link StudentRequestDto}
     * @return the {@link Student} entity
     */
    public Student createStudent(final StudentRequestDto studentRequestDto) {
        final Student student = new Student();

        student.setStudentName(studentRequestDto.getStudentName());
        student.setMark(studentRequestDto.getMarks());
        student.setAddress(studentRequestDto.getAddress());

        logger.info(StudentConstants.STUDENT_CREATED);

        return studentRepository.save(student);
    }

    /**
     * <p>
     * Used to get all the student
     * </p>
     *
     * @return {@link java.util.Collection} of {@link Student}
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    /**
     * <p>
     * Used to  update the student
     * </p>
     *
     * @param id                Represents the student id
     * @param studentRequestDto Represents the {@link StudentRequestDto}
     * @return the {@link Student} entity
     */

    public Student updateStudent(final Integer id, final StudentRequestDto studentRequestDto) {
        final Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            final Student student = optionalStudent.get();

            student.setStudentName(studentRequestDto.getStudentName());
            student.setMark(studentRequestDto.getMarks());
            student.setAddress(studentRequestDto.getAddress());

            logger.info(StudentConstants.STUDENT_UPDATED);

            return studentRepository.save(student);
        } else {
            throw new RuntimeException(StudentConstants.STUDENT_NOT_FOUND + id);
        }
    }

    /**
     * Used to delete the student by id
     *
     * @param id Represents the {@link Student} id
     */
    public String deleteStudent(final Integer id) {
        studentRepository.delete(studentRepository.findById(id).orElseThrow(() -> new RuntimeException(StudentConstants.STUDENT_NOT_FOUND + id)));

        return StudentConstants.STUDENT_DELETED;
    }
}
