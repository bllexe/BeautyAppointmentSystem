package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Management, Long> {

  Management findManagementByEmail(String email);
}
