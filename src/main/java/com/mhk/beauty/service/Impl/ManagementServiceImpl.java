package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Management;
import com.mhk.beauty.repository.ManagementRepository;
import com.mhk.beauty.service.ManagementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceImpl implements ManagementService {

  private final ManagementRepository managementRepository;

  public ManagementServiceImpl(ManagementRepository managementRepository) {
    this.managementRepository = managementRepository;
  }


  @Override
  public Management saveManagement(Management management) {
    return managementRepository.save(management);
  }

  @Override
  public Management getManagementById(Long managementId) {

    return managementRepository.findById(managementId).get();
  }

  @Override
  public Page<Management> getAllManagement(Pageable pageable) {

    return managementRepository.findAll(pageable);
  }

  @Override
  public Management updateManagement(Long id, Management management) {

    Management inDB = managementRepository.getById(id);

    if (inDB == null) {
      throw new IllegalArgumentException("Management does not exist");
    }

    inDB.setName(management.getName());
    inDB.setEmail(management.getEmail());
    inDB.setPhoneNumber(management.getPhoneNumber());
    inDB.setPassword(management.getPassword());
    return managementRepository.save(inDB);
  }

  @Override
  public Management findManagementByEmail(String email) {
    return managementRepository.findManagementByEmail(email);
  }
}
