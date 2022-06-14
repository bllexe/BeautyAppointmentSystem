package com.mhk.beauty.api;

import com.mhk.beauty.entity.Management;
import com.mhk.beauty.service.ManagementService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
public class ManagementController {

  private final ManagementService managementService;

  public ManagementController(ManagementService managementService) {
    this.managementService = managementService;
  }

  @PostMapping
  public ResponseEntity<Management> createManagement(@RequestBody Management management) {

    return ResponseEntity.ok(managementService.saveManagement(management));
  }

  @GetMapping("/all")
  public ResponseEntity<List<Management>> getAllManagement() {
    return ResponseEntity.ok(managementService.getAllManagement());
  }

  @GetMapping("/findManagerById/{id}")
  public ResponseEntity<Management> getManagementById(@PathVariable Long id) {
    return ResponseEntity.ok(managementService.getManagementById(id));
  }

  @GetMapping("/getManagementByEmail/{email}")
  public ResponseEntity<Management> getManagementByEmail(@PathVariable String email) {
    return ResponseEntity.ok(managementService.findManagementByEmail(email));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Management> updateManagement(@PathVariable Long id,
      @RequestBody Management management) {
    return ResponseEntity.ok(managementService.updateManagement(id, management));
  }


}
