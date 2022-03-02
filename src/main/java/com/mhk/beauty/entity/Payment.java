package com.mhk.beauty.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal totalAmount;

  private BigDecimal paidAmount;

  @CreationTimestamp
  private Date paidDate;

  @UpdateTimestamp
  private Date updatedDate;

  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  @ManyToOne
  private Client client;

  private Boolean isPaid = Boolean.FALSE;

}
