package com.mhk.beauty.service;

import com.mhk.beauty.entity.Client;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

  Client save(Client client, Long id);

  Client getById(Long id);

  Page<Client> getAllClients(Pageable pageable);

  List<Client> getClientByNameContains(String name);

  List<Client> getClientsByPhoneNumber(String phoneNumber);

  List<Client> getClientsOfStaff(Long id);

  Client update(Long id, Client client);

  Boolean delete(Long id);

}
