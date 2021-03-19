package com.lml.model;


import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private long state;
    private Date createTime;
    private Date updateTime;
    private long tempVipFlag;
    private long delFlag;
    private long role;
    private long pic;
    private long type;
    private String extend1;
    private String extend2;


}
