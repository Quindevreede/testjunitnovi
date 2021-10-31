package nl.novi.testjunitjupiter.model.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_complaint_details")
public class CustomerComplaintDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //Corresponds to user id : username
    @Column
    String username;

    @Column
    String orderNumberCustomer;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String email;

    @Column
    String customerCommentary;


   @OneToMany(mappedBy = "customer_complaint_details",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer_complaint_details")
    @JsonBackReference
    Set<CustomerComplaintDetailsProductionComplaintDetailsResult> results;

    // standard constructors

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderNumberCustomer() {
        return orderNumberCustomer;
    }

    public void setOrderNumberCustomer(String orderNumberCustomer) {
        this.orderNumberCustomer = orderNumberCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerCommentary() {
        return customerCommentary;
    }

    public void setCustomerCommentary(String customerCommentary) {
        this.customerCommentary = customerCommentary;
    }

    public Set<CustomerComplaintDetailsProductionComplaintDetailsResult> getResults() {
        return results;
    }
    public void setResults(Set<CustomerComplaintDetailsProductionComplaintDetailsResult> results) {
        this.results = results;
    }

}

