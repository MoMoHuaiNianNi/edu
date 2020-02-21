package com.edu.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.eduservice.entity.EduTeacher;
import com.edu.eduservice.entity.query.QueryTeacher;
import com.edu.eduservice.mapper.EduTeacherMapper;
import com.edu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 袁忠贵
 * @since 2020-02-18
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    /**
     * 条件查询带分页
     */
    @Override
    public void pageListCondition(Page<EduTeacher> teacherPage, QueryTeacher queryTeacher) {
        // 校验查询条件是否为空
        if (queryTeacher == null) {
            baseMapper.selectPage(teacherPage, null);
            return;
        }

        // 查询条件不为空,获取查询条件
        String name = queryTeacher.getName();
        String level = queryTeacher.getLevel();
        String beginTime = queryTeacher.getBeginTime();
        String endTime = queryTeacher.getEndTime();

        // 判断查询条件是否存在，拼接查询条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("gmt_create", beginTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            wrapper.le("gmt_create", endTime);
        }
        baseMapper.selectPage(teacherPage, wrapper);

    }
}
