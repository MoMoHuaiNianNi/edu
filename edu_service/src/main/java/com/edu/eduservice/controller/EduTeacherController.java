package com.edu.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.common.R;
import com.edu.eduservice.entity.EduTeacher;
import com.edu.eduservice.entity.query.QueryTeacher;
import com.edu.eduservice.service.EduTeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 袁忠贵
 * @since 2020-02-18
 */
@RestController
@RequestMapping("/eduService/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;


    /**
     * 根据id修改讲师信息
     */
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 根据id查询讲师信息
     */
    @GetMapping("getTeacherInfo/{id}")
    public R getTeacherInfo(@PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("eduTeacher", eduTeacher);
    }

    /**
     * 添加讲师信息
     */
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean b = eduTeacherService.save(eduTeacher);
        if (b) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 多条件带分页组合查询讲师信息
     */
    @PostMapping("moreConditionPageList/{page}/{limit}")
    public R getMoreConditionPageList(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) QueryTeacher queryTeacher) {
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        eduTeacherService.pageListCondition(teacherPage, queryTeacher);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        if (records != null) {
            return R.ok().data("total", total).data("items", records);
        } else {
            return R.error();
        }
    }

    /**
     * 分页查询讲师列表信息
     */
    @GetMapping("pageList/{page}/{limit}")
    public R getPageTeacherList(@PathVariable Long page, @PathVariable Long limit) {
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        eduTeacherService.page(teacherPage, null);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        return R.ok().data("total", total).data("items", records);
    }

    /**
     * 查询所有教师列表信息
     */
    @GetMapping("getTeacherList")
    public R getTeacherList() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("data", list);
    }

    /**
     * 根据ID逻辑删除讲师信息
     */
    @DeleteMapping("{id}")
    public R logicalDeletion(@PathVariable String id) {
        boolean b = eduTeacherService.removeById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }


}

