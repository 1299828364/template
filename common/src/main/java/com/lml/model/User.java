package com.lml.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 18716
 */
@Entity(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String password;

    private String phone;

    private int tempVipFlag;

    private Date createTime;

    private Date vipDeadLine;

    private int delFlag;

    private int state;

    private int pic;

    private String picUrl;
}
