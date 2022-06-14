package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Staff;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

  List<Client> getClientByStaff(Staff staff);

  List<Client> getClientByNameContains(String name);

  List<Client> getClientsByPhoneNumber(String phoneNumber);

}
