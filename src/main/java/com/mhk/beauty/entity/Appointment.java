package com.mhk.beauty.entity;

import com.mhk.beauty.entity.enums.AppointmentStatus;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
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
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicUpdate
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  @Column(name = "date_created")
  @CreationTimestamp
  private Date dateCreated;

  @UpdateTimestamp
  private Date dateUpdated;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private AppointmentStatus status;

  @ManyToOne // buraya client_id ekle
  private Client client;

  @ManyToOne
  private Staff staff;

 /* @ManyToOne
  private Payment payment;*/


}
