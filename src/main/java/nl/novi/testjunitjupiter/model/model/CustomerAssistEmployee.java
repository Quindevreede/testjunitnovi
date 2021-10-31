package nl.novi.testjunitjupiter.model.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_assist_employees")
public class CustomerAssistEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "position")
    String position;

    @Column(name = "company_phone_number")
    String CompanyPhoneNumber;

    // standard constructors

    public CustomerAssistEmployee() {
    }

    // getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyPhoneNumber() {
        return CompanyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        CompanyPhoneNumber = companyPhoneNumber;
    }
}

