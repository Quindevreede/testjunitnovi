package nl.novi.testjunitjupiter.controller.controller;

import nl.novi.testjunitjupiter.model.model.CustomerAssistEmployee;
import nl.novi.testjunitjupiter.service.service.CustomerAssistEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer_assist_employees")
public class CustomerAssistEmployeeController {

    @Autowired
    private CustomerAssistEmployeeService customerAssistEmployeeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCustomerServiceEmployees(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(customerAssistEmployeeService.getCustomerServiceEmployees(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomerServiceEmployee(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerAssistEmployeeService.getCustomerServiceEmployeeById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomerServiceEmployee(@RequestBody CustomerAssistEmployee customerAssistEmployee) {
        long newId = customerAssistEmployeeService.createCustomerServiceEmployee(customerAssistEmployee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerServiceEmployee(@PathVariable("id") long id, @RequestBody CustomerAssistEmployee customerAssistEmployee) {
        customerAssistEmployeeService.updateCustomerServiceEmployee(id, customerAssistEmployee);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerServiceEmployeePartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerAssistEmployeeService.partialUpdateCustomerServiceEmployee(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerServiceEmployee(@PathVariable("id") long id) {
        customerAssistEmployeeService.deleteCustomerServiceEmployee(id);
        return ResponseEntity.noContent().build();
    }

}