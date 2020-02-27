package com.edu.eduservice.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.edu.eduservice.handler.ConstantPropertiesUtil;
import com.edu.eduservice.service.FileService;
import com.edu.eduservice.utils.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author 袁忠贵
 * @date 2020/2/26
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String imgUpload(MultipartFile file) {
        // 获取properties中的配置
        String endpoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String fileHost = ConstantPropertiesUtil.FILE_HOST;

        try {
            // 获取文件名称
            String filename = UUIDGenerator.generate() + file.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = file.getInputStream();
            // 创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 拼接文件上传路径
            String filePath = fileHost + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/" + filename;
            // 创建PutObjectRequest对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filePath, inputStream);
            // 上传文件
            ossClient.putObject(putObjectRequest);
            // 关闭OSSClient
            ossClient.shutdown();
            // 拼接文件的浏览路径
            String path = "http://" + bucketName + "." + endpoint + "/" + filePath;
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
