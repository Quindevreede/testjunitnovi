package nl.novi.testjunitjupiter.repository.repository;

import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerComplaintDetailsRepository extends JpaRepository<CustomerComplaintDetails, Long> {
    Collection<CustomerComplaintDetails> findAllByLastName(String last_name);
}

