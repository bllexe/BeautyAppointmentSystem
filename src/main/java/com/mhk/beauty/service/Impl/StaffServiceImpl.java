package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Management;
import com.mhk.beauty.entity.Staff;
import com.mhk.beauty.error.NotFoundException;
import com.mhk.beauty.repository.StaffRepository;
import com.mhk.beauty.service.ManagementService;
import com.mhk.beauty.service.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

  private final StaffRepository staffRepository;
  private final ManagementService managementService;

  public StaffServiceImpl(StaffRepository staffRepository,
      ManagementService managementService) {
    this.staffRepository = staffRepository;
    this.managementService = managementService;
  }


  @Override
  public Staff save(Long id, Staff staff) {
    Management managementInDb = managementService.getManagementById(id);
    if (managementInDb != null) {
      staff.setManagement(managementInDb);
    } else {
      throw new NotFoundException();
    }

    return staffRepository.save(staff);
  }

  @Override
  public Staff getByUsername(String username) {
    Staff inDB = staffRepository.findByUsername(username);

    if (inDB == null) {
      throw new NotFoundException();
    }
    return inDB;
  }

  @Override
  public Page<Staff> getStaffOfManagement(Long id, Pageable pageable) {

    Management inDB = managementService.getManagementById(id);
    return staffRepository.getStaffByManagement(inDB, pageable);
  }

  @Override
  public Staff update(String username, Staff staff) {
    Staff inDB = staffRepository.findByUsername(username);
    inDB.setUsername(staff.getUsername());
    inDB.setPassword(staff.getPassword());
    return staffRepository.save(inDB);
  }

  @Override
  public Boolean delete(Staff staff) {
    staffRepository.delete(staff);
    return true;
  }
}
