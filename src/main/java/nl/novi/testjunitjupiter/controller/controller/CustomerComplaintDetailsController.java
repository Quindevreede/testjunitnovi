package nl.novi.testjunitjupiter.controller.controller;

import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetails;
import nl.novi.testjunitjupiter.service.service.CustomerComplaintDetailsProductionComplaintDetailsResultService;
import nl.novi.testjunitjupiter.service.service.CustomerComplaintDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_complaint_details")
public class CustomerComplaintDetailsController {

    @Autowired
    private CustomerComplaintDetailsService customerComplaintDetailsService;

       @Autowired
       private CustomerComplaintDetailsProductionComplaintDetailsResultService customerComplaintDetailsProductionComplaintDetailsResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomerDetails(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(customerComplaintDetailsService.getCustomers(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerDetails(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerComplaintDetailsService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomerDetails(@RequestBody CustomerComplaintDetails customerComplaintDetails) {
        long newId = customerComplaintDetailsService.createCustomer(customerComplaintDetails);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerDetails(@PathVariable("id") long id, @RequestBody CustomerComplaintDetails customerComplaintDetails) {
        customerComplaintDetailsService.updateCustomer(id, customerComplaintDetails);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerDetailsPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerComplaintDetailsService.partialUpdateCustomer(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerDetails(@PathVariable("id") long id) {
        customerComplaintDetailsService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}

