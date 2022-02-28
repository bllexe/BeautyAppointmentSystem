package com.mhk.beauty.api;

import com.mhk.beauty.entity.Treatment;
import com.mhk.beauty.service.TreatmentService;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("treatment")
public class TreatmentController {

  private final TreatmentService treatmentService;

  public TreatmentController(TreatmentService treatmentService) {
    this.treatmentService = treatmentService;
  }

  @PostMapping("/save/{clientId}")
  public ResponseEntity<Treatment> save(@PathVariable Long clientId, @RequestBody Treatment treatment) {
    return ResponseEntity.ok(treatmentService.save(clientId, treatment));
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Treatment> findById(@PathVariable Long id) {

    return ResponseEntity.ok(treatmentService.findById(id));
  }

  @GetMapping("/getByClientId/{clientId}")
  public ResponseEntity<List<Treatment>> getTreatmentsByClientId(@PathVariable Long clientId, Sort sort) {
    return ResponseEntity.ok(treatmentService.findTreatmentsByClientId(clientId, sort));
  }

  @PutMapping("update/{id}")
  public ResponseEntity<Treatment> updateTreatment(@PathVariable Long id, @RequestBody Treatment treatment) {
    return ResponseEntity.ok(treatmentService.update(id,treatment));
  }

}
