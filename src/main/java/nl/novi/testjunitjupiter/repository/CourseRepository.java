package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Collection<Course> findAllByName(String name);
}