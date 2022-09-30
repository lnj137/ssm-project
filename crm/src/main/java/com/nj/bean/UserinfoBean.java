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
public class UserinfoBean {

  private Integer userid;
  private Integer did;
  private String username;
  private String password;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date birth;
  private Double salary;
  private String phone;
  private String address;
  private Integer sex;
  private Integer status;
  private String realname;
  private DepartmentBean dept;
  private String headimg;
  private Integer isadmin;

}
