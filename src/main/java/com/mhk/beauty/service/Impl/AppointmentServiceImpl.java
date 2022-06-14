package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Appointment;
import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Staff;
import com.mhk.beauty.error.NotFoundException;
import com.mhk.beauty.repository.AppointmentRepository;
import com.mhk.beauty.service.AppointmentService;
import com.mhk.beauty.service.ClientService;
import com.mhk.beauty.service.StaffService;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {


  private final AppointmentRepository appointmentRepository;
  private final ClientService clientService;
  private final StaffService staffService;


  public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
      ClientService clientService, StaffService staffService) {
    this.appointmentRepository = appointmentRepository;
    this.clientService = clientService;
    this.staffService = staffService;
  }


  @Override
  public Appointment createAppointment(Long clientId, Appointment appointment) {

    Client clientInDb = clientService.getById(clientId);

    if (clientInDb != null) {
      appointment.setName(clientInDb.getName());
      appointment.setClient(clientInDb);
      appointment.setStaff(clientInDb.getStaff());
    } else {
      throw new NotFoundException();
    }

    return appointmentRepository.save(appointment);

  }

  @Override
  public List<Appointment> getAllAppointments(Sort sort) {
    return appointmentRepository.findAll(sort);
  }


  @Override
  public Appointment getAppointmentById(Long appointmentId) {
    return appointmentRepository.getById(appointmentId);
  }

  @Override
  public List<Appointment> findAppointmentsByClientId(Long clientId, Sort sort) {
    Client clientInDb = clientService.getById(clientId);
    if (clientInDb == null) {
      throw new NotFoundException();
    }
    return appointmentRepository.findByClientId(clientId, sort);
  }

  @Override
  public List<Appointment> findByStaff(Long staffId, Sort sort) {
    Staff inDb = staffService.findById(staffId);
    if (inDb == null) {
      throw new NotFoundException();
    }
    return appointmentRepository.findByStaffId(staffId, sort);
  }


  @Override
  public Appointment update(Long id, Appointment appointment) {
    Appointment inDb = appointmentRepository.findById(id).get();
    if (inDb != null) {
      inDb.setDescription(appointment.getDescription());
      inDb.setStartTime(appointment.getStartTime());
      inDb.setEndTime(appointment.getEndTime());
      inDb.setStatus(appointment.getStatus());
      inDb.setDateUpdated(appointment.getDateUpdated());
    }
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    appointmentRepository.deleteById(id);
    return true;
  }


}

