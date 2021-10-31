package nl.novi.testjunitjupiter.service.service;

import nl.novi.testjunitjupiter.exceptions.UserNotFoundException;
import nl.novi.testjunitjupiter.model.model.ProductionEmployee;
import nl.novi.testjunitjupiter.repository.repository.ProductionEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class ProductionEmployeeService {

    @Autowired
    ProductionEmployeeRepository productionEmployeeRepository;

    public Collection<ProductionEmployee> getAllProductionEmployee() {
        return productionEmployeeRepository.findAll();
    }

    public Collection<ProductionEmployee> getProductionEmployees(String name) {
        if (name.isEmpty()) {
            return productionEmployeeRepository.findAll();
        }
        else {
            return productionEmployeeRepository.findAllByLastName(name);
        }
    }

    public ProductionEmployee getProductionEmployeeById(long id) {
        if (!productionEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        return productionEmployeeRepository.findById(id).orElse(null);
    }

    public long createProductionEmployee (ProductionEmployee productionEmployee) {
        ProductionEmployee storedProductionEmployee  = productionEmployeeRepository.save(productionEmployee);
        return storedProductionEmployee.getId();
    }

    public void updateProductionEmployee(long id, ProductionEmployee productionEmployee) {
        if (!productionEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionEmployee storedProductionEmployee = productionEmployeeRepository.findById(id).orElse(null);
        storedProductionEmployee.setProductionDepartment(productionEmployee.getProductionDepartment());
        storedProductionEmployee.setCompanyPhoneNumber(productionEmployee.getCompanyPhoneNumber());
        productionEmployeeRepository.save(productionEmployee);
    }

    public void partialUpdateProductionEmployee(long id, Map<String, String> fields) {
        if (!productionEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        ProductionEmployee storedProductionEmployee = productionEmployeeRepository.findById(id).orElse(null);
        for (String field : fields.keySet()) {
            switch (field) {
                case "last_name":
                    storedProductionEmployee.setLastName((String) fields.get(field));
                    break;
                case "production_department":
                    storedProductionEmployee.setProductionDepartment((String) fields.get(field));
                    break;
                case "company_phone_number":
                    storedProductionEmployee.setCompanyPhoneNumber((String) fields.get(field));
                    break;
            }
        }
        productionEmployeeRepository.save(storedProductionEmployee);
    }

    public void deleteProductionEmployee(long id) {
        if (!productionEmployeeRepository.existsById(id)) { throw new UserNotFoundException(); }
        productionEmployeeRepository.deleteById(id);
    }

}
