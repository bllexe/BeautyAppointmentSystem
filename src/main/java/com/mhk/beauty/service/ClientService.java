package com.mhk.beauty.service;

import com.mhk.beauty.entity.Client;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

  Client save(Client client, String username);

  Client getById(Long id);

  Page<Client> getAllClients(Pageable pageable);

  Page<Client> getClientByNameContains(String name, Pageable pageable);

  List<Client> getClientsByPhoneNumber(String phoneNumber);

  Page<Client> getClientsOfStaff(String username, Pageable pageable);

  Client update(Long id, Client client);

  Boolean delete(Long id);

}
