package com.edu.eduservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件 服务接口
 *
 * @author 袁忠贵
 * @date 2020/2/26
 */
public interface FileService {
    /**
     * 图片上传功能
     *
     * @param file
     * @return {@link null}
     */
    String imgUpload(MultipartFile file);
}
