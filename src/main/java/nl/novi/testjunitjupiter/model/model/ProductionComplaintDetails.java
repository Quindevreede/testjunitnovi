package nl.novi.testjunitjupiter.model.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "production_complaint_details")
public class ProductionComplaintDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String orderNrCustomer;

    @Column
    String code;

    @Column
    String name;

    @Column
    String productionCommentary;


    @OneToMany(mappedBy = "production_complaint_details",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
//    @JsonIgnore
    @JsonIgnoreProperties("production_complaint_details")
//    @JsonBackReference
//    @JsonManagedReference
    Set<CustomerComplaintDetailsProductionComplaintDetailsResult> results;


    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNrCustomer() {
        return orderNrCustomer;
    }

    public void setOrderNrCustomer(String orderNrCustomer) {
        this.orderNrCustomer = orderNrCustomer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionCommentary() {
        return productionCommentary;
    }

    public void setProductionCommentary(String productionCommentary) {
        this.productionCommentary = productionCommentary;
    }


    public Set<CustomerComplaintDetailsProductionComplaintDetailsResult> getResults() {
        return results;
    }
    public void setResults(Set<CustomerComplaintDetailsProductionComplaintDetailsResult> results) {
        this.results = results;
    }

}

