package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Treatment;
import com.mhk.beauty.repository.TreatmentRepository;
import com.mhk.beauty.service.ClientService;
import com.mhk.beauty.service.TreatmentService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {

  private final TreatmentRepository treatmentRepository;
  private final ClientService clientService;

  public TreatmentServiceImpl(TreatmentRepository treatmentRepository,
      ClientService clientService) {
    this.treatmentRepository = treatmentRepository;
    this.clientService = clientService;
  }

  @Override
  public Treatment save(Long clientId, Treatment treatment) {

    Client clientInDb = clientService.getById(clientId);
    if (clientInDb == null) {
      throw new IllegalArgumentException("client does not exist");
    } else {
      treatment.setClient(clientInDb);
    }
    return treatmentRepository.save(treatment);
  }

  @Override
  public Treatment findById(Long id) {

    return treatmentRepository.findById(id).get();
  }

  @Override
  public List<Treatment> findByClientId(Long clientId) {
    Client clientInDb = clientService.getById(clientId);
    if (clientInDb == null) {
      throw new IllegalArgumentException("client does not exist");
    }
    return treatmentRepository.findByClientId(clientId);
  }

  @Override
  public Treatment update(Long id, Treatment treatment) {
    Treatment inDb = treatmentRepository.getById(id);
    if (inDb != null) {
      inDb.setDescription(treatment.getDescription());
      inDb.setPrice(treatment.getPrice());
    }

    return treatmentRepository.save(inDb);
  }



}
