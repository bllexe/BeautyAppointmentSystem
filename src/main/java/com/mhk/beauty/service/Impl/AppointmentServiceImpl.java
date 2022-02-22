package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Appointment;
import com.mhk.beauty.entity.Client;
import com.mhk.beauty.error.NotFoundException;
import com.mhk.beauty.repository.AppointmentRepository;
import com.mhk.beauty.service.AppointmentService;
import com.mhk.beauty.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {


  private final AppointmentRepository appointmentRepository;
  private final ClientService clientService;

  public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
      ClientService clientService) {
    this.appointmentRepository = appointmentRepository;
    this.clientService = clientService;
  }


  @Override

  public Appointment createAppointment(Appointment appointment) {
    return null;

  }

  @Override
  public Page<Appointment> getAppointmentsByClient(Long clientId, Long appointmentId, Pageable pageable) {
    Appointment appointment = appointmentRepository.getById(appointmentId);
    Client clientInDb = clientService.getById(clientId);
    if (clientInDb != null) {
      appointment.setClient(clientInDb);
    } else {
      throw new NotFoundException();
    }

    return null;
  }

  @Override
  public Page<Appointment> getAppointmentsByDate(String dateCreated, Pageable pageable) {
    return null;
  }


  @Override
  public Appointment update(Long id, Appointment appointment) {
    return null;
  }

  @Override
  public Boolean delete(Appointment appointment) {

    return null;
  }

  @Override
  public Appointment getAppointmentById(Long appointmentId) {
    return appointmentRepository.getById(appointmentId);
  }
}

