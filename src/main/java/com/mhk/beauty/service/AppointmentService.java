package com.mhk.beauty.service;

import com.mhk.beauty.entity.Appointment;
import java.util.List;
import org.springframework.data.domain.Sort;

public interface AppointmentService {

  Appointment createAppointment(Long ClientId, Appointment appointment);

  Appointment getAppointmentById(Long appointmentId);

  List<Appointment> findAppointmentsByClientId(Long clientId, Sort sort);

  List<Appointment> findByStaff(Long staffId, Sort sort);

  Appointment update(Long id, Appointment appointment);

  Boolean delete(Long id);


  List<Appointment> getAllAppointments(Sort sort);
}
