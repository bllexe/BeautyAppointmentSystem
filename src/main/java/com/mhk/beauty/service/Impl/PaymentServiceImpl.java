package com.mhk.beauty.service.Impl;

import com.mhk.beauty.entity.Payment;
import com.mhk.beauty.repository.PaymentRepository;
import com.mhk.beauty.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  private final PaymentRepository paymentRepository;

  public PaymentServiceImpl(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }


  @Override
  public Payment getPaymentByPaymentType(Payment payment) {
    return null;
  }

}
