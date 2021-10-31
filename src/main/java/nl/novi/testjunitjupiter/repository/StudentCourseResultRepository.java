package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.StudentCourseResult;
import nl.novi.testjunitjupiter.model.StudentCourseResultKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentCourseResultRepository extends JpaRepository<StudentCourseResult, StudentCourseResultKey> {
    Collection<StudentCourseResult> findAllByStudentId(long studentId);
    Collection<StudentCourseResult> findAllByCourseId(long courseId);
}