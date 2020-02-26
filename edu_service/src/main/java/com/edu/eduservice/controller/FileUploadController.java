package com.edu.eduservice.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.edu.common.R;
import com.edu.eduservice.handler.ConstantPropertiesUtil;
import com.edu.eduservice.service.FileService;
import com.edu.eduservice.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    private FileService fileService;


    @PostMapping("/imgUpload")
    public R imgUpload(@RequestParam("file") MultipartFile file) {
        String path = fileService.imgUpload(file);
        if (!StringUtils.isEmpty(path)) {
            return R.ok().data("imgUrl", path);
        } else {
            return R.error();
        }
    }

}
