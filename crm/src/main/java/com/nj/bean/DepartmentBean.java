package com.nj.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentBean {
  private Integer did;
  private String dname;
  private Integer status;

}
