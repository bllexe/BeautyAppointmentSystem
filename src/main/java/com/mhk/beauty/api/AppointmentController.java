package com.mhk.beauty.api;

import com.mhk.beauty.entity.Appointment;
import com.mhk.beauty.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/create/{clientId}")
  public ResponseEntity<Appointment> createAppointment( @PathVariable Long clientId,
      @RequestBody Appointment appointment) {
    return ResponseEntity.ok(appointmentService.createAppointment(clientId, appointment));
  }


}
