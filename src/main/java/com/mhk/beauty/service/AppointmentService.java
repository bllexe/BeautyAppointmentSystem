package com.mhk.beauty.service;

import com.mhk.beauty.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentService {

  Appointment createAppointment(String staffUsername, Long ClientId, Appointment appointment);

  Page<Appointment> getAppointmentsByClient(Long clientId, Long appointmentsId, Pageable pageable);

  Page<Appointment> getAppointmentsByDate(String dateCreated, Pageable pageable);

  Appointment getAppointmentById(Long appointmentId);

  Appointment update(Long id, Appointment appointment);

  Boolean delete(Appointment appointment);


}
