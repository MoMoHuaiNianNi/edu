package com.edu.eduservice.controller;

import com.edu.common.R;
import com.edu.eduservice.entity.query.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public R teacherLogin(@RequestBody LoginUser loginUser) {
        if (!StringUtils.isEmpty(loginUser.getUsername()) && !StringUtils.isEmpty(loginUser.getPassword())
                && "admin".equals(loginUser.getUsername()) && "admin123".equals(loginUser.getPassword())) {
            return R.ok().data("token", "admin");
        } else {
            return R.error();
        }
    }

    /**
     * 讲师登录
     */
    @GetMapping("teacherInfo")
    public R teacherInfo() {
        return R.ok().data("roles", "[\"admin\"]")
                .data("name", "admin")
                .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    /**
     * 讲师登录
     */
    @PostMapping("teacherLogout")
    public R teacherLogout() {
        return R.ok();
    }
}
