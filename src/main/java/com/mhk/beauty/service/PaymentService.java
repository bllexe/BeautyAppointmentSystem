package com.mhk.beauty.service;

import com.mhk.beauty.entity.Payment;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {

  Payment save(Long clientId, Payment payment);

  List<Payment> findByClientId(Long clientId);

  Page<Payment> getAllPayments(Pageable pageable);

  BigDecimal countRemainingAmount(Long clientId);
}
