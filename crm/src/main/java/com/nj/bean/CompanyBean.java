package com.nj.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyBean {

  private Integer companyid;
  private String cname;
  private String address;
  private String bussiness;
  private String money;
  private Integer status;

}
