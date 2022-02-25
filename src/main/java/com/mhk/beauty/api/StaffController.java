package com.mhk.beauty.api;

import com.mhk.beauty.entity.Staff;
import com.mhk.beauty.service.StaffService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {

  private final StaffService staffService;

  public StaffController(StaffService staffService) {
    this.staffService = staffService;
  }


  @PostMapping("/{id}")
  public ResponseEntity<Staff> createStaff(@RequestBody Staff staff, @PathVariable Long id) {
    return ResponseEntity.ok(staffService.save(id, staff));
  }

  @GetMapping("/findByStaffUsername/{username}")
  public ResponseEntity<Staff> getStaffByUsername(@PathVariable(value = "username") String username) {

    Staff staff = staffService.getByUsername(username);
    return ResponseEntity.ok(staff);
  }

  @GetMapping("/findByManagementId/{id}")
  public ResponseEntity<Page<Staff>> getStaffOfManagement(@PathVariable(value = "id") Long id, Pageable pageable) {
    return ResponseEntity.ok(staffService.getStaffOfManagement(id, pageable));
  }

  @PutMapping("/update/{username}")
  public ResponseEntity<Staff> updateStaff(@PathVariable String username, @RequestBody Staff staff) {
    return ResponseEntity.ok(staffService.update(username, staff));
  }



}
