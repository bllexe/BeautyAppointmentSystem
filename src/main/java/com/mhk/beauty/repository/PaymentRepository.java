package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findByClientId(Long clientId);
}
