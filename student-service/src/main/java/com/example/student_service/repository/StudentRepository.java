package com.example.student_service.repository;

import com.example.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "CALL get_student_by_id(:studentId)", nativeQuery = true)
    List<Object[]> getStudentDetailsById(@Param("studentId") Integer studentId);

    @Query(value = "SELECT get_pincode(:studentId)", nativeQuery = true)
    String getPincodeByStudentId(@Param("studentId") Integer studentId);
}
