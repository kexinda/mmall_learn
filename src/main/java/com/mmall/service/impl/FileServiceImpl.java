package com.mmall.service.impl;


import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by kexi955 on 5/6/2024.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService{
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);



    public String upload(MultipartFile file, String path){
        String filename = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        //filename.lastIndexOf(".") return jpg
        String fileExtensionName = filename.substring(filename.lastIndexOf(".") + 1);
        //prevent filename from repetition
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("start upload file, uploaded filename :{}, upload path: {}, new file name: {}", filename,  path, uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            //file transferred to target folder
            //TODO upload targetFIle to FTP server
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //TODO delete upload file after uploading
            targetFile.delete();

        } catch (IOException e) {
            logger.error("upload file error", e);
            return null;
        }

        return targetFile.getName();
    }


}
