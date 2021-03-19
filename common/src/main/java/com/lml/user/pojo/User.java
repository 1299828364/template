package com.lml.user.pojo;


public class User {

  private long userId;
  private String userName;
  private String password;
  private String phone;
  private long state;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long tempVipFlag;
  private long delFlag;
  private long role;
  private long pic;
  private long type;
  private String extend1;
  private String extend2;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public long getTempVipFlag() {
    return tempVipFlag;
  }

  public void setTempVipFlag(long tempVipFlag) {
    this.tempVipFlag = tempVipFlag;
  }


  public long getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(long delFlag) {
    this.delFlag = delFlag;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }


  public long getPic() {
    return pic;
  }

  public void setPic(long pic) {
    this.pic = pic;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public String getExtend1() {
    return extend1;
  }

  public void setExtend1(String extend1) {
    this.extend1 = extend1;
  }


  public String getExtend2() {
    return extend2;
  }

  public void setExtend2(String extend2) {
    this.extend2 = extend2;
  }

}
