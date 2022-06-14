package com.mhk.beauty.entity.dto;

import com.mhk.beauty.entity.Client;
import com.mhk.beauty.entity.Payment;
import com.mhk.beauty.entity.enums.PaymentType;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {

  private BigDecimal paidAmount;

  private PaymentType paymentType;

  @CreationTimestamp
  private Date paidDate;

  @UpdateTimestamp
  private Date updatedDate;

  private Client client;


  public PaymentResponseDto(Payment payment) {
    this.setPaidAmount(payment.getPaidAmount());
    this.setPaymentType(payment.getPaymentType());
    this.setPaidDate(payment.getPaidDate());
    this.setUpdatedDate(payment.getUpdatedDate());
    this.setClient(payment.getClient());
  }
}
