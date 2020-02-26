package com.edu.eduservice.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 常量类，读取配置文件application.properties中的配置
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/26
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${aLiYun.oss.file.endPoint}")
    private String endpoint;
    @Value("${aLiYun.oss.file.keyId}")
    private String accessKeyId;
    @Value("${aLiYun.oss.file.keySecret}")
    private String accessKeySecret;
    @Value("${aLiYun.oss.file.bucketName}")
    private String bucketName;
    @Value("${aLiYun.oss.file.fileHost}")
    private String fileHost;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String FILE_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        BUCKET_NAME = bucketName;
        FILE_HOST = fileHost;
    }
}
