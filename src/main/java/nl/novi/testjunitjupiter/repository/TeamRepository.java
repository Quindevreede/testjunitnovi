package nl.novi.testjunitjupiter.repository;

import nl.novi.testjunitjupiter.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
