package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.Speler;
import nl.novi.testjunitjupiter.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface SpelerRepository extends CrudRepository<Speler, Long> {
}
