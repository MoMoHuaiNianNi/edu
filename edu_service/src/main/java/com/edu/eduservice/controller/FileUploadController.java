package com.edu.eduservice.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.edu.common.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * <p>
 * 文件上传控制类
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/26
 */
@RestController
@RequestMapping("/FileUpload")
@CrossOrigin
public class FileUploadController {

    @PostMapping("/upload")
    public R upload() {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "<yourAccessKeyId>";
        String accessKeySecret = "<yourAccessKeySecret>";

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象
        PutObjectRequest putObjectRequest = new PutObjectRequest("<yourBucketName>", "<yourObjectName>", new File("<yourLocalFile>"));

        // 上传文件
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();

        return R.ok();
    }

}
