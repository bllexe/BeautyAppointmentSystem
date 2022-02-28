package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Payment;
import com.mhk.beauty.entity.Treatment;
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
  public Payment save(Long treatmentId, Payment payment) {
    Treatment treatmentInDb = treatmentService.findById(treatmentId);
    if (treatmentInDb != null) {
      payment.setClient(treatmentInDb.getClient());
    } else{
      throw new IllegalArgumentException("client does not found");
    }

    return paymentRepository.save(payment);
  }

  @Override
  public List<Payment> getPaymentsByClient(Long clientId) {
    return null;
  }

  @Override
  public Payment getPaymentByPaymentType(Payment payment) {

    return null;
  }


  public BigDecimal computeTreatmentPrice(Long treatmentId, Payment payment ){

    return null;
  }

}
