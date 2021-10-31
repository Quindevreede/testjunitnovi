package nl.novi.testjunitjupiter.service.service;

import nl.novi.testjunitjupiter.exceptions.UserNotFoundException;
import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetails;
import nl.novi.testjunitjupiter.repository.repository.CustomerComplaintDetailsRepository;
import nl.novi.testjunitjupiter.repository.repository.ProductionComplaintDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class CustomerComplaintDetailsService {

    @Autowired
    CustomerComplaintDetailsRepository customerComplaintDetailsRepository;

    @Autowired
    ProductionComplaintDetailsRepository productionComplaintDetailsRepository;

    @Autowired
    UserService username;


    public Collection<CustomerComplaintDetails> getAllCustomers() {
        return customerComplaintDetailsRepository.findAll();
    }

    public Collection<CustomerComplaintDetails> getCustomers(String name) {
        if (name.isEmpty()) {
            return customerComplaintDetailsRepository.findAll();
        }
        else {
            return customerComplaintDetailsRepository.findAllByLastName(name);
        }
    }

    public CustomerComplaintDetails getCustomerById(long id) {
        if (!customerComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerComplaintDetailsRepository.findById(id).orElse(null);
    }

    public long createCustomer (CustomerComplaintDetails customerComplaintDetails) {
        customerComplaintDetails.setUsername(username.getCurrentUserName()); //TODO if no currentUserName?
        CustomerComplaintDetails storedCustomerComplaintDetails = customerComplaintDetailsRepository.save(customerComplaintDetails);
        return storedCustomerComplaintDetails.getId();
    }

    public void updateCustomer(long id, CustomerComplaintDetails customerComplaintDetails) {
        if (!customerComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerComplaintDetails storedCustomerComplaintDetails = customerComplaintDetailsRepository.findById(id).orElse(null);
        storedCustomerComplaintDetails.setUsername(username.getCurrentUserName());
        storedCustomerComplaintDetails.setOrderNumberCustomer(customerComplaintDetails.getOrderNumberCustomer());
        storedCustomerComplaintDetails.setFirstName(customerComplaintDetails.getFirstName());
        storedCustomerComplaintDetails.setLastName(customerComplaintDetails.getLastName());
        storedCustomerComplaintDetails.setEmail(customerComplaintDetails.getEmail());
        storedCustomerComplaintDetails.setCustomerCommentary((customerComplaintDetails.getCustomerCommentary()));
        customerComplaintDetailsRepository.save(customerComplaintDetails);
    }

    public void partialUpdateCustomer(long id, Map<String, String> fields) {
        if (!customerComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerComplaintDetails storedCustomerComplaintDetails = customerComplaintDetailsRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "order_number":
                    storedCustomerComplaintDetails.setFirstName((String) fields.get(field));
                    break;
                case "first_name":
                    storedCustomerComplaintDetails.setFirstName((String) fields.get(field));
                    break;
                case "last_name":
                    storedCustomerComplaintDetails.setLastName((String) fields.get(field));
                    break;
                case "email":
                    storedCustomerComplaintDetails.setEmail((String) fields.get(field));
                case "customer_commentary":
                    storedCustomerComplaintDetails.setCustomerCommentary((String) fields.get(field));
                    break;
            }
        }
        customerComplaintDetailsRepository.save(storedCustomerComplaintDetails);
    }

    public void deleteCustomer(long id) {
        if (!customerComplaintDetailsRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerComplaintDetailsRepository.deleteById(id);
    }

}