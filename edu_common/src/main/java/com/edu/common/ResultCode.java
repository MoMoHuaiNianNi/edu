package com.edu.common;

/**
 * 状态码定义
 *
 * @author 袁忠贵
 * @date 2020/2/18
 */
public interface ResultCode {
    /**
     * 成功状态码
     */
    int SUCCESS = 20000;
    /**
     * 失败状态码
     */
    int ERROR = 20001;
    /**
     * 没有操作权限状态码
     */
    int AUTH = 30000;
}
