package nl.novi.testjunitjupiter.service;

import nl.novi.testjunitjupiter.model.Student;
import nl.novi.testjunitjupiter.model.StudentCourseResult;

import java.util.Collection;
import java.util.Map;

public interface StudentService {

    Collection<Student> getAllStudents();
    Student getStudentById(long id);
    Collection<Student> getStudents(String name);
    long createStudent(Student student);
    void updateStudent(long id, Student student);
    void partialUpdateStudent(long id, Map<String, String> fields);
    void deleteStudent(long id);

}