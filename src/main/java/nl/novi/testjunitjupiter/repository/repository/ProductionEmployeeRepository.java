package nl.novi.testjunitjupiter.repository.repository;

import nl.novi.testjunitjupiter.model.model.ProductionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductionEmployeeRepository extends JpaRepository<ProductionEmployee, Long> {
    Collection<ProductionEmployee> findAllByLastName(String last_name);
}