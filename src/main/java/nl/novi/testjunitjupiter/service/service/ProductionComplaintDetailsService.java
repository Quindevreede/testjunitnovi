package nl.novi.testjunitjupiter.service.service;

import nl.novi.testjunitjupiter.exceptions.RecordNotFoundException;
import nl.novi.testjunitjupiter.exceptions.UserNotFoundException;
import nl.novi.testjunitjupiter.model.model.ProductionComplaintDetails;
import nl.novi.testjunitjupiter.repository.repository.CustomerComplaintDetailsRepository;
import nl.novi.testjunitjupiter.repository.repository.ProductionComplaintDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class ProductionComplaintDetailsService {

    @Autowired
    ProductionComplaintDetailsRepository productionComplaintDetailsRepository;

    @Autowired
    CustomerComplaintDetailsRepository customerComplaintDetailsRepository;

//    @Autowired
  //  CustomerComplaintDetailsProductionComplaintDetailsResultRepository customerComplaintDetailsProductionComplaintDetailsResultRepository;

    public Collection<ProductionComplaintDetails> getAllComplaintDetails() {
        return productionComplaintDetailsRepository.findAll();
    }

    public Collection<ProductionComplaintDetails> getComplaintDetails(String name) {
        if (name.isEmpty()) {
            return productionComplaintDetailsRepository.findAll();
        }
        else {
            return productionComplaintDetailsRepository.findAllByName(name);
        }
    }

    public ProductionComplaintDetails getComplaintDetailsById(long id) {
        if (!productionComplaintDetailsRepository.existsById(id)) { throw new RecordNotFoundException(); }
        return productionComplaintDetailsRepository.findById(id).orElse(null);
    }

    public long createComplaintDetails(ProductionComplaintDetails productionComplaintDetails) {
        ProductionComplaintDetails storedProductionComplaintDetails = productionComplaintDetailsRepository.save(productionComplaintDetails);
        return storedProductionComplaintDetails.getId();
    }

    public void updateComplaintDetails(long id, ProductionComplaintDetails productionComplaintDetails) {
        if (!productionComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaintDetails storedProductionComplaintDetails = productionComplaintDetailsRepository.findById(id).orElse(null);
        storedProductionComplaintDetails.setOrderNrCustomer((productionComplaintDetails.getOrderNrCustomer()));
        storedProductionComplaintDetails.setCode(productionComplaintDetails.getCode());
        storedProductionComplaintDetails.setName(productionComplaintDetails.getName());
        storedProductionComplaintDetails.setProductionCommentary(productionComplaintDetails.getProductionCommentary());
        productionComplaintDetailsRepository.save(productionComplaintDetails);
    }

    public void partialUpdateComplaintDetails(long id, Map<String, String> fields) {
        if (!productionComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionComplaintDetails storedProductionComplaintDetails = productionComplaintDetailsRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "order_nr_customer":
                    storedProductionComplaintDetails.setOrderNrCustomer((String) fields.get(field));
                    break;
                case "code":
                    storedProductionComplaintDetails.setCode((String) fields.get(field));
                    break;
                case "name":
                    storedProductionComplaintDetails.setName((String) fields.get(field));
                    break;
                case "production_commentary":
                    storedProductionComplaintDetails.setProductionCommentary((String) fields.get(field));
                    break;
            }
        }

        productionComplaintDetailsRepository.save(storedProductionComplaintDetails);
    }

    public void deleteComplaintDetails(long id) {
        if (!productionComplaintDetailsRepository.existsById(id)) { throw new RecordNotFoundException(); }
        productionComplaintDetailsRepository.deleteById(id);
    }

}