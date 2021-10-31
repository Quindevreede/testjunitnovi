package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByLastName(String last_name);

//    @Query("SELECT * FROM student s WHERE s.name LIKE %:name%")
//    List<Student> searchByNameLike(@Param("name") String name);
}