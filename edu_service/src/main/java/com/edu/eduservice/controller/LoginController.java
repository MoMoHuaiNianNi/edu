package com.edu.eduservice.controller;

import com.edu.common.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户登录
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/22
 */
@RestController
@RequestMapping("/login/")
@CrossOrigin
public class LoginController {

    /**
     * 讲师登录
     */
    @PostMapping("teacherLogin")
    public R teacherLogin(@Param("username") String username, @Param("password") String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)
                && "admin".equals(username) && "admin".equals(password)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
