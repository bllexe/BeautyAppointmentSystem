package com.mhk.beauty.entity;

import com.sun.istack.NotNull;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  @CreationTimestamp
  private Date dateCreated;

  private Date appointmentStartTime;

  private Date appointmentEndTime;

  @ManyToOne // buraya client_id ekle
  private Client client;

  @ManyToOne
  private Management management;

  @ManyToOne
  private Payment payment;

}
