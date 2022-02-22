package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Staff;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

  Page<Client> getClientByStaff(Staff staff, Pageable pageable);

  Page<Client> getClientByNameContains(String name, Pageable pageable);

  List<Client> getClientsByPhoneNumber(String phoneNumber);

}
