package com.mhk.beauty.service;

import com.mhk.beauty.entity.Payment;
import java.util.List;

public interface PaymentService {

  Payment save(Long treatmentId,  Payment payment);

  List<Payment> getPaymentsByClient(Long clientId);

  Payment getPaymentByPaymentType(Payment payment);

}
