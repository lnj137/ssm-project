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
public class RecoderBean {
  //跟踪记录中有用户信息和客户信息
  private Integer recoderid;
  private Integer userid;
  private Integer cid;
  @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss",timezone = "GMT+8")
  private Date createtime;
  private String remark;
  private Integer status;
  private UserinfoBean user;
  private CustomerBean customer;

}
