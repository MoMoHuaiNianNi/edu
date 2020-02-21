package com.edu.eduservice.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 处理新增和更新的基础数据填充
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/18
 */
@Component
public class MetaHandler implements MetaObjectHandler {
    private static final Logger logger = LoggerFactory.getLogger(MetaHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
        this.setFieldValByName("isDelete", false, metaObject);
        this.setFieldValByName("version", 1L, metaObject);
        this.setFieldValByName("sort", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
