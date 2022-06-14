package com.mhk.beauty.service;

import com.mhk.beauty.entity.Management;
import java.util.List;

public interface ManagementService {

  Management saveManagement(Management management);

  Management getManagementById(Long managementId);

  List<Management> getAllManagement();

  Management findManagementByEmail(String email);

  Management updateManagement(Long id, Management management);


}
