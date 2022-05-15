package com.spb.houqin.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FileUploadUtils {

    public static Map upload(MultipartFile file, String path, String src) throws IOException {
        Map res = new HashMap();
        //上传文件路径
//        String path = servletRequest.getServletContext().getRealPath("D:/logs/upload");
//        String path = "D:/logs/upload";
//        System.out.println(path);
//        System.out.println("文件名称"+file.getOriginalFilename());
        //上传文件名
        String name = file.getOriginalFilename();//上传文件的真实名称

        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        // String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        String hash = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = hash + suffixName;
        File filepath = new File(path, fileName);
//        System.out.println("随机数文件名称"+filepath.getName());
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        // resUrl.put("src", tempFile.getPath());
        res.put("code", "0");
        res.put("msg", "");
        res.put("data", src + "/image/" + tempFile.getName());

        return res;
    }


    /**
    * 富文本上传
    */
    public static Map uploadEdit(MultipartFile file, String path, String src) throws IOException {
        Map res = new HashMap();
        //上传文件路径
//        String path = servletRequest.getServletContext().getRealPath("D:/logs/upload");
//        String path = "D:/logs/upload";
//        System.out.println(path);
//        System.out.println("文件名称"+file.getOriginalFilename());
        //上传文件名
        String name = file.getOriginalFilename();//上传文件的真实名称

        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        // String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        String hash = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = hash + suffixName;
        File filepath = new File(path, fileName);
//        System.out.println("随机数文件名称"+filepath.getName());
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        // resUrl.put("src", tempFile.getPath());
        res.put("code", "0");
        res.put("msg", "");

        Map map = new HashMap();
        map.put("src",src + "/image/" + tempFile.getName());
        res.put("data",map );

        return res;
    }
}
