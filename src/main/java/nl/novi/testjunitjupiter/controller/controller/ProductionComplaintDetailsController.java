package nl.novi.testjunitjupiter.controller.controller;

import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetailsProductionComplaintDetailsResultKey;
import nl.novi.testjunitjupiter.model.model.ProductionComplaintDetails;
import nl.novi.testjunitjupiter.model.model.CustomerComplaintDetailsProductionComplaintDetailsResult;
import nl.novi.testjunitjupiter.service.service.CustomerComplaintDetailsProductionComplaintDetailsResultService;
import nl.novi.testjunitjupiter.service.service.ProductionComplaintDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/production_complaint_details")
public class ProductionComplaintDetailsController {

    @Autowired
    ProductionComplaintDetailsService productionComplaintDetailsService;

    @Autowired
    private CustomerComplaintDetailsProductionComplaintDetailsResultService customerComplaintDetailsProductionComplaintDetailsResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchComplaintDetails(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(productionComplaintDetailsService.getComplaintDetails(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getComplaintDetails(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(productionComplaintDetailsService.getComplaintDetailsById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createComplaintDetails(@RequestBody ProductionComplaintDetails productionComplaintDetails) {
        long newId = productionComplaintDetailsService.createComplaintDetails(productionComplaintDetails);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateComplaint(@PathVariable("id") long id, @RequestBody ProductionComplaintDetails productionComplaintDetails) {
        productionComplaintDetailsService.updateComplaintDetails(id, productionComplaintDetails);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateComplaintPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        productionComplaintDetailsService.partialUpdateComplaintDetails(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteComplaint(@PathVariable("id") long id) {
        productionComplaintDetailsService.deleteComplaintDetails(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/customer_complaint_details")
    public ResponseEntity<Object> getCustomerComplaintDetailsProductionComplaintDetailsResults(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerComplaintDetailsProductionComplaintDetailsResultService.getResultsByProductionComplaintDetailsId(id));
    }

    @GetMapping(value = "/{production_complaint_details_id}/customer_complaint_details/{customer_complaint_details_id}")
    public ResponseEntity<Object> getCustomerComplaintResult(@PathVariable("production_complaint_details_id") long productionComplaintDetailsId,
                                                         @PathVariable("customer_complaint_details_id") long customerComplaintDetailsId) {
        return ResponseEntity.ok().body(customerComplaintDetailsProductionComplaintDetailsResultService.getResultById(customerComplaintDetailsId, productionComplaintDetailsId));
    }

    @PostMapping(value = "/{production_complaint_details_id}/customer_complaint_details/{customer_complaint_details_id}")
    public ResponseEntity<Object> addStudentComplaintResult(@PathVariable("production_complaint_details_id") long productionComplaintDetailsId,
                                                         @PathVariable("customer_complaint_details_id") long customerComplaintDetailsId,
                                                         @RequestBody CustomerComplaintDetailsProductionComplaintDetailsResult result) {
        CustomerComplaintDetailsProductionComplaintDetailsResultKey newId = customerComplaintDetailsProductionComplaintDetailsResultService.addResult(productionComplaintDetailsId, customerComplaintDetailsId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

}

