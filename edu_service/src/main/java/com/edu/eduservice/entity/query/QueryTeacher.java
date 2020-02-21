package com.edu.eduservice.entity.query;

import lombok.Data;

/**
 * <p>
 * 用于封装条件值
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/18
 */
@Data
public class QueryTeacher {
    String name;
    String level;
    /**
     * 开始时间
     */
    String beginTime;
    /**
     * 结束时间
     */
    String endTime;
}
