package net.xdclass.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

public interface FileService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String uploadUserImg(MultipartFile file);
}
