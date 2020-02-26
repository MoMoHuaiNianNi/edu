package com.edu.eduservice.entity.query;

import lombok.Data;

/**
 * <p>
 * 用户登录条件封装
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/25
 */
@Data
public class LoginUser {
    /**
     * 用户名
     */
    String username;
    /**
     * 密码
     */
    String password;
}
