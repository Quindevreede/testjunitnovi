package nl.novi.testjunitjupiter.controller.controller;

import nl.novi.testjunitjupiter.model.model.ProductionEmployee;
import nl.novi.testjunitjupiter.service.service.ProductionEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/production_employees")
public class ProductionEmployeeController {

    @Autowired
    private ProductionEmployeeService productionEmployeeService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchProductionEmployees(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(productionEmployeeService.getProductionEmployees(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getProductionEmployee(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(productionEmployeeService.getProductionEmployeeById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createProductionEmployee(@RequestBody ProductionEmployee productionEmployee) {
        long newId = productionEmployeeService.createProductionEmployee(productionEmployee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateProductionEmployee(@PathVariable("id") long id, @RequestBody ProductionEmployee productionEmployee) {
        productionEmployeeService.updateProductionEmployee(id, productionEmployee);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateProductionEmployeePartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        productionEmployeeService.partialUpdateProductionEmployee(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProductionEmployee(@PathVariable("id") long id) {
        productionEmployeeService.deleteProductionEmployee(id);
        return ResponseEntity.noContent().build();
    }

}