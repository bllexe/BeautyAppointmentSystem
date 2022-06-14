package com.mhk.beauty.repository;

import com.mhk.beauty.entity.Payment;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findByClientId(Long clientId);


  @Query(value = "select  sum(a.paidAmount) from Payment a where a.client.id = :clientId")
  BigDecimal getTotalPaid(@Param("clientId") Long clientId);

}
