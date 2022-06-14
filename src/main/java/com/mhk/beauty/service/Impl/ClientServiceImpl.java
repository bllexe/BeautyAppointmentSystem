package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Staff;
import com.mhk.beauty.repository.ClientRepository;
import com.mhk.beauty.service.ClientService;
import com.mhk.beauty.service.StaffService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;
  private final StaffService staffService;

  public ClientServiceImpl(ClientRepository clientRepository,
      StaffService staffService) {
    this.clientRepository = clientRepository;
    this.staffService = staffService;
  }


  @Override
  public Client save(Client client, Long id) {

    Staff staffInDb = staffService.getById(id);

    if (staffInDb != null) {
      client.setStaff(staffInDb);
    } else {
      throw new IllegalArgumentException("staff does not exit");
    }
    return clientRepository.save(client);
  }

  @Override
  public Client getById(Long id) {
    return clientRepository.findById(id).get();
  }

  @Override
  public List<Client> getClientByNameContains(String name) {
    return clientRepository.getClientByNameContains(name);
  }

  @Override
  public List<Client> getClientsByPhoneNumber(String phoneNumber) {

    List<Client> clients = clientRepository.getClientsByPhoneNumber(phoneNumber);

    if (clients != null && !clients.isEmpty()) {
      return clientRepository.getClientsByPhoneNumber(phoneNumber);
    } else {
      throw new IllegalArgumentException("Phone number does not exist");
    }

  }

  @Override
  public Page<Client> getAllClients(Pageable pageable) {

    return clientRepository.findAll(pageable);
  }

  @Override
  public List<Client> getClientsOfStaff(Long id) {
    Staff staffInDb = staffService.getById(id);
    return clientRepository.getClientByStaff(staffInDb);
  }

  @Override
  public Client update(Long id, Client client) {
    Client clientInDb = clientRepository.getById(id);
    if (clientInDb == null) {
      throw new IllegalArgumentException("Client does not exit...");
    }

    clientInDb.setName(client.getName());
    clientInDb.setSurname(client.getSurname());
    clientInDb.setPhoneNumber(client.getPhoneNumber());
    clientInDb.setAddress(client.getAddress());
    clientInDb.setDescription(client.getDescription());
    clientInDb.setEmail(client.getEmail());
    clientInDb.setJobTitle(client.getJobTitle());
    clientInDb.setAge(client.getAge());
    clientInDb.setLastUpdated(client.getLastUpdated());

    return clientRepository.save(clientInDb);
  }

  @Override
  public Boolean delete(Long id) {
    clientRepository.deleteById(id);
    return true;
  }
}
