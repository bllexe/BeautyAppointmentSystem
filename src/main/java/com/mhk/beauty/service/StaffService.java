package com.mhk.beauty.service;

import com.mhk.beauty.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {

  Staff save(Long id, Staff staff);

  Staff getByUsername(String username);

  Page<Staff> getStaffOfManagement(Long id, Pageable pageable);

  Staff update(String username, Staff staff);

}
