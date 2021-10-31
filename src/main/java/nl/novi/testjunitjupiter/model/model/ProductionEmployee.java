package nl.novi.testjunitjupiter.model.model;

import javax.persistence.*;

@Entity
@Table(name = "production_employees")
public class ProductionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "production_department")
    String productionDepartment;

    @Column(name = "company_phone_number")
    String CompanyPhoneNumber;


    // standard constructors


    public ProductionEmployee() {
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

    public String getProductionDepartment() {
        return productionDepartment;
    }

    public void setProductionDepartment(String productionDepartment) {
        this.productionDepartment = productionDepartment;
    }

    public String getCompanyPhoneNumber() {
        return CompanyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        CompanyPhoneNumber = companyPhoneNumber;
    }


}

