package nl.novi.testjunitjupiter.service;

import nl.novi.testjunitjupiter.exceptions.RecordNotFoundException;
import nl.novi.testjunitjupiter.model.Course;
import nl.novi.testjunitjupiter.model.Student;
import nl.novi.testjunitjupiter.model.StudentCourseResult;
import nl.novi.testjunitjupiter.model.StudentCourseResultKey;
import nl.novi.testjunitjupiter.repository.CourseRepository;
import nl.novi.testjunitjupiter.repository.StudentCourseResultRepository;
import nl.novi.testjunitjupiter.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRespository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    @Override
    public Collection<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Collection<Course> getCourses(String name) {
        if (name.isEmpty()) {
            return courseRepository.findAll();
        }
        else {
            return courseRepository.findAllByName(name);
        }
    }

    @Override
    public Course getCourseById(long id) {
        if (!courseRepository.existsById(id)) { throw new RecordNotFoundException(); }
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public long createCourse(Course course) {
        Course storedCourse = courseRepository.save(course);
        return storedCourse.getId();
    }

    @Override
    public void updateCourse(long id, Course course) {
        // ToDo
    }

    @Override
    public void partialUpdateCourse(long id, Map<String, String> fields) {
        // ToDo
    }

    @Override
    public void deleteCourse(long id) {
        if (!courseRepository.existsById(id)) { throw new RecordNotFoundException(); }
        courseRepository.deleteById(id);
    }

}