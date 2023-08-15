package com.lsy.ibook.controller;

import com.lsy.ibook.bean.User;
import com.lsy.ibook.service.UserService;
import com.lsy.ibook.util.UUIDUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUpload {
    @Resource
    private UserService userService;

    @RequestMapping("/pic/{yhbh}")
    public String doUpload(MultipartFile yhtx,@PathVariable String yhbh) throws IOException {
        String fileName = "";
        if(!yhtx.isEmpty()){
            // 获取文件名
            fileName = yhtx.getOriginalFilename();
            // 通过 uuid, 设置新的文件名(解决同名文件上传覆盖的问题)
            fileName = UUIDUtil.getUUID() + fileName.substring(fileName.lastIndexOf("."));
            // 创建目标文件
            File file = new File(fileName);
            // 将图片保存到目标文件中
            yhtx.transferTo(file);

            // 更新数据库中的 yhtx
            User user = new User();
            user.setYhbh(yhbh);
            user.setYhtx(fileName);
            userService.updateUser(user);
        }
        return fileName;
    }
}
