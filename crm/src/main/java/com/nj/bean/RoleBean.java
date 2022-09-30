package com.nj.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleBean {

  private Integer rid;
  private String rolename;
  private Integer status;

}
