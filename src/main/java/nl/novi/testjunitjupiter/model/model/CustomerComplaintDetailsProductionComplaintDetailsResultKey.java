package nl.novi.testjunitjupiter.model.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerComplaintDetailsProductionComplaintDetailsResultKey implements Serializable {

    @Column(name = "customer_complaint_details_id")
    private Long customerComplaintDetailsId;

    @Column(name = "production_complaint_details_id")
    private Long productionComplaintDetailsId;

        // constructor(s)
    public CustomerComplaintDetailsProductionComplaintDetailsResultKey() {}

    public CustomerComplaintDetailsProductionComplaintDetailsResultKey(long customerComplaintDetailsId, long productionComplaintDetailsId) {
            this.customerComplaintDetailsId = customerComplaintDetailsId;
            this.productionComplaintDetailsId = productionComplaintDetailsId;
        }

    // getters and setters

    public Long getCustomerComplaintDetailsId() {
        return customerComplaintDetailsId;
    }

    public void setCustomerComplaintDetailsId(Long customerComplaintDetailsId) {
        this.customerComplaintDetailsId = customerComplaintDetailsId;
    }

    public Long getProductionComplaintDetailsId() {
        return productionComplaintDetailsId;
    }

    public void setProductionComplaintDetailsId(Long productionComplaintDetailsId) {
        this.productionComplaintDetailsId = productionComplaintDetailsId;
    }

    // equals
        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomerComplaintDetailsProductionComplaintDetailsResultKey that = (CustomerComplaintDetailsProductionComplaintDetailsResultKey) o;
            return customerComplaintDetailsId.equals(that.customerComplaintDetailsId) &&
                    productionComplaintDetailsId.equals(that.productionComplaintDetailsId);
        }

        // hashcode
        @Override
        public int hashCode () {
            return Objects.hash(customerComplaintDetailsId, productionComplaintDetailsId);
        }
}



