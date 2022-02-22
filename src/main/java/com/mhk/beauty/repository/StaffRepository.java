package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Management;
import com.mhk.beauty.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {

  Staff findByUsername(String username);

  Page<Staff> getStaffByManagement(Management management, Pageable pageable);
}
