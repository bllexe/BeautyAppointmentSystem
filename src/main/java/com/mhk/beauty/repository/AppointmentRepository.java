package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Appointment;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  Page<Appointment> getAppointmentByDateCreated(Date dateCreated, Pageable pageable);

  Page<Appointment> getAppointmentsByClient(Long clientId, Long appointmentId, Pageable pageable);

  Page<Appointment> getAppointmentsByDateCreatedGreaterThan(Date dateCreated, Pageable pageable);

}
