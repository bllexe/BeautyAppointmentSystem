package com.mhk.beauty.service;

import com.mhk.beauty.entity.Management;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagementService {

  Management saveManagement(Management management);

  Management getManagementById(Long managementId);

  Page<Management> getAllManagement(Pageable pageable);

  Management findManagementByEmail(String email);

  Management updateManagement(Long id, Management management);


}
