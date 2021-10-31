package nl.novi.testjunitjupiter.model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customer_complaint_details_production_complaint_details_results")
public class CustomerComplaintDetailsProductionComplaintDetailsResult {

    @EmbeddedId
    @JsonIgnore
    private CustomerComplaintDetailsProductionComplaintDetailsResultKey id;

    @ManyToOne
    @MapsId("customerComplaintDetailsId")
    @JoinColumn(name = "customer_complaint_details_id")
    @JsonIgnoreProperties("results")
    private CustomerComplaintDetails customerComplaintDetails;

    @ManyToOne
    @MapsId("productionComplaintDetailsId")
    @JoinColumn(name = "production_complaint_details_id")
    @JsonIgnoreProperties("results")
    private ProductionComplaintDetails productionComplaintDetails;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal extra_costs;

    @ManyToOne
    @JoinColumn(name = "customer_complaint_details_id")
    private CustomerComplaintDetails customer_complaint_details;

    @ManyToOne
    @JoinColumn(name = "production_complaint_details_id")
    private ProductionComplaintDetails production_Complaint_Details;

    @ManyToOne
    @JoinColumn(name = "production_complaint_details_id")
    private ProductionComplaintDetails production_complaint_details;

    public ProductionComplaintDetails getProduction_complaint_details() {
        return production_complaint_details;
    }

    public void setProduction_complaint_details(ProductionComplaintDetails production_complaint_details) {
        this.production_complaint_details = production_complaint_details;
    }

    public CustomerComplaintDetails getCustomer_complaint_details() {
        return customer_complaint_details;
    }
    public void setCustomer_complaint_details(CustomerComplaintDetails customer_complaint_details) {
        this.customer_complaint_details = customer_complaint_details;
    }
    // getters and setters
    public CustomerComplaintDetailsProductionComplaintDetailsResultKey getId() {
        return id;
    }
    public void setId(CustomerComplaintDetailsProductionComplaintDetailsResultKey id) {
        this.id = id;
    }
    public CustomerComplaintDetails getCustomerComplaintDetails() {
        return customerComplaintDetails;
    }
    public void setCustomerComplaintDetails(CustomerComplaintDetails customerComplaintDetails) {
        this.customerComplaintDetails = customerComplaintDetails;
    }
    public ProductionComplaintDetails getProductionComplaintDetails() {
        return productionComplaintDetails;
    }
    public void setProductionComplaintDetails(ProductionComplaintDetails productionComplaintDetails) {
        this.productionComplaintDetails = productionComplaintDetails;
    }
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {
        this.date = date.now();
    }
    public BigDecimal getExtra_costs() {
        return extra_costs;
    }
    public void setExtra_costs(BigDecimal extra_costs) {
        this.extra_costs = extra_costs;
    }
}

