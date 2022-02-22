package com.mhk.beauty.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {

  private Long id;

  private String username;

  private String password;

  private List<ClientDto> clients;

  private ManagementDto management;
}
