package com.mhk.beauty.service;

import com.mhk.beauty.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {

  Staff save(Long id, Staff staff);

  Staff getById(Long id);

  Page<Staff> gelAllStaff(Pageable pageable);

  Page<Staff> getStaffOfManagement(Long id, Pageable pageable);

  Staff update(Long id, Staff staff);

  Staff findById(Long staffId);

  Boolean deleteById(Long id);

}
