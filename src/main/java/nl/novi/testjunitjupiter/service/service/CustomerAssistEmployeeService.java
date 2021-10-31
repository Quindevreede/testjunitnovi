package nl.novi.testjunitjupiter.service.service;

import nl.novi.testjunitjupiter.exceptions.UserNotFoundException;
import nl.novi.testjunitjupiter.model.model.CustomerAssistEmployee;
import nl.novi.testjunitjupiter.repository.repository.CustomerAssistEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class CustomerAssistEmployeeService {

    @Autowired
    CustomerAssistEmployeeRepository customerAssistEmployeeRepository;

    public Collection<CustomerAssistEmployee> getAllCustomerServiceEmployee() {
        return customerAssistEmployeeRepository.findAll();
    }

    public Collection<CustomerAssistEmployee> getCustomerServiceEmployees(String name) {
        if (name.isEmpty()) {
            return customerAssistEmployeeRepository.findAll();
        }
        else {
            return customerAssistEmployeeRepository.findAllByLastName(name);
        }
    }

    public CustomerAssistEmployee getCustomerServiceEmployeeById(long id) {
        if (!customerAssistEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        return customerAssistEmployeeRepository.findById(id).orElse(null);
    }

    public long createCustomerServiceEmployee (CustomerAssistEmployee customerAssistEmployee) {
        CustomerAssistEmployee storedCustomerAssistEmployee = customerAssistEmployeeRepository.save(customerAssistEmployee);
        return storedCustomerAssistEmployee.getId();
    }

    public void updateCustomerServiceEmployee(long id, CustomerAssistEmployee customerAssistEmployee) {
        if (!customerAssistEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerAssistEmployee storedCustomerAssistEmployee = customerAssistEmployeeRepository.findById(id).orElse(null);
        storedCustomerAssistEmployee.setPosition(customerAssistEmployee.getPosition());
        storedCustomerAssistEmployee.setCompanyPhoneNumber(customerAssistEmployee.getCompanyPhoneNumber());
        customerAssistEmployeeRepository.save(customerAssistEmployee);
    }

    public void partialUpdateCustomerServiceEmployee(long id, Map<String, String> fields) {
        if (!customerAssistEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        CustomerAssistEmployee storedCustomerAssistEmployee = customerAssistEmployeeRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "last_name":
                    storedCustomerAssistEmployee.setLastName((String) fields.get(field));
                    break;
                case "position":
                    storedCustomerAssistEmployee.setPosition((String) fields.get(field));
                    break;
                case "company_phone_number":
                    storedCustomerAssistEmployee.setCompanyPhoneNumber((String) fields.get(field));
                    break;
            }
        }
        customerAssistEmployeeRepository.save(storedCustomerAssistEmployee);
    }

    public void deleteCustomerServiceEmployee(long id) {
        if (!customerAssistEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        customerAssistEmployeeRepository.deleteById(id);
    }

}
