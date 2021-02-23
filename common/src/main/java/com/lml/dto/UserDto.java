package com.lml.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述: 用户DTO
 *
 * @Auther: lml
 * @Date: 2019/7/9 13:57
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;

    private String password;

}