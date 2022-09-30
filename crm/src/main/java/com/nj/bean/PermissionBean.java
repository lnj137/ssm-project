package com.nj.bean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class PermissionBean {

  private Integer pid;
  private String pname;
  private String url;
  private Integer parentid;
  private Integer status;
  private List<PermissionBean> children;

}
