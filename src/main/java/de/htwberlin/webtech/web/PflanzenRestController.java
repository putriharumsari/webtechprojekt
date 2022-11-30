package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.PflanzenService;
import de.htwberlin.webtech.web.api.Pflanzen;
import de.htwberlin.webtech.web.api.PflanzenManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PflanzenRestController {

    private final PflanzenService pflanzenService;
    public PflanzenRestController(PflanzenService pflanzenService) { this.pflanzenService = pflanzenService; }
    @GetMapping(path = "/api/v1/pflanzens")
    public ResponseEntity<List<Pflanzen>> fetchPflanzen() {
        return ResponseEntity.ok(pflanzenService.findAll());
    }

    @GetMapping(path = "/api/v1/pflanzens/{id}")
    public ResponseEntity<Pflanzen> fetchPersonById(@PathVariable Long id) {
        var pflanzen = pflanzenService.findById(id);
        return pflanzen != null? ResponseEntity.ok(pflanzen) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/pflanzens")
    public ResponseEntity<Void> createPerson(@RequestBody PflanzenManipulationRequest request) throws URISyntaxException {
        var pflanzen = pflanzenService.create(request);
        URI uri = new URI("/api/v1/pflanzens/" + pflanzen.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/pflanzens/{id}")
    public ResponseEntity<Pflanzen> updatePerson(@PathVariable Long id, @RequestBody PflanzenManipulationRequest request) {
        var pflanzen = pflanzenService.update(id, request);
        return pflanzen != null? ResponseEntity.ok(pflanzen) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/pflanzens/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = pflanzenService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
