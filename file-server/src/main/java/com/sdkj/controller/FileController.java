package com.sdkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author wangshuo
 * @Date 2022/5/18, 17:40
 * Please add a comment
 */
@Controller
@RequestMapping(value = "/file")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class FileController {

    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public String uploadFail(MultipartFile bigHeadImg) throws IOException {

        //获取后缀名
        String lastName = bigHeadImg.getOriginalFilename().substring(bigHeadImg.getOriginalFilename().lastIndexOf("."));
        //分日期存放
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String formatDate = simpleDateFormat.format(date);
        //文件转存
        String dir = "D:\\file-upload-warehouse\\" + formatDate;
        File file = new File(dir + "\\" + UUID.randomUUID().toString() + lastName);
        //文件夹操作
        if (!file.exists())
            file.mkdirs();
        //直接将文件存放到指定目录
        bigHeadImg.transferTo(file);
        return "success";
    }
}
