package com.mhk.beauty.api;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.service.ClientService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/{id}")
  public ResponseEntity<Client> createClient(@RequestBody Client client, @PathVariable Long id) {

    return ResponseEntity.ok(clientService.save(client, id));
  }

  @GetMapping("all")
  public ResponseEntity<Page<Client>> getAllClients(Pageable pageable) {
    return ResponseEntity.ok(clientService.getAllClients(pageable));
  }

  @GetMapping("/findByStaffId/{id}")
  public ResponseEntity<List<Client>> getClientsByStaff(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.getClientsOfStaff(id));
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.getById(id));
  }

  @GetMapping("/findByName/{name}")
  public ResponseEntity<List<Client>> getClientByName(@PathVariable String name) {
    return ResponseEntity.ok(clientService.getClientByNameContains(name));
  }

  @GetMapping("/findByPhoneNumber/{phoneNumber}")
  public ResponseEntity<List<Client>> getClientByPhoneNumber(@PathVariable String phoneNumber) {
    return ResponseEntity.ok(clientService.getClientsByPhoneNumber(phoneNumber));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
    return ResponseEntity.ok(clientService.update(id, client));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Boolean> deleteClient(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.delete(id));
  }

}
