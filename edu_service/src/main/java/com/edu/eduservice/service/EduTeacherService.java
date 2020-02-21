package com.edu.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.eduservice.entity.query.QueryTeacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 袁忠贵
 * @since 2020-02-18
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * 条件查询带分页
     */
    void pageListCondition(Page<EduTeacher> teacherPage, QueryTeacher queryTeacher);
}
