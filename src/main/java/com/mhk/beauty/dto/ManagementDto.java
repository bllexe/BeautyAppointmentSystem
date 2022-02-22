package com.mhk.beauty.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagementDto {

  private Long id;

  private String name;

  private String password;

  private String email;

  private String phoneNumber;

  private List<StaffDto> staff;

}
