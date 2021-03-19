package com.lml.user.pojo;


public class Video {

  private long id;
  private String videoName;
  private String videoDescribe;
  private long cover;
  private long resourceId;
  private long delFlag;
  private java.sql.Timestamp updateTime;
  private java.sql.Timestamp createTime;
  private long status;
  private long clickTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getVideoName() {
    return videoName;
  }

  public void setVideoName(String videoName) {
    this.videoName = videoName;
  }


  public String getVideoDescribe() {
    return videoDescribe;
  }

  public void setVideoDescribe(String videoDescribe) {
    this.videoDescribe = videoDescribe;
  }


  public long getCover() {
    return cover;
  }

  public void setCover(long cover) {
    this.cover = cover;
  }


  public long getResourceId() {
    return resourceId;
  }

  public void setResourceId(long resourceId) {
    this.resourceId = resourceId;
  }


  public long getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(long delFlag) {
    this.delFlag = delFlag;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getClickTime() {
    return clickTime;
  }

  public void setClickTime(long clickTime) {
    this.clickTime = clickTime;
  }

}
