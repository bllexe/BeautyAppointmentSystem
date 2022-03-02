package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Payment;
import com.mhk.beauty.entity.Treatment;
import com.mhk.beauty.error.NotFoundException;
import com.mhk.beauty.repository.PaymentRepository;
import com.mhk.beauty.service.ClientService;
import com.mhk.beauty.service.PaymentService;
import com.mhk.beauty.service.TreatmentService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;
  private final ClientService clientService;
  private final TreatmentService treatmentService;

  public PaymentServiceImpl(PaymentRepository paymentRepository, ClientService clientService,
      TreatmentService treatmentService) {
    this.paymentRepository = paymentRepository;
    this.clientService = clientService;
    this.treatmentService = treatmentService;
  }


  @Override
  public Payment save(Long clientId, Payment payment) {

    Client clientInDb = clientService.getById(clientId);

    if (clientInDb == null) {
      throw new IllegalArgumentException("client does not found");
    } else {
      payment.setClient(clientInDb);
      payment.setTotalAmount(setTotalPrice(clientInDb.getId()));
    }
    return paymentRepository.save(payment);
  }

  @Override
  public List<Payment> findByClientId(Long clientId) {
    Client inDb = clientService.getById(clientId);
    if (inDb == null) {
      throw new IllegalArgumentException("client does not exist");
    }
    return paymentRepository.findByClientId(clientId);
  }

  @Override
  public Payment getPaymentByPaymentType(Payment payment) {

    return null;
  }

  @Override
  public BigDecimal countRemainingAmount(Long clientId) {
    BigDecimal remainingAmount = new BigDecimal("0");
    Client innDb = clientService.getById(clientId);

    if (innDb != null) {
      remainingAmount = setTotalPrice(clientId).subtract(getTotalPaidAmount(clientId));
    } else {
      throw new NotFoundException();
    }
    return remainingAmount;
  }

  public BigDecimal getTotalPaidAmount(Long clientId) {
    BigDecimal totalPaidAmount = new BigDecimal("0");
    Client clientInDb = clientService.getById(clientId);

    List<Payment> payments = findByClientId(clientId);

    for (Payment payment : payments) {
      if (payment.getClient().getId() == clientInDb.getId()) {
        totalPaidAmount = payment.getPaidAmount().add(totalPaidAmount);
      }
    }
    return totalPaidAmount;
  }

  public BigDecimal setTotalPrice(Long clientId) {
    BigDecimal totalPrice = new BigDecimal("0");
    Client clientInDb = clientService.getById(clientId);

    List<Treatment> treatments = treatmentService.findByClientId(clientInDb.getId());

    for (Treatment treatment : treatments) {
      if (treatment.getClient().getId() == clientInDb.getId()) {
        totalPrice = treatment.getPrice().add(totalPrice);
      }
    }
    return totalPrice;
  }


}

