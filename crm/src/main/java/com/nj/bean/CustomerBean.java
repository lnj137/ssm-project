package com.nj.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class CustomerBean {
  private Integer cid;
  private Integer companyid;
  private String cname;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date birth;
  private Integer sex;
  private String address;
  private String phone;
  private String email;
  private Integer status;
  private CompanyBean company;

}
