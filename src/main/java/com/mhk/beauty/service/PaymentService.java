package com.mhk.beauty.service;

import com.mhk.beauty.entity.Payment;
import java.util.List;

public interface PaymentService {

  Payment save(Long clientId,  Payment payment);

  List<Payment> findByClientId(Long clientId);

  Payment getPaymentByPaymentType(Payment payment);

}
