package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Appointment;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  List<Appointment> findByClientId(Long clientId, Sort sort);

  List<Appointment> findByStaffId(Long staffId, Sort sort);

  //List<Appointment> findByStartTimeDateLessThan(Date startTimeDate);

  List<Appointment> getByStartTime(Date date);

}
