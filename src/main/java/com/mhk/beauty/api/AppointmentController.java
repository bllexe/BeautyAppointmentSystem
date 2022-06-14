package com.mhk.beauty.api;

import com.mhk.beauty.entity.Appointment;
import com.mhk.beauty.service.AppointmentService;
import java.util.List;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/appointment")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/create/{clientId}")
  public ResponseEntity<Appointment> createAppointment(@PathVariable Long clientId,
      @RequestBody Appointment appointment) {
    return ResponseEntity.ok(appointmentService.createAppointment(clientId, appointment));
  }

  @GetMapping("getAll")
  public ResponseEntity<List<Appointment>> getAllAppointments(Sort sort) {
    return ResponseEntity.ok(appointmentService.getAllAppointments(sort));
  }

  @GetMapping("getById/{id}")
  public ResponseEntity<Appointment> getById(@PathVariable Long id) {
    return ResponseEntity.ok(appointmentService.getAppointmentById(id));
  }

  @GetMapping("getByClientId/{clientId}")
  public ResponseEntity<List<Appointment>> getByClientId(@PathVariable Long clientId, Sort sort) {
    return ResponseEntity.ok(appointmentService.findAppointmentsByClientId(clientId, sort));
  }

  @GetMapping("getByStaff/{staffId}")
  public ResponseEntity<List<Appointment>> getByStaff(@PathVariable Long staffId, Sort sort) {
    return ResponseEntity.ok(appointmentService.findByStaff(staffId, sort));
  }

  @PutMapping("updateById/{id}")
  public ResponseEntity<Appointment> updateById(@PathVariable Long id,
      @RequestBody Appointment appointment) {
    return ResponseEntity.ok(appointmentService.update(id, appointment));
  }

  @DeleteMapping("deleteById/{id}")
  public Boolean deleteById(@PathVariable Long id) {
    return appointmentService.delete(id);
  }


}
