package nl.novi.testjunitjupiter.repository.repository;

        import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetailsProductionComplaintDetailsResult;
        import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetailsProductionComplaintDetailsResultKey;
        import org.springframework.data.jpa.repository.JpaRepository;
        import java.util.Collection;

public interface CustomerComplaintDetailsProductionComplaintDetailsResultRepository  extends JpaRepository<CustomerComplaintDetailsProductionComplaintDetailsResult, CustomerComplaintDetailsProductionComplaintDetailsResultKey> {
    Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> findAllByCustomerComplaintDetailsId(long CustomerComplaintDetailsId);
    Collection<CustomerComplaintDetailsProductionComplaintDetailsResult> findAllByProductionComplaintDetailsId(long ProductionComplaintDetailsId);
}

