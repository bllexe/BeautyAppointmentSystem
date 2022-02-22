package com.mhk.beauty.dto;

import com.mhk.beauty.entity.Staff;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
  
  private Long id;

  private String name;

  private String surname;

  private String address;

  private String email;

  private String jobTitle;

  private String phoneNumber;

  private int age;

  private String description;

  private Date dateCreated;

  private Date lastUpdated;

  private StaffDto staff;

}
